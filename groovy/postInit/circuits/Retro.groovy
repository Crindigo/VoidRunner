
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