// clean this up so greg doesn't try to use these. breaks some pyro recipes but we don't care about em.
oreDict.remove("toolHammer", item('pyrotech:crude_hammer'));
oreDict.remove("toolHammer", item('pyrotech:stone_hammer'));
oreDict.remove("toolHammer", item('pyrotech:bone_hammer'));
oreDict.remove("toolHammer", item('pyrotech:flint_hammer'));
oreDict.remove("toolHammer", item('pyrotech:iron_hammer'));
oreDict.remove("toolHammer", item('pyrotech:gold_hammer'));
oreDict.remove("toolHammer", item('pyrotech:diamond_hammer'));
oreDict.remove("toolHammer", item('pyrotech:obsidian_hammer'));
oreDict.remove("toolHammer", item('pyrotech:bone_hammer_durable'));
oreDict.remove("toolHammer", item('pyrotech:flint_hammer_durable'));

oreDict.add('dustAsh', item('pyrotech:material', 0));
oreDict.add('dustWood', item('pyrotech:rock', 7));

oreDict.add('dyeBlue', metaitem('dustCobalt'));

oreDict.add('paper', metaitem('voidrunner:kraft_paper_foil'));

// New circuits
oreDict.add('circuitLv', metaitem('voidrunner:circuit_primitive'));
oreDict.add('circuitMv', metaitem('voidrunner:circuit_retro'));
//oreDict.add('circuitHv', metaitem('voidrunner:computer_standard'));
//oreDict.add('circuitEv', metaitem('voidrunner:computer_reliable'));

//oreDict.add('chip.lv', metaitem('voidrunner:circuit_primitive'));
//oreDict.add('chip.mv', metaitem('voidrunner:circuit_retro'));
//oreDict.add('chip.hv', metaitem('voidrunner:circuit_standard'));
//oreDict.add('chip.ev', metaitem('voidrunner:circuit_reliable'));

// Geology stones
oreDict.add('stoneLimestone', item('geology:rock_sedimentary', 0));
oreDict.add('stoneAndesite', item('geology:rock_volcanic', 2));
oreDict.add('stoneBasalt', item('geology:rock_volcanic', 4));
oreDict.add('obsidian', item('geology:rock_volcanic', 6));
oreDict.add('stoneGranite', item('geology:rock_plutonic', 0));
oreDict.add('stoneDiorite', item('geology:rock_plutonic', 2));
oreDict.add('sandstone', item('geology:rock_sedimentary', 8));
oreDict.add('sandstone', item('geology:rock_sedimentary', 9));

oreDict.remove('string', item('mysticalworld:silk_thread'));
oreDict.add('twine', item('mysticalworld:silk_thread'));