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



