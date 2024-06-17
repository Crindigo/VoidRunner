package chemistry;

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

// Zinc Chloride

mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(ore('dustZinc'))
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .outputs(metaitem('voidrunner:dustZincChloride') * 3)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(300)
    .EUt(30)
    .buildAndRegister();

// shitty early way to get sulfuric acid

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('dustSulfur'))
    .fluidOutputs(fluid('sulfur_dioxide') * 500)
    .duration(1200)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .notConsumable(ore('sapling') * 16)
    .fluidOutputs(fluid('oxygen') * 100)
    .duration(240)
    .buildAndRegister();

recipemap('crude_mixer').recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .fluidInputs(fluid('oxygen') * 1000)
    .fluidOutputs(fluid('sulfur_trioxide') * 1000)
    .duration(600)
    .EUt(7)
    .buildAndRegister();

recipemap('crude_mixer').recipeBuilder()
    .fluidInputs(fluid('sulfur_trioxide') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(200)
    .EUt(7)
    .buildAndRegister();

