// Potassium Hydroxide

// mixer: 2 rock salt + 1000L water -> 1000L potassium chloride solution
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustRockSalt') * 2)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('potassium_chloride_solution') * 1000)
    .duration(40)
    .EUt(7)
    .buildAndRegister();

// electrolyzer: 1000L KCl solution -> 3 KOH + 1000L Cl + 1000L H
mods.gregtech.electrolyzer.recipeBuilder()
    .fluidInputs(fluid('potassium_chloride_solution') * 1000)
    .outputs(metaitem('voidrunner:dustPotassiumHydroxide') * 3)
    .fluidOutputs(fluid('chlorine') * 1000, fluid('hydrogen') * 1000)
    .duration(36 * 20)
    .EUt(30)
    .buildAndRegister();

mods.gregtech.centrifuge.recipeBuilder()
    .fluidInputs(fluid('potassium_chloride_solution') * 1000)
    .outputs(metaitem('dustRockSalt') * 2)
    .fluidOutputs(fluid('water') * 1000)
    .duration(50)
    .EUt(30)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustPotassiumHydroxide'))
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('potassium_hydroxide_solution') * 1000)
    .duration(40)
    .EUt(7)
    .buildAndRegister();
