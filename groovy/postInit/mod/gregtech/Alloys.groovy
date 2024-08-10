package postInit.mod.gregtech;

mods.gregtech.mixer.recipeBuilder()
    .circuitMeta(4)
    .inputs(ore('dustIron'), ore('dustNickel') * 4)
    .outputs(metaitem('voidrunner:dustPermalloy') * 5)
    .EUt(7)
    .duration(500)
    .buildAndRegister();