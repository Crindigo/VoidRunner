package postInit.chemistry;

// white liquor is hot water, NaOH, Na2S
// Heated Water * 1000
mods.gregtech.fluid_heater.removeByInput(120, [metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('water') * 1000])
mods.gregtech.fluid_heater.recipeBuilder()
    .fluidInputs(fluid('water') * 100)
    .circuitMeta(2)
    .fluidOutputs(fluid('gtfo_heated_water') * 100)
    .duration(300) // heating 6L by 73C = 438kcal in 30t. heating 100L by 43C = 4300kcal, about 10x longer.
    .EUt(30)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .fluidInputs(fluid('gtfo_heated_water') * 1000)
    .inputs(ore('dustSodiumHydroxide') * 3)
    .inputs(ore('dustSodiumSulfide') * 3)
    .fluidOutputs(fluid('white_liquor') * 1000)
    .duration(400)
    .EUt(16)
    .buildAndRegister();

// wood pulp + steam = impregnated wood pulp
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustWood') * 4)
    .fluidInputs(fluid('steam') * 1000)
    .outputs(metaitem('voidrunner:impregnated_wood_pulp_dust') * 4)
    .duration(400)
    .EUt(24)
    .buildAndRegister();

// digester multi: IWP + white liquor => brownstock
recipemap('digester').recipeBuilder()
    .inputs(metaitem('voidrunner:impregnated_wood_pulp_dust') * 4)
    .fluidInputs(fluid('white_liquor') * 1000)
    .outputs(metaitem('voidrunner:brownstock_dust') * 4)
    .duration(800)
    .EUt(16)
    .buildAndRegister();

// mixer: brownstock + water => kraft pulp + weak black liquor
mods.gregtech.mixer.recipeBuilder()
    .inputs(metaitem('voidrunner:brownstock_dust') * 4)
    .fluidInputs(fluid('water') * 1000)
    .outputs(metaitem('voidrunner:kraft_pulp_dust') * 4)
    .fluidOutputs(fluid('weak_black_liquor') * 2000)
    .duration(300)
    .EUt(16)
    .buildAndRegister();

// distillery: weak black liquor => strong BL
mods.gregtech.distillery.recipeBuilder()
    .fluidInputs(fluid('weak_black_liquor') * 2000)
    .fluidOutputs(fluid('strong_black_liquor') * 1000)
    .duration(300)
    .EUt(7)
    .buildAndRegister();

// centrifuge: strong BL => rosin + white liquor
mods.gregtech.centrifuge.recipeBuilder()
    .fluidInputs(fluid('strong_black_liquor') * 1000)
    .fluidOutputs(fluid('white_liquor') * 1000)
    .outputs(item('thermalfoundation:material', 832))
    .duration(400)
    .EUt(24)
    .buildAndRegister();

// compressor or extruder: kraft pulp => kraft paper
mods.gregtech.extruder.recipeBuilder()
    .inputs(metaitem('voidrunner:kraft_pulp_dust'))
    .notConsumable(metaitem('shape.extruder.foil'))
    .outputs(metaitem('voidrunner:kraft_paper_foil') * 4)
    .duration(5)
    .EUt(24)
    .buildAndRegister();
