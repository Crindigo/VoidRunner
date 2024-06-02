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
    .EUt(60)
    .buildAndRegister();

// capacitor: kraft paper, soy wax, aluminium foil


// enhanced vacuum tube


// plated wire memory


// retro circuit recipe


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