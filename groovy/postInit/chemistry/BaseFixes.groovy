package chemistry;

// why is it only LV to *melt carbon*
mods.gregtech.extractor.removeByInput(30, [metaitem('plateCarbon')], null)
mods.gregtech.extractor.removeByInput(30, [metaitem('dustCarbon')], null)

mods.gregtech.extractor.recipeBuilder()
    .inputs(metaitem('plateCarbon'))
    .fluidOutputs(fluid('carbon') * 144)
    .EUt(480)
    .duration(200)
    .buildAndRegister();

mods.gregtech.extractor.recipeBuilder()
    .inputs(metaitem('dustCarbon'))
    .fluidOutputs(fluid('carbon') * 144)
    .EUt(480)
    .duration(200)
    .buildAndRegister();