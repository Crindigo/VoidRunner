import gregtech.api.GTValues;

// Dirt * 1
mods.gregtech.macerator.removeByInput(2, [metaitem('bio_chaff')], null)
mods.gregtech.macerator.recipeBuilder()
    .inputs(metaitem('bio_chaff'))
    .outputs(item('minecraft:dirt') * 2)
    .duration(300)
    .EUt(2)
    .buildAndRegister()

/* just testing
mods.gregtech.canner.recipeBuilder()
    .inputs(item('botania:manatablet'))
    .fluidInputs(fluid('mana') * 8000)
    .outputs(item('botania:manatablet').withNbt(["mana": 500000i]))
    .duration(1200)
    .EUt(GTValues.VA[GTValues.UHV])
    .buildAndRegister();
*/

// compressor: 8x plant fiber -> plant ball
mods.gregtech.compressor.recipeBuilder()
    .inputs(item('pyrotech:material', 12) * 8)
    .outputs(metaitem('plant_ball'))
    .duration(300)
    .EUt(2)
    .buildAndRegister()

// compressor: 8x leaves -> plant ball
mods.gregtech.compressor.recipeBuilder()
    .inputs(ore('treeLeaves') * 8)
    .outputs(metaitem('plant_ball'))
    .duration(300)
    .EUt(2)
    .buildAndRegister()


// change macerator recipe to avoid diamonds, same with rock breaker
crafting.remove('gregtech:steam_macerator_bronze');
crafting.shapedBuilder()
    .name('steam_macerator_bronze')
    .output(metaitem('steam_macerator_bronze'))
    .shape('PGP',
           'PHP',
           'SPS')
    .key('P', ore('pipeSmallFluidBronze'))
    .key('G', ore('gearPotin'))
    .key('H', item('gregtech:steam_casing'))
    .key('S', ore('craftingPiston'))
    .register();

// need to come up with wrought iron method. maybe PBF for wrought, regular furnace for iron?
// fuck it let's use granite
/*recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustIron') * 4, ore('dustGranite'))
    .outputs(metaitem('dustWroughtIron') * 4)
    .duration(100)
    .EUt(7)
    .buildAndRegister();
*/

/*
recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustStone'))
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('stone_extract') * 1000)
    .duration(40)
    .EUt(16)
    .buildAndRegister();
*/

mods.gregtech.sifter.recipeBuilder()
    .inputs(item('minecraft:dirt'))
    .outputs(item('minecraft:clay_ball') * 2) // clay, grass seeds, bone
    //.outputs(metaitem('voidrunner:fine_dirt') * 2)
    .chancedOutput(item('minecraft:bone'), 5000, 0)
    .chancedOutput(item('randomthings:grassseeds'), 1500, 0)
    .chancedOutput(item('gregtech:rubber_sapling'), 1500, 0)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// update ulv conveyor to take carpet instead of rubber sheet
// might revert if it's not a big deal to delay automation
crafting.remove('ulv_covers:conveyor_ulv_easy');
crafting.addShaped('ulv_conveyor', metaitem('ulv_covers:conveyor.module.ulv'), [
    [item('minecraft:carpet'), metaitem('wireGtSingleTin')],
    [metaitem('ulv_covers:electric.motor.ulv'), item('minecraft:carpet')]
]);

// update ulv pump to take iron ring instead of rubber
crafting.remove('ulv_covers:pump_ulv_easy');
crafting.addShaped('ulv_pump', metaitem('ulv_covers:electric.pump.ulv'), [
    [ore('pipeNormalFluidCopper'), ore('rotorBronze')],
    [metaitem('ulv_covers:electric.motor.ulv'), ore('ringIron')]
]);

// allow for ulv and lv hatches and buses to have standard crafting recipes instead of assembler only
def removeULVHatchBus(chestOrGlass, configuration) {
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('glue') * 250])
    mods.gregtech.assembler.removeByInput(7,
        [metaitem('hull.ulv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('plastic') * 72])
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])],
        [fluid('polytetrafluoroethylene') * 36])
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('polybenzimidazole') * 4])
}

removeULVHatchBus('minecraft:chest', 1);
removeULVHatchBus('minecraft:chest', 2);
removeULVHatchBus('minecraft:glass', 1);
removeULVHatchBus('minecraft:glass', 2);

def removeLVHatchBus(chestOrGlass, configuration) {
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('glue') * 500])
    mods.gregtech.assembler.removeByInput(30,
        [metaitem('hull.lv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('plastic') * 144])
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])],
        [fluid('polytetrafluoroethylene') * 72])
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), metaitem('circuit.integrated').withNbt(["Configuration": configuration])], 
        [fluid('polybenzimidazole') * 9])
}

removeLVHatchBus('minecraft:chest', 1);
removeLVHatchBus('minecraft:chest', 2);
removeLVHatchBus('minecraft:glass', 1);
removeLVHatchBus('minecraft:glass', 2);


def tierNames = ['ulv', 'lv'];
for ( tierName in tierNames ) {
    crafting.addShaped("${tierName}_import_hatch", metaitem("fluid_hatch.import.${tierName}"), [
        [null, ore('blockGlass'), null],
        [null, metaitem("hull.${tierName}"), null]
    ]);
    crafting.addShaped("${tierName}_export_hatch", metaitem("fluid_hatch.export.${tierName}"), [
        [null, metaitem("hull.${tierName}"), null],
        [null, ore('blockGlass'), null]
    ]);
    crafting.addShaped("${tierName}_import_bus", metaitem("item_bus.import.${tierName}"), [
        [null, ore('chestWood'), null],
        [null, metaitem("hull.${tierName}"), null]
    ]);
    crafting.addShaped("${tierName}_export_bus", metaitem("item_bus.export.${tierName}"), [
        [null, metaitem("hull.${tierName}"), null],
        [null, ore('chestWood'), null]
    ]);
}

// wooden crate just 8 planks surrounding saw
crafting.remove('gregtech:wooden_crate');
// Wooden Crate * 1
mods.gregtech.assembler.removeByInput(16, [metaitem('plateWood') * 4, metaitem('screwIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 5])], null)
crafting.addShaped('wooden_crate', metaitem('crate.wood'), [
    [ore('plankWood'), ore('plankWood'), ore('plankWood')],
    [ore('plankWood'), ore('toolSaw'), ore('plankWood')],
    [ore('plankWood'), ore('plankWood'), ore('plankWood')]
]);

// Charcoal * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:log', 32767)], null)
// Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal')], null)
// Block of Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal_block')], null)

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('logWood'))
    .outputs(item('minecraft:coal', 1))
    .fluidOutputs(fluid('wood_tar') * 100)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal', 1))
    .outputs(item('minecraft:coal'))
    .fluidOutputs(fluid('creosote') * 150)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('blockCharcoal'))
    .outputs(item('minecraft:coal_block'))
    .fluidOutputs(fluid('creosote') * 1350)
    .duration(2700)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal'))
    .outputs(metaitem('gemCoke'))
    .fluidOutputs(fluid('creosote') * 200)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal_block'))
    .outputs(metaitem('blockCoke'))
    .fluidOutputs(fluid('creosote') * 1800)
    .duration(2700)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stone'))
    .outputs(item('pyrotech:rock', 0) * 4)
    .fluidOutputs(fluid('stone_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneGranite'))
    .outputs(item('pyrotech:rock', 1) * 4)
    .fluidOutputs(fluid('granite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneDiorite'))
    .outputs(item('pyrotech:rock', 2) * 4)
    .fluidOutputs(fluid('diorite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneAndesite'))
    .outputs(item('pyrotech:rock', 3) * 4)
    .fluidOutputs(fluid('andesite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneLimestone'))
    .outputs(item('pyrotech:rock', 8) * 4)
    .fluidOutputs(fluid('limestone_extract') * 500)
    .duration(600)
    .buildAndRegister();

// 4 steel botany growers = 4 resin = 12 raw rubber pulp per minute
// 8 leaves/minute = 1 dirt/minute
// 1 crucible averages 4 sulfur/minute
// this lines up to make 4 rubber per minute. w/ alloy smelter it's 2 rubber sheet per minute.
// reminder that this is just to passive rubber, you could manually chop rubber trees to go faster than the BGs.
// with chem reactor we get 9 raw rubber + 1 sulfur = 9 fluid rubber. this becomes 12 rubber per minute (6x faster for sheets)
// move these notes to LV:
// botany growers are great for this, greenhouses better for benzene production as you need like 4 logs per second there.
// at 1 log/second you get 3500 wood tar/16 seconds (or 20 with bad coils) => 1225 benzene/16|20 seconds => 1347|1078 eu/t of benzene.
// maybe aim for 2 GH per pyro oven. this is a nerf compared to gtcp so maybe let it be stronger or else do something custom like
// give it a CO2 level and pump in CO2 to speed up the recipe. maybe require 1 fertilizer to get 64 logs/minute, and pump in 100L/s
// of CO2 to cut the duration in half. with that you'd be at 1 GH per 2 oven which makes sense due to GH being larger.
