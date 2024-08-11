package postInit.mod;

crafting.replaceShaped('xnet:antenna', item('xnet:antenna'), [
    [ore('barsIron'), ore('stickLongIron'), ore('barsIron')],
    [ore('barsIron'), ore('stickLongIron'), ore('barsIron')],
    [null, ore('stickLongIron'), null]
]);

crafting.replaceShaped('xnet:antenna_base', item('xnet:antenna_base'), [
    [null, ore('stickLongIron'), null],
    [null, ore('stickLongIron'), null],
    [ore('plateIron'), ore('wireGtQuadrupleCopper'), ore('plateIron')]
]);

crafting.replaceShaped('xnet:antenna_dish', item('xnet:antenna_dish'), [
    [null, metaitem('sensor.lv'), null],
    [null, ore('plateDoubleAluminium'), null],
    [null, ore('stickLongIron'), null]
]);

crafting.replaceShaped('xnet:connector_upgrade', item('xnet:connector_upgrade'), [
    [ore('paper'), ore('circuitMv')],
    [metaitem('electric.pump.mv'), metaitem('conveyor.module.mv')]
]);

crafting.replaceShaped('xnet:connector_0', item('xnet:connector', 0) * 4, [
    [ore('dyeBlue'), ore('chest'), ore('dyeBlue')],
    [metaitem('electric.pump.lv'), metaitem('hull.lv'), metaitem('conveyor.module.lv')],
    [ore('dyeBlue'), ore('circuitLv'), ore('dyeBlue')],
]);
crafting.remove('xnet:advanced_connector_0');

crafting.remove('xnet:netcable_0');
/*crafting.replaceShaped('xnet:netcable_0', item('xnet:netcable', 0) * 8, [
    [ore('pipeSmallFluidTinAlloy'), ore('pipeSmallFluidTinAlloy'), ore('pipeSmallFluidTinAlloy')],
    [null, ore('frameGtSteel'), null],
    [ore('pipeSmallItemCobalt'), ore('pipeSmallItemCobalt'), ore('pipeSmallItemCobalt')]
]);*/

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('pipeSmallFluidTinAlloy') * 3, ore('frameGtSteel'), ore('pipeSmallItemCobalt') * 3)
    .outputs(item('xnet:netcable', 0) * 12)
    .EUt(24)
    .duration(200)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('pipeNormalFluidTinAlloy'), ore('frameGtSteel'), ore('pipeNormalItemCobalt'))
    .outputs(item('xnet:netcable', 0) * 12)
    .EUt(24)
    .duration(200)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('pipeLargeFluidTinAlloy'), ore('frameGtSteel'), ore('pipeLargeItemCobalt'))
    .outputs(item('xnet:netcable', 0) * 24)
    .EUt(24)
    .duration(400)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('pipeHugeFluidTinAlloy'), ore('frameGtSteel'), ore('pipeHugeItemCobalt'))
    .outputs(item('xnet:netcable', 0) * 48)
    .EUt(24)
    .duration(600)
    .buildAndRegister();


crafting.remove('xnet:netcable_routing');
mods.gregtech.assembler.recipeBuilder()
    .inputs(item('gregtech:transparent_casing') * 4, ore('wireFineRedAlloy') * 32)
    .outputs(item('xnet:netcable', 4) * 32)
    .EUt(24)
    .duration(300)
    .buildAndRegister();

crafting.replaceShaped('xnet:redstone_proxy', item('xnet:redstone_proxy'), [
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('wireFineRedAlloy'), metaitem('hull.lv'), ore('wireFineRedAlloy')],
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
]);


crafting.replaceShaped('xnet:controller', item('xnet:controller'), [
    [metaitem('sensor.lv'), ore('glass'), metaitem('emitter.lv')],
    [ore('circuitLv'), metaitem('hull.lv'), ore('circuitLv')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
]);

crafting.replaceShaped('xnet:router', item('xnet:router'), [
    [ore('glass'), ore('wireGtQuadrupleRedAlloy'), ore('glass')],
    [ore('circuitLv'), metaitem('hull.lv'), ore('circuitLv')],
    [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
]);

crafting.replaceShaped('xnet:wireless_router', item('xnet:wireless_router'), [
    [metaitem('sensor.mv'), ore('wireGtOctalBlueAlloy'), metaitem('emitter.mv')],
    [ore('circuitMv'), metaitem('hull.mv'), ore('circuitMv')],
    [ore('plateAluminium'), ore('plateAluminium'), ore('plateAluminium')],
]);