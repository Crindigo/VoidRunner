package chemistry.plastic;

def chemReactor = mods.gregtech.chemical_reactor;
def distillery = mods.gregtech.distillery;

// move wood tar distillation to LV to help out with phenol, instead of only having coal tar
// Creosote Oil * 30
mods.gregtech.distillery.removeByInput(64, [metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('wood_tar') * 1000]);
mods.gregtech.distillery.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('wood_tar') * 1000)
    .fluidOutputs(fluid('phenol') * 75)
    .EUt(16)
    .duration(80)
    .buildAndRegister();


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
    .fluidInputs(fluid('phenol') * 750, fluid('formaldehyde') * 500, fluid('sulfuric_acid') * 250)
    .fluidOutputs(fluid('bakelite') * 1540)
    .duration(600)
    .EUt(24)
    .buildAndRegister();

// 820L Bakelite Resin Solution => 5 bakelite resin + 100L H2SO4
distillery.recipeBuilder()
    .fluidInputs(fluid('bakelite') * 1540)
    .outputs(metaitem('voidrunner:gemBakelite') * 10)
    .fluidOutputs(fluid('sulfuric_acid') * 250)
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