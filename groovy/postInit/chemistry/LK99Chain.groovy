import gregtech.api.recipes.chance.output.ChancedOutputLogic;

// mixer: 288L lead + 2000L oxygen => 2PbO


// lead(ii) sulfate = PbSO4
// 2PbO + 1000L H2SO4 => 6PbSO4 + 1000L water

// lanarkite
// 2PbO + 6PbSO4 => 8 lanarkite - Pb2(SO4)O

// 3Cu + P => 4Cu3P


// 40 Pb2(SO4)O + 24 Cu3P => 41 Pb9Cu(PO4)6O + 15 Cu2S + 7 Cu + Pb
// maybe we make one LK99 Mixture Dust and centrifuge. don't know if we can do either-or on output for good/bad lk99.
// gregtech pull 2060
// chanced output with 50% on good, 100% on bad, using xor logic?
// .chancedOutputLogic(ChancedOutputLogic.XOR)
// or else we just give like 20 good + 21 bad dust, problem being rounding for stoic.
// chem reactor at 30 eu/t for 60s
// centrifuge 41 bad dust for 9 Pb, Cu, 30 PO4, 1000 O