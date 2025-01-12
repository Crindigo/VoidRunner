package postInit.steam;

import gregtech.api.GTValues;
import gregtech.common.metatileentities.steam.boiler.SteamLavaBoiler

//SteamLavaBoiler.setBoilerFuelToConsumption(fluid('ethanol').getFluid(), 200);

// use alloy smelter
crafting.remove('gregtech:compressed_coke_clay');

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

// plant grinding for redstone and sulfur
mods.gregtech.macerator.recipeBuilder()
    .inputs(item('plants2:cosmetic_0', 8))
    .outputs(item('minecraft:redstone') * 2)
    .duration(200)
    .EUt(2)
    .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
    .inputs(item('plants2:cosmetic_3', 4))
    .outputs(metaitem('dustSulfur') * 2)
    .duration(200)
    .EUt(2)
    .buildAndRegister();


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

// change diamond in steam rock breaker to gearSmallBronze
crafting.remove('gregtech:steam_rock_breaker_bronze');
crafting.shapedBuilder()
    .name('steam_rock_breaker_bronze')
    .output(metaitem('steam_rock_breaker_bronze'))
    .shape('PpP', 'pcp', 'gpg')
    .key('P', ore('craftingPiston'))
    .key('p', ore('pipeSmallFluidBronze'))
    .key('c', item('gregtech:steam_casing'))
    .key('g', ore('gearSmallBronze'))
    .register();

// change invar gear in steam oven to iron gear
crafting.remove('gregtech:steam_oven');
crafting.shapedBuilder()
    .name('steam_oven')
    .output(metaitem('steam_oven'))
    .shape('cgc', 'fmf', 'cgc')
    .key('c', item('gregtech:metal_casing'))
    .key('g', ore('gearIron'))
    .key('f', item('gregtech:boiler_firebox_casing'))
    .key('m', metaitem('steam_furnace_bronze'))
    .register();

/*
recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustStone'))
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('stone_extract') * 1000)
    .duration(40)
    .EUt(16)
    .buildAndRegister();
*/

// rock breaker only for cobble until MV?
// then we forge hammer that for gravel source.
// sifter + compressor(s) for granite, diorite, andesite, limestone

// Stone * 1
mods.gregtech.rock_breaker.removeByInput(7, [item('minecraft:stone')], null);

mods.gregtech.rock_breaker.recipeBuilder()
    .notConsumable(item('minecraft:stone'))
    .outputs(item('minecraft:stone'))
    .duration(16)
    .EUt(60)
    .buildAndRegister();

mods.gregtech.rock_breaker.recipeBuilder()
    .notConsumable(item('pyrotech:limestone'))
    .outputs(item('pyrotech:limestone'))
    .duration(16)
    .EUt(60)
    .buildAndRegister();

// sand to 8x sand pile
mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(ore('sand'))
    .outputs(item('pyrotech:rock', 5) * 8)
    .duration(80)
    .EUt(2)
    .buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(item('minecraft:obsidian'))
    .outputs(item('pyrotech:material', 33) * 4)
    .duration(160)
    .EUt(16)
    .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
    .notConsumable(item('minecraft:dirt'))
    .outputs(item('pyrotech:material', 17)) // clay
    .outputs(item('pyrotech:rock', 0)) // stone
    .outputs(item('pyrotech:rock', 1)) // granite
    .outputs(item('pyrotech:rock', 2)) // diorite
    .outputs(item('pyrotech:rock', 3)) // andesite
    .outputs(item('pyrotech:rock', 8)) // limestone
    //.chancedOutput(item('minecraft:bone'), 5000, 0)
    //.chancedOutput(item('randomthings:grassseeds'), 1500, 0)
    //.chancedOutput(item('gregtech:rubber_sapling'), 1500, 0)
    .duration(50)
    .EUt(4)
    .buildAndRegister();

// coarse dirt sifting for... bonemeal and other things?
mods.gregtech.sifter.recipeBuilder()
    .inputs(item('minecraft:dirt', 1))
    .chancedOutput(item('minecraft:dye', 15), 5000, 750) // smelt to bone ash, centrifuge for CaO and P4O10
    .chancedOutput(metaitem('dustApatite'), 3000, 750)
    .chancedOutput(metaitem('dustPotash'), 3000, 750)
    .duration(100)
    .EUt(4)
    .buildAndRegister();

