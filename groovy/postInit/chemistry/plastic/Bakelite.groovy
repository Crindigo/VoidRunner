def chemReactor = mods.gregtech.chemical_reactor;
def distillery = mods.gregtech.distillery;

// 1000L methanol + 1000L oxygen + silver rod (nc) = 1000L formaldehyde + 1000L water
chemReactor.recipeBuilder()
    .fluidInputs(fluid('methanol') * 1000, fluid('oxygen') * 1000)
    .notConsumable(ore('stickSilver'))
    .fluidOutputs(fluid('formaldehyde') * 1000, fluid('water') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// 750L phenol + 500L formaldehyde + 100L H2SO4 = 820L Bakelite Resin Solution
chemReactor.recipeBuilder()
    .fluidInputs(fluid('phenol') * 750, fluid('formaldehyde') * 500, fluid('sulfuric_acid') * 100)
    .fluidOutputs(fluid('bakelite') * 820)
    .duration(600)
    .EUt(24)
    .buildAndRegister();

// 820L Bakelite Resin Solution => 5 bakelite resin + 100L H2SO4
distillery.recipeBuilder()
    .fluidInputs(fluid('bakelite') * 820)
    .outputs(metaitem('voidrunner:gemBakelite') * 5)
    .fluidOutputs(fluid('sulfuric_acid') * 100)
    .duration(300)
    .EUt(30)
    .buildAndRegister();

// macerate resin into powder
mods.gregtech.macerator.recipeBuilder()
    .inputs(metaitem('voidrunner:gemBakelite'))
    .outputs(metaitem('voidrunner:dustBakelite'))
    .duration(15)
    .EUt(2)
    .buildAndRegister();

// alloy smelt the powder with molds to get plate
mods.gregtech.alloy_smelter.recipeBuilder()
    .inputs(metaitem('voidrunner:dustBakelite'))
    .notConsumable(metaitem('shape.mold.plate'))
    .outputs(metaitem('voidrunner:plateBakelite'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();