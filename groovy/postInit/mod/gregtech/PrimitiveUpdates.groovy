
// Charcoal * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:log', 32767)], null)
// Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal')], null)
// Block of Coke * 1
mods.gregtech.coke_oven.removeByInput(1, [item('minecraft:coal_block')], null)

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('logWood'))
    .outputs(item('minecraft:coal', 1))
    .fluidOutputs(fluid('wood_tar') * 100)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('pyrotech:log_pile'))
    .outputs(metaitem('blockCharcoal'))
    .fluidOutputs(fluid('wood_tar') * 900)
    .duration(2700)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal', 1))
    .outputs(item('minecraft:coal'))
    .fluidOutputs(fluid('creosote') * 150)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(ore('blockCharcoal'))
    .outputs(item('minecraft:coal_block'))
    .fluidOutputs(fluid('creosote') * 1350)
    .duration(2700)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal'))
    .outputs(metaitem('gemCoke'))
    .fluidOutputs(fluid('creosote') * 200)
    .duration(300)
    .buildAndRegister();

mods.gregtech.coke_oven.recipeBuilder()
    .inputs(item('minecraft:coal_block'))
    .outputs(metaitem('blockCoke'))
    .fluidOutputs(fluid('creosote') * 1800)
    .duration(2700)
    .buildAndRegister();

// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('gemCoke')], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCoke')], null)
// Block of Steel * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('blockWroughtIron'), metaitem('blockCoke')], null)

// speed up coke in pbf by 2x, more worth it to automate coke
mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(ore('ingotWroughtIron'), ore('gemCoke'))
    .outputs(metaitem('ingotSteel'), metaitem('dustTinyAsh'))
    .duration(300)
    .buildAndRegister();

mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(ore('ingotWroughtIron'), ore('dustCoke'))
    .outputs(metaitem('ingotSteel'), metaitem('dustTinyAsh'))
    .duration(300)
    .buildAndRegister();

mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(ore('blockWroughtIron'), ore('blockCoke'))
    .outputs(metaitem('blockSteel'), metaitem('dustAsh'))
    .duration(2700)
    .buildAndRegister();