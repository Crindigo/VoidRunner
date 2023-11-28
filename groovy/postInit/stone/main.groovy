crafting.remove('pyrotech:clay');

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

// pyrotech brick crucible uses iron plates
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