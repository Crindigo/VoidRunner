package postInit.chemistry;

import gregtech.api.recipes.chance.output.ChancedOutputLogic;

// mixer: 144L lead + 1000L oxygen => 2PbO
// or reactor or arc furnace: 2 PbS + 3000L O => 2 PbO + 1000L SO2 (from galena dust)
mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('lead') * 144, fluid('oxygen') * 1000)
    .outputs(metaitem('voidrunner:dustLeadOxide') * 2)
    .EUt(16)
    .duration(150)
    .buildAndRegister();

// lead(ii) sulfate = PbSO4
// 2PbO + 1000L H2SO4 => 6PbSO4 + 1000L water
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(metaitem('voidrunner:dustLeadOxide') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .outputs(metaitem('voidrunner:dustLeadSulfate') * 6)
    .fluidOutputs(fluid('water') * 1000)
    .EUt(16)
    .duration(300)
    .buildAndRegister();

// lanarkite
// 2PbO + 6PbSO4 => 8 lanarkite - Pb2(SO4)O
mods.gregtech.mixer.recipeBuilder()
    .inputs(metaitem('voidrunner:dustLeadOxide') * 2, metaitem('voidrunner:dustLeadSulfate') * 6)
    .outputs(metaitem('voidrunner:dustLanarkite') * 8)
    .EUt(30)
    .duration(300)
    .buildAndRegister();

// 3Cu + P => 4Cu3P
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCopper') * 3, ore('dustPhosphorus'))
    .outputs(metaitem('voidrunner:dustCopperPhosphide') * 4)
    .EUt(30)
    .duration(300)
    .buildAndRegister();

// total 10 lead, 5 sulfur, 18 copper, 6 phosphorus
// excess returns 17 copper, 5 sulfur, 1 lead
// so 9 lead, 1 copper, 6 phosphorus in the mixture (plus 25 oxygen)

// 40 Pb2(SO4)O + 24 Cu3P => 41 Pb9Cu(PO4)6O + 15 Cu2S + 7 Cu + Pb
mods.gregtech.mixer.recipeBuilder()
    .inputs(metaitem('voidrunner:dustLanarkite') * 40, metaitem('voidrunner:dustCopperPhosphide') * 24)
    .outputs(metaitem('voidrunner:dustLk99Mixture') * 64)
    .EUt(120)
    .duration(1200)
    .buildAndRegister();
// Copper-doped Lead-Oxyapatite

mods.gregtech.centrifuge.recipeBuilder()
    .inputs(metaitem('voidrunner:dustLk99Mixture') * 64)
    //.chancedOutputLogic(ChancedOutputLogic.XOR)
    //.chancedOutput(metaitem('voidrunner:dustLk99Good') * 41, 6000, 500)
    //.chancedOutput(metaitem('voidrunner:dustLk99Bad') * 41, 10000, 0)
    // giving 100% good because it's LV and already kinda complex. honestly could be the MV supercon for better diff curve
    .outputs(metaitem('voidrunner:dustLk99Good') * 41)
    .outputs(metaitem('voidrunner:dustCopperSulfide') * 15, metaitem('dustCopper') * 7, metaitem('dustLead'))
    .EUt(30)
    .duration(600)
    .buildAndRegister();

// maybe we make one LK99 Mixture Dust and centrifuge. don't know if we can do either-or on output for good/bad lk99.
// gregtech pull 2060
// chanced output with 50% on good, 100% on bad, using xor logic?
// .chancedOutputLogic(ChancedOutputLogic.XOR)
// or else we just give like 20 good + 21 bad dust, problem being rounding for stoic.
// chem reactor at 30 eu/t for 60s
// centrifuge 41 bad dust for 9 Pb, Cu, 30 PO4, 1000 O