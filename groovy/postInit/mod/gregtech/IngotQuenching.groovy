package mod.gregtech;

mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(ore('ingotHotBlackBronze'))
    .fluidInputs(fluid('water') * 100)
    .outputs(metaitem('ingotBlackBronze'))
    .duration(300)
    .EUt(120)
    .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(ore('ingotHotBlackBronze'))
    .fluidInputs(fluid('distilled_water') * 100)
    .outputs(metaitem('ingotBlackBronze'))
    .duration(200)
    .EUt(120)
    .buildAndRegister();