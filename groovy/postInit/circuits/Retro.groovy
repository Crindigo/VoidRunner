package circuits;

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

// Phenolic Circuit Board * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('dustWood'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 50]);

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateBakelite'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('board.phenolic'))
    .duration(150)
    .EUt(30)
    .buildAndRegister();


// carbon pile resistor - 4 carbon plates + 2 copper plates = 4 resistors
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateCarbon') * 4, ore('plateCopper') * 2)
    .outputs(metaitem('voidrunner:resistor_carbon_pile') * 4)
    .duration(200)
    .EUt(24)
    .buildAndRegister();

// capacitor: kraft paper, soy wax, aluminium foil

mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('soybean_oil') * 500, fluid('hydrogen') * 1000)
    .outputs(metaitem('voidrunner:soy_wax_crushed_centrifuged'))
    .duration(200)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('voidrunner:kraft_paper_foil') * 2, ore('foilAluminium'), metaitem('voidrunner:soy_wax_crushed_centrifuged'))
    .outputs(metaitem('voidrunner:retro_capacitor') * 2)
    .duration(300)
    .EUt(24)
    .buildAndRegister();


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
crafting.shapedBuilder()
    .name('circuit_retro')
    .output(metaitem('voidrunner:circuit_retro'))
    .shape('wjw', 'rbr', 'RcW')
    .key('w', ore('wireFineAnnealedCopper'))
    .key('j', metaitem('voidrunner:retro_capacitor'))
    .key('r', metaitem('voidrunner:resistor_carbon_pile'))
    .key('R', metaitem('circuit.vacuum_tube'))
    .key('b', metaitem('circuit_board.phenolic'))
    .key('W', metaitem('voidrunner:plated_wire_memory'))
    .key('c', ore('toolWireCutter'))
    .register();

mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.phenolic'), metaitem('voidrunner:resistor_carbon_pile') * 2, 
            metaitem('voidrunner:retro_capacitor'), metaitem('circuit.vacuum_tube'), 
            metaitem('voidrunner:plated_wire_memory'), ore('wireFineAnnealedCopper') * 2)
    .outputs(metaitem('voidrunner:circuit_retro'))
    .duration(300)
    .EUt(30)
    .buildAndRegister();

// disk platter
mods.gregtech.assembler.recipeBuilder()
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
    .register();