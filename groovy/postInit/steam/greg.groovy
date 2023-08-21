// Dirt * 1
mods.gregtech.macerator.removeByInput(2, [metaitem('bio_chaff')], null)
mods.gregtech.macerator.recipeBuilder()
    .inputs(metaitem('bio_chaff'))
    .outputs(item('minecraft:dirt') * 2)
    .duration(300)
    .EUt(2)
    .buildAndRegister()

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

// need to come up with wrought iron method
// fuck it let's use granite
recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustIron') * 4, ore('dustGranite'))
    .outputs(metaitem('dustWroughtIron') * 4)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustStone'))
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('stone_solution') * 1000)
    .duration(40)
    .EUt(16)
    .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
    .inputs(item('minecraft:dirt'))
    .outputs(item('minecraft:clay_ball') * 2) // clay, grass seeds, bone
    .outputs(metaitem('voidrunner:fine_dirt') * 2)
    .chancedOutput(item('minecraft:bone'), 5000, 0)
    .chancedOutput(item('randomthings:grassseeds'), 1500, 0)
    .chancedOutput(item('gregtech:rubber_sapling'), 1500, 0)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// update ulv conveyor to take carpet instead of rubber sheet
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
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 4])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 4])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 4])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 4])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 500])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 144])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 72])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 9])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 500])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 144])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 72])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 9])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 500])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 144])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 72])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 9])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 500])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 144])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 72])
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 9])


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


// crude mix fine dirt and netherrack dust for 2 sulfur dust (or maybe 1 to line up with raw rubber)
// 4 steel botany growers = 4 resin = 12 raw rubber pulp per minute
// 8 leaves/minute = 1 dirt/minute = 2 fine dirt / minute. 2 dirt + 2 nether = 4 sulfur dust. prob have something at LV for better sulfur.
// this lines up to make 4 rubber per minute. w/ alloy smelter it's 2 rubber sheet per minute.
// reminder that this is just to passive rubber, you could manually chop rubber trees to go faster than the BGs.
// with chem reactor we get 9 raw rubber + 1 sulfur = 9 fluid rubber. this becomes 12 rubber per minute (6x faster for sheets)
// move these notes to LV:
// botany growers are great for this, greenhouses better for benzene production as you need like 4 logs per second there.
// at 1 log/second you get 3500 wood tar/16 seconds (or 20 with bad coils) => 1225 benzene/16|20 seconds => 1347|1078 eu/t of benzene.
// maybe aim for 2 GH per pyro oven.
