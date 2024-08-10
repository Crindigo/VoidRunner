package postInit.mod;

def assembler = mods.gregtech.assembler;

// these dynamic recipes are weird
for (x in 1..37) {
    crafting.remove("advgenerators:recipe$x");
}

// heat exchanger controller
assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), ore('circuitLv') * 2, metaitem('electric.pump.lv') * 2, ore('pipeTinyFluidCopper') * 16)
    .outputs(item('advgenerators:exchanger_controller'))
    .circuitMeta(1)
    .duration(400)
    .EUt(30)
    .buildAndRegister();

// steam turbine controller
assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), ore('circuitLv') * 2, metaitem('electric.pump.lv') * 2, ore('pipeLargeFluidBronze') * 4)
    .outputs(item('advgenerators:steam_turbine_controller'))
    .duration(400)
    .EUt(30)
    .buildAndRegister();

// gas turbine controller
assembler.recipeBuilder()
    .inputs(metaitem('hull.mv'), ore('circuitMv') * 2, metaitem('electric.pump.mv') * 2, ore('pipeLargeFluidAluminium') * 4)
    .outputs(item('advgenerators:turbine_controller'))
    .duration(400)
    .EUt(120)
    .buildAndRegister();

// fluid intake valve
assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.import.lv'))
    .outputs(item('advgenerators:fluid_input'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// fluid output valve
assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.export.lv'))
    .outputs(item('advgenerators:fluid_output_select'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// item input port
assembler.recipeBuilder()
    .inputs(metaitem('item_bus.import.lv'))
    .outputs(item('advgenerators:item_input'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// item output port
assembler.recipeBuilder()
    .inputs(metaitem('item_bus.export.lv'))
    .outputs(item('advgenerators:item_output'))
    .duration(100)
    .EUt(30)
    .buildAndRegister();

// forge energy emitter
assembler.recipeBuilder()
    .inputs(metaitem('transformer.adjustable.lv'), ore('circuitLv'), ore('wireFineRedAlloy') * 8)
    .outputs(item('advgenerators:forge_output'))
    .duration(200)
    .EUt(30)
    .buildAndRegister();

// heat exchanger
assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('electric.pump.lv'), ore('pipeTinyFluidCopper') * 8)
    .outputs(item('advgenerators:heat_exchanger'))
    .circuitMeta(2)
    .duration(200)
    .EUt(30)
    .buildAndRegister();

// steel turbine
assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), ore('rotorSteel') * 2, metaitem('electric.motor.lv') * 2, ore('pipeNormalFluidBronze') * 2)
    .outputs(item('advgenerators:turbine_steel'))
    .duration(200)
    .EUt(30)
    .buildAndRegister();

// black bronze turbine (make black bronze smeltable in cupronickel ebf, lower blast temp, require mv mixer)
assembler.recipeBuilder()
    .inputs(metaitem('hull.mv'), ore('rotorBlackBronze') * 2, metaitem('electric.motor.mv') * 2, ore('pipeNormalFluidSteel') * 2)
    .outputs(item('advgenerators:turbine_manyullyn'))
    .duration(200)
    .EUt(120)
    .buildAndRegister();

// stainless turbine (apparently i was going to use black steel with adv alloy texture)
assembler.recipeBuilder()
    .inputs(metaitem('hull.hv'), ore('rotorStainlessSteel') * 2, metaitem('electric.motor.hv') * 2,
            ore('pipeNormalFluidStainlessSteel') * 2)
    .outputs(item('advgenerators:turbine_iron'))
    .duration(200)
    .EUt(480)
    .buildAndRegister();