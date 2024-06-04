package chemistry.elements;

// Ultramafic extract using stone extract and sulfur compound (small sodium sulfide?)  

// 7 NaHSO4 + 2 NaCl -> HCl + 7 Na2SO4
// endothermic, more expensive than bisulfate recipe
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(ore('dustSodiumBisulfate') * 7, ore('dustSalt') * 2)
    .outputs(metaitem('dustSodiumSulfate') * 7)
    .fluidOutputs(fluid('hydrochloric_acid') * 1000)
    .EUt(30)
    .duration(200)
    .buildAndRegister();

// remove the auto-generated Na2SO4 (added in gtfo)
mods.gregtech.electrolyzer.removeByInput(60, [metaitem('dustSodiumSulfate') * 7], null)

// replace sodium sulfide recipe
// Sodium Sulfide Dust * 3
mods.gregtech.chemical_reactor.removeByInput(30, [metaitem('dustSodium') * 2, metaitem('dustSulfur')], null);
mods.gregtech.large_chemical_reactor.removeByInput(30, [metaitem('dustSodium') * 2, metaitem('dustSulfur')], null)


// 7 Na2SO4 + 2 C -> 3 Na2S + 2000L CO2
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(ore('dustSodiumSulfate') * 7, ore('dustCarbon') * 2)
    .outputs(metaitem('dustSodiumSulfide') * 3)
    .fluidOutputs(fluid('carbon_dioxide') * 2000)
    .EUt(30)
    .duration(60)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustSodiumSulfide'))
    .fluidInputs(fluid('stone_extract') * 2000)
    .fluidOutputs(fluid('ultramafic_extract') * 2000)
    .EUt(24)
    .duration(200)
    .buildAndRegister();

// may want to organize all these xxx + extract chem bath recipes somewhere. 10x faster at hv. 2.5x faster at lv.
mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(item('minecraft:gravel'))
    .fluidInputs(fluid('ultramafic_extract') * 125)
    .outputs(item('gregtech:ore_pentlandite_0:0'))
    .EUt(60)
    .duration(120)
    .buildAndRegister();

// Mond proc for pure nickel
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(ore('dustNickel'))
    .fluidInputs(fluid('carbon_monoxide') * 4000)
    .fluidOutputs(fluid('nickel_carbonyl') * 1000)
    .EUt(16)
    .duration(200)
    .buildAndRegister();

mods.gregtech.chemical_reactor.recipeBuilder()
    .fluidInputs(fluid('nickel_carbonyl') * 1000)
    .outputs(metaitem('voidrunner:dustNickelPure'))
    .fluidOutputs(fluid('carbon_monoxide') * 4000)
    .EUt(30)
    .duration(200)
    .buildAndRegister();