// podzol sifting for saplings
mods.gregtech.sifter.recipeBuilder()
    .inputs(item('minecraft:dirt', 2))
    .chancedOutput(item('minecraft:sapling', 1), 2500, 750)
    .chancedOutput(item('minecraft:sapling', 2), 2500, 750)
    .chancedOutput(item('minecraft:sapling', 3), 2500, 750)
    .chancedOutput(item('minecraft:sapling', 4), 2500, 750)
    .chancedOutput(item('minecraft:sapling', 5), 2500, 750)
    .chancedOutput(item('gregtech:rubber_sapling'), 2500, 750)
    .duration(200)
    .EUt(4)
    .buildAndRegister();

// compress rocks for stone, andesite, diorite, granite, limestone cobble
def rockCompression = [
    [item('minecraft:cobblestone'), item('pyrotech:rock', 0) * 8],
    [item('pyrotech:cobblestone', 0), item('pyrotech:rock', 3) * 8],
    [item('pyrotech:cobblestone', 1), item('pyrotech:rock', 2) * 8],
    [item('pyrotech:cobblestone', 2), item('pyrotech:rock', 1) * 8],
    [item('pyrotech:cobblestone', 3), item('pyrotech:rock', 8) * 8],
    [item('minecraft:clay_ball'), item('pyrotech:material', 17) * 4],
    [item('minecraft:flint'), item('pyrotech:material', 10) * 4],
    // add mud and dirt
];
for ( rockRecipe in rockCompression ) {
    mods.gregtech.compressor.recipeBuilder()
        .outputs(rockRecipe[0])
        .inputs(rockRecipe[1])
        .duration(10 * rockRecipe[1].getCount())
        .EUt(2)
        .buildAndRegister();
}

// update ulv conveyor to take carpet instead of rubber sheet
// also make ULV motors, conveyors and pumps return 4 items
crafting.remove('ulv_covers:motor_ulv_easy');
crafting.addShaped('ulv_motor', metaitem('ulv_covers:electric.motor.ulv') * 4, [
    [ore('wireGtSingleTin'), ore('stickBronze')],
    [ore('stickIronMagnetic'), ore('wireGtSingleTin')]
]);

crafting.remove('ulv_covers:conveyor_ulv_easy');
crafting.addShaped('ulv_conveyor', metaitem('ulv_covers:conveyor.module.ulv') * 4, [
    [item('minecraft:carpet'), metaitem('wireGtSingleTin')],
    [metaitem('ulv_covers:electric.motor.ulv'), item('minecraft:carpet')]
]);
crafting.addShaped('ulv_conveyor_rubber', metaitem('ulv_covers:conveyor.module.ulv') * 4, [
    [ore('plateRubber'), metaitem('wireGtSingleTin')],
    [metaitem('ulv_covers:electric.motor.ulv'), ore('plateRubber')]
]);

// update ulv pump to take iron ring instead of rubber
crafting.remove('ulv_covers:pump_ulv_easy');
crafting.addShaped('ulv_pump', metaitem('ulv_covers:electric.pump.ulv') * 4, [
    [ore('pipeNormalFluidCopper'), ore('rotorBronze')],
    [metaitem('ulv_covers:electric.motor.ulv'), ore('ringIron')]
]);

crafting.addShaped('ulv_pump_rubber', metaitem('ulv_covers:electric.pump.ulv') * 4, [
    [ore('pipeNormalFluidCopper'), ore('rotorBronze')],
    [metaitem('ulv_covers:electric.motor.ulv'), ore('ringRubber')]
]);

// update basic item and fluid filters, make them output 2x and add an iron variant instead of steel,
// and change lapis plate to copper.

def addFilterRecipe(name, centerItem, output) {
    def zf = ore('foilZinc');
    crafting.addShaped(name, output, [[zf, zf, zf], [zf, centerItem, zf], [zf, zf, zf]]);
}

crafting.remove('gregtech:item_filter');
crafting.remove('gregtech:fluid_filter_lapis');
crafting.remove('gregtech:fluid_filter_lazurite');
crafting.remove('gregtech:fluid_filter_sodalite');

mods.gregtech.arc_furnace.removeByInput(30, [metaitem('item_filter')], [fluid('oxygen') * 186]);
mods.gregtech.macerator.removeByInput(8, [metaitem('item_filter')], null)
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('fluid_filter')], [fluid('oxygen') * 130])
mods.gregtech.macerator.removeByInput(2, [metaitem('fluid_filter')], null)

addFilterRecipe('item_filter_steel', ore('plateSteel'), metaitem('item_filter') * 2);
addFilterRecipe('item_filter_iron', ore('plateIron'), metaitem('item_filter') * 2);
addFilterRecipe('fluid_filter_copper', ore('plateCopper'), metaitem('fluid_filter') * 2);
addFilterRecipe('fluid_filter_lapis', ore('plateLapis'), metaitem('fluid_filter') * 2);
addFilterRecipe('fluid_filter_lazurite', ore('plateLazurite'), metaitem('fluid_filter') * 2);
addFilterRecipe('fluid_filter_sodalite', ore('plateSodalite'), metaitem('fluid_filter') * 2);

def circuitConfig(number) {
    return metaitem('circuit.integrated').withNbt(["Configuration": number]);
}

// allow for ulv and lv hatches and buses to have standard crafting recipes instead of assembler only
def removeULVHatchBus(chestOrGlass, configuration) {
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), circuitConfig(configuration)], 
        [fluid('glue') * 250])
    mods.gregtech.assembler.removeByInput(7,
        [metaitem('hull.ulv'), item(chestOrGlass), circuitConfig(configuration)], 
        [fluid('plastic') * 72])
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), circuitConfig(configuration)],
        [fluid('polytetrafluoroethylene') * 36])
    mods.gregtech.assembler.removeByInput(7, 
        [metaitem('hull.ulv'), item(chestOrGlass), circuitConfig(configuration)], 
        [fluid('polybenzimidazole') * 4])
}

removeULVHatchBus('minecraft:chest', 1);
removeULVHatchBus('minecraft:chest', 2);
removeULVHatchBus('minecraft:glass', 1);
removeULVHatchBus('minecraft:glass', 2);

def removeLVHatchBus(chestOrGlass, configuration) {
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), circuitConfig(configuration)], 
        [fluid('glue') * 500])
    mods.gregtech.assembler.removeByInput(30,
        [metaitem('hull.lv'), item(chestOrGlass), circuitConfig(configuration)], 
        [fluid('plastic') * 144])
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), circuitConfig(configuration)],
        [fluid('polytetrafluoroethylene') * 72])
    mods.gregtech.assembler.removeByInput(30, 
        [metaitem('hull.lv'), item(chestOrGlass), circuitConfig(configuration)], 
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

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stone'))
    //.outputs(item('pyrotech:rock', 0) * 4)
    .fluidOutputs(fluid('stone_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneGranite'))
    //.outputs(item('pyrotech:rock', 1) * 4)
    .fluidOutputs(fluid('granite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneDiorite'))
    //.outputs(item('pyrotech:rock', 2) * 4)
    .fluidOutputs(fluid('diorite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneAndesite'))
    //.outputs(item('pyrotech:rock', 3) * 4)
    .fluidOutputs(fluid('andesite_extract') * 500)
    .duration(600)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('stoneLimestone'))
    //.outputs(item('pyrotech:rock', 8) * 4)
    .fluidOutputs(fluid('limestone_extract') * 500)
    .duration(600)
    .buildAndRegister();

crafting.remove('minecraft:coarse_dirt');

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('dirt'))
    .outputs(item('minecraft:dirt', 1)) // coarse dirt
    .fluidOutputs(fluid('dirt_extract') * 500)
    .duration(600)
    .buildAndRegister();

// half the dirt extract can be mixed w/ gravel for more dirt - done in soaking pot until LV then chemical bath

// Coke Oven Brick * 2
furnace.removeByInput(metaitem('compressed.coke_clay'));
mods.gregtech.alloy_smelter.removeByInput(7, [item('minecraft:sand'), item('minecraft:clay_ball')], null)
mods.gregtech.alloy_smelter.recipeBuilder()
    .inputs(ore('sand'))
    .inputs(item('minecraft:clay_ball'))
    .outputs(metaitem('brick.coke') * 2)
    .EUt(7)
    .duration(40)
    .buildAndRegister();


// Compressed Fireclay * 1
mods.gregtech.compressor.removeByInput(4, [metaitem('dustFireclay')], null);
mods.gregtech.compressor.recipeBuilder()
    .inputs(metaitem('dustFireclay'))
    .outputs(metaitem('compressed.fireclay'))
    .EUt(4)
    .duration(40)
    .buildAndRegister();

// this is fucking bugged as hell, just use the compressor to make flint from small flint
/*
mods.gregtech.macerator.recipeBuilder()
    .inputs(item('pyrotech:material', 10) * 4)
    .outputs(metaitem('dustFlint'))
    .duration(20) // 5 ticks bugs out large grinder
    .EUt(2)
    .buildAndRegister();
*/

recipemap('evap_pool').recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .outputs(metaitem('voidrunner:dustSaltEvaporate') * 8)
    .duration(1200)
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
