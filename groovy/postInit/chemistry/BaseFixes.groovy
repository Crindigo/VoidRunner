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

// make pyro oven use LV components
crafting.replaceShaped('gregtech:pyrolyse_oven', metaitem('pyrolyse_oven'), [
    [metaitem('electric.piston.lv'), ore('circuitLv'), ore('wireGtQuadrupleCupronickel')],
    [ore('circuitLv'), metaitem('hull.lv'), ore('circuitLv')],
    [metaitem('electric.piston.lv'), metaitem('electric.pump.lv'), ore('wireGtQuadrupleCupronickel')]
]);