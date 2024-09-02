package postInit.mod.gregtech;

mods.gregtech.mixer.recipeBuilder()
    .circuitMeta(4)
    .inputs(ore('dustIron'), ore('dustNickel') * 4)
    .outputs(metaitem('voidrunner:dustPermalloy') * 5)
    .EUt(7)
    .duration(500)
    .buildAndRegister();

// alternate soldering alloy so bismuth has a use (rose metal)
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustBismuth') * 2, ore('dustLead'), ore('dustTin'))
    .outputs(metaitem('dustSolderingAlloy') * 4)
    .EUt(7)
    .duration(200)
    .buildAndRegister();