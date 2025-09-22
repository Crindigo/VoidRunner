package postInit.mod;

crafting.remove('roots:pestle');
crafting.remove('roots:pestle2');
crafting.remove('roots:mortar');

crafting.remove('roots:fey_crafter');
crafting.remove('roots:pyre');
crafting.remove('roots:grove_stone');
crafting.remove('roots:imbuer');
crafting.remove('roots:imposer');

crafting.remove('roots:wooden_shears');
//crafting.remove('mysticalworld:silk_thread');
crafting.remove('mysticalworld:silk_thread_spindle');
crafting.remove('mysticalworld:silk_thread_to_string');
crafting.remove('mysticalworld:spindle');

//crafting.addShapeless("silk_thread", item('mysticalworld:silk_thread') * 4, [item('mysticalworld:silk_cocoon')]);

// TODO: use ST textile spinner when added
mods.gregtech.wiremill.recipeBuilder()
    .circuitMeta(1)
    .inputs(item('mysticalworld:silk_cocoon'))
    .outputs(item('mysticalworld:silk_thread') * 6)
    .EUt(16)
    .duration(40)
    .buildAndRegister();

mods.gregtech.wiremill.recipeBuilder()
    .circuitMeta(2)
    .inputs(item('mysticalworld:silk_cocoon'))
    .outputs(item('minecraft:string') * 2)
    .EUt(64)
    .duration(40)
    .buildAndRegister();