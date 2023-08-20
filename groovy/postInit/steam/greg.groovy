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
    .chancedOutput(item('minecraft:bone'), 5000, 500)
    .chancedOutput(item('randomthings:grassseeds'), 1500, 500)
    .chancedOutput(item('gregtech:rubber_sapling'), 1500, 500)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// update ulv conveyor to take carpet instead of rubber sheet


// update ulv pump to take iron ring instead of rubber


// allow for ulv and lv hatches and buses to have standard crafting recipes instead of assembler only