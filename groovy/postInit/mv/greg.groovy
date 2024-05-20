package mv;

// Infinite Water Cover * 1
mods.gregtech.assembler.removeByInput(480, 
    [metaitem('electric.pump.hv') * 2, item('minecraft:cauldron'), metaitem('circuit.advanced_integrated')], null)
//mods.gregtech.assembler.removeByInput(480, 
//    [metaitem('electric.pump.hv') * 2, item('minecraft:cauldron'), metaitem('circuit.assembly')], null)
//mods.gregtech.assembler.removeByInput(480, 
//    [metaitem('electric.pump.hv') * 2, item('minecraft:cauldron'), metaitem('circuit.nano_processor')], null)

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('electric.pump.mv'), item('minecraft:cauldron'))
    .fluidInputs(liquid("water") * 2000)
    .outputs(metaitem("cover.infinite_water"))
    .duration(200)
    .EUt(120)
    .buildAndRegister()