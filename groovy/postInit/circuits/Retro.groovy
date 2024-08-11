package postInit.circuits;

// https://en.wikipedia.org/wiki/IBM_305_RAMAC

// x board: phenolic
// x wiring: annealed copper
// capacitor: kraft paper, soy wax, Al foil
// transistor: diode
// x resistor: carbon-pile
// cpu: enhanced vacuum tube (using pure nickel)
// ram: plated-wire memory
// storage: ramac (multiple platters - glass plate + tiny iron + tiny carbon, mv motor)
// cooling: heatsink + fan (zn foil, cu rod, steel rotor, mv motor)
// x casing: Al plate

// phenolic board

// Methanol * 30
mods.gregtech.distillery.removeByInput(64, [metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('wood_vinegar') * 100])
mods.gregtech.distillery.recipeBuilder()
    .circuitMeta(4)
    .fluidInputs(fluid('wood_vinegar') * 100)
    .fluidOutputs(fluid('methanol') * 30)
    .EUt(16)
    .duration(16)
    .buildAndRegister();

// Phenolic Circuit Board * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('dustWood'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 50]);

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateBakelite'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('board.phenolic'))
    .duration(150)
    .EUt(30)
    .buildAndRegister();

// iirc getting the final board is either 8 silver wire or 2/4 foil + sodium persulfate/iron(iii)cl
// we could just require the latter since in base GT silver is rareish but here not really, so no incentive.

// carbon pile resistor - 4 carbon plates + 2 copper plates = 4 resistors
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateCarbon') * 4, ore('plateCopper') * 2)
    .outputs(metaitem('voidrunner:resistor_carbon_pile') * 4)
    .duration(200)
    .EUt(24)
    .buildAndRegister();

// capacitor: kraft paper, soy wax, aluminium foil

mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('gtfo_raw_soybean_oil') * 500, fluid('hydrogen') * 1000)
    .outputs(metaitem('voidrunner:soy_wax_crushed_centrifuged'))
    .duration(200)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('gtfo_soybean_oil') * 500, fluid('hydrogen') * 1000)
    .outputs(metaitem('voidrunner:soy_wax_crushed_centrifuged') * 2)
    .duration(200)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('voidrunner:kraft_paper_foil') * 2, ore('foilAluminium'), metaitem('voidrunner:soy_wax_crushed_centrifuged'))
    .outputs(metaitem('voidrunner:retro_capacitor') * 2)
    .duration(300)
    .EUt(24)
    .buildAndRegister();


// Vacuum Tube * 2
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Vacuum Tube * 3
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 4
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleAnnealedCopper') * 2], [fluid('red_alloy') * 18])

// enhanced vacuum tube
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('component.glass.tube'), ore('foilZinc'), ore('wireGtSingleAnnealedCopper') * 2, ore('dustNickelPure'))
    .outputs(metaitem('circuit.vacuum_tube') * 2)
    .duration(160)
    .EUt(7)
    .buildAndRegister();

crafting.remove('gregtech:vacuum_tube');

// plated wire memory https://en.wikipedia.org/wiki/Plated-wire_memory
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('foilPermalloy') * 4, ore('wireFineCopper') * 8)
    .outputs(metaitem('voidrunner:plated_wire_memory') * 2)
    .duration(200)
    .EUt(16)
    .buildAndRegister();

// retro circuit recipe
crafting.remove('gregtech:electronic_circuit_mv'); // 3 circuit, 2 wires, 2 diodes, steel plate, board
crafting.shapedBuilder()
    .name('circuit_retro')
    //.output(metaitem('voidrunner:circuit_retro'))
    .output(metaitem('circuit.good_electronic'))
    .shape('wjw', 'cbc', 'WcW')
    .key('w', ore('wireGtSingleAnnealedCopper'))
    .key('j', metaitem('voidrunner:retro_capacitor')) // kraft paper
    //.key('r', metaitem('voidrunner:resistor_carbon_pile'))
    .key('c', metaitem('circuit.electronic'))
    //.key('R', metaitem('circuit.vacuum_tube')) // pure nickel
    .key('b', metaitem('circuit_board.good')) // bakelite
    .key('W', metaitem('voidrunner:plated_wire_memory')) // permalloy
    //.key('c', ore('toolWireCutter'))
    .register();

mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.good'), metaitem('circuit.electronic') * 2, 
            metaitem('voidrunner:retro_capacitor'), metaitem('voidrunner:plated_wire_memory') * 2, 
            ore('wireGtSingleAnnealedCopper') * 2)
    .outputs(metaitem('circuit.good_electronic'))
    .duration(300)
    .EUt(16)
    .buildAndRegister();

// Good Electronic Circuit * 1
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.good'), metaitem('circuit.electronic') * 2, metaitem('component.diode') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('soldering_alloy') * 72]);
// Good Electronic Circuit * 1
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.good'), metaitem('circuit.electronic') * 2, metaitem('component.diode') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('tin') * 144]);


// disk platter
/*mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateGlass'), ore('dustTinyIron'), ore('dustTinyCarbon'))
    .outputs(metaitem('voidrunner:large_hdd_platter'))
    .duration(100)
    .EUt(16)
    .buildAndRegister();

// retro hdd
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('voidrunner:large_hdd_platter') * 4, metaitem('electric.motor.mv'), ore('paneGlass') * 2)
    .outputs(metaitem('voidrunner:retro_hdd'))
    .duration(300)
    .EUt(16)
    .buildAndRegister();

// basic air cooler
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('foilZinc') * 4, ore('stickCopper') * 2, ore('rotorSteel'), metaitem('electric.motor.mv'))
    .outputs(metaitem('voidrunner:basic_air_cooler'))
    .duration(300)
    .EUt(7)
    .buildAndRegister();

// retro computer recipe
crafting.shapedBuilder()
    .name('computer_retro')
    .output(metaitem('voidrunner:computer_retro'))
    .shape('prp', 'wcw', 'psp')
    .key('p', ore('plateAluminium'))
    .key('r', metaitem('voidrunner:basic_air_cooler'))
    .key('w', ore('wireGtSingleAnnealedCopper'))
    .key('c', metaitem('voidrunner:circuit_retro'))
    .key('s', metaitem('voidrunner:retro_hdd'))
    .register();*/