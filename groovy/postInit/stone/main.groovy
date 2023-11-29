crafting.remove('pyrotech:clay');
furnace.removeByInput(item('minecraft:clay_ball'));

crafting.remove('pyrotech:tech/basic/compacting_bin');
crafting.shapedBuilder()
    .name('compacting_bin')
    .output(item('pyrotech:compacting_bin'))
    .shape('S S',
           'P P',
           'SWS')
    .key('S', ore('slabCobblestone'))
    .key('P', ore('plankWood'))
    .key('W', ore('slabWood'))
    .register();

crafting.remove('pyrotech:tech/machine/bellows');
crafting.shapedBuilder()
    .name('bellows')
    .output(item('pyrotech:bellows'))
    .shape('BMB',
           'CRC',
           'S S')
    .key('B', item('pyrotech:material', 20))
    .key('M', item('pyrotech:material', 16))
    .key('C', item('minecraft:carpet'))
    .key('R', ore('stickStone'))
    .key('S', item('pyrotech:masonry_brick_block'))
    .register();

// pyrotech brick machines use iron plates, except for kiln which uses wrought iron.
crafting.remove('pyrotech:tech/machine/brick_crucible');
crafting.shapedBuilder()
    .name('brick_crucible')
    .output(item('pyrotech:brick_crucible'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_crucible'))
    .register();

crafting.remove('pyrotech:tech/machine/brick_sawmill');
crafting.shapedBuilder()
    .name('brick_sawmill')
    .output(item('pyrotech:brick_sawmill'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_sawmill'))
    .register();

crafting.remove('pyrotech:tech/machine/brick_oven');
crafting.shapedBuilder()
    .name('brick_oven')
    .output(item('pyrotech:brick_oven'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_oven'))
    .register();

crafting.remove('pyrotech:tech/machine/brick_kiln');
crafting.shapedBuilder()
    .name('brick_kiln')
    .output(item('pyrotech:brick_kiln'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateWroughtIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_kiln'))
    .register();

crafting.remove('thermalfoundation:storage_resource_1');
crafting.remove('thermalfoundation:clay_ball');
crafting.remove('thermalfoundation:block_dirt');

crafting.shapelessBuilder()
    .name('leaves_to_fiber')
    .output(item('pyrotech:material', 12))
    .input(ore('treeLeaves'))
    .input(ore('toolKnife'))
    .register();

crafting.remove('gregtech:tiny_dust_disassembling_ash');
crafting.shapedBuilder()
    .name('ash_tiny')
    .output(metaitem('dustTinyAsh'))
    .shape('D ', '  ')
    .key('D', ore('dustAsh'))
    .register();

crafting.remove('gregtech:small_dust_disassembling_ash');
crafting.shapedBuilder()
    .name('ash_small')
    .output(metaitem('dustSmallAsh'))
    .shape(' D', '  ')
    .key('D', ore('dustAsh'))
    .register();

// remove basic clay brick, use wooden form
crafting.remove('pyrotech:unfired_brick');
crafting.shapelessBuilder()
    .name('clay_brick')
    .output(item('pyrotech:material', 24))
    .input(metaitem('wooden_form.brick').reuse())
    .input(item('minecraft:clay_ball'))
    .register();

crafting.shapedBuilder()
    .name('clay_brick_x8')
    .output(item('pyrotech:material', 24) * 8)
    .shape('ccc', 'cwc', 'ccc')
    .key('c', item('minecraft:clay_ball'))
    .key('w', metaitem('wooden_form.brick').reuse())
    .register();

crafting.remove('pyrotech:refractory_brick_unfired');
crafting.shapelessBuilder()
    .name('refractory_brick')
    .output(item('pyrotech:material', 9))
    .input(metaitem('wooden_form.brick').reuse())
    .input(item('pyrotech:material', 4))
    .register();

crafting.shapedBuilder()
    .name('refractory_brick_x8')
    .output(item('pyrotech:material', 9) * 8)
    .shape('ccc', 'cwc', 'ccc')
    .key('c', item('pyrotech:material', 4))
    .key('w', metaitem('wooden_form.brick').reuse())
    .register();

crafting.remove('pyrotech:refractory_clay_ball');
crafting.shapedBuilder()
    .name('refractory_clay')
    .output(item('pyrotech:material', 4) * 10)
    .shape('cac', 'sfs', 'cac')
    .key('c', item('minecraft:clay_ball'))
    .key('a', item('pyrotech:material', 0))
    .key('s', item('pyrotech:material', 8))
    .key('f', item('pyrotech:material', 3))
    .register();

crafting.remove('pyrotech:refractory_clay_lump_from_unfired_refractory_brick');

crafting.remove('pyrotech:furnace_core');
crafting.shapedBuilder()
    .name('furnace_core')
    .output(item('pyrotech:furnace_core') * 4)
    .shape('iii', 'ccc', 'iii')
    .key('i', ore('ingotIron'))
    .key('c', ore('plateCopper'))
    .register();

furnace.add(metaitem('ingotWroughtIron'), item('minecraft:iron_ingot'));

// make ironclad anvil use iron plates
crafting.remove('pyrotech:tech/basic/anvil_iron_plated');
crafting.shapedBuilder()
    .name('ironclad_anvil')
    .output(item('pyrotech:anvil_iron_plated'))
    .shape('iii', 'ggg', 'sss')
    .key('i', ore('plateIron'))
    .key('g', item('minecraft:stone', 2))
    .key('s', ore('slabStone'))
    .register();
