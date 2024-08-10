package postInit.chemistry.elements;

/*
dirt extract + Hcl = acidic dirt extract  
electrolyze acidic dirt extract for H, Cl, small Mn dust  
MnP craftable then
*/

mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('dirt_extract') * 1000, fluid('hydrochloric_acid') * 1000)
    .fluidOutputs(fluid('acidic_dirt_extract') * 2000)
    .EUt(16)
    .duration(100)
    .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
    .fluidInputs(fluid('acidic_dirt_extract') * 2000)
    .fluidOutputs(fluid('hydrogen') * 1000, fluid('chlorine') * 1000)
    .outputs(metaitem('dustManganese') * 2)
    .circuitMeta(1)
    .EUt(30)
    .duration(100)
    .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
    .fluidInputs(fluid('acidic_dirt_extract') * 2000)
    .notConsumable(ore('stickLongManganese'))
    .fluidOutputs(fluid('hydrogen') * 1000, fluid('chlorine') * 1000)
    .outputs(metaitem('dustManganese') * 8)
    .circuitMeta(2)
    .EUt(120)
    .duration(100)
    .buildAndRegister();