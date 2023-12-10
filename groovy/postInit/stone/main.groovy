crafting.remove('pyrotech:clay');

// remove extra hopper recipes, one with no ID, have to re-add GT one (unless it's just a JEI/GS bug)
crafting.remove('enderio:tweak_wood_hopper');
crafting.removeByOutput(item('minecraft:hopper'));
crafting.shapedBuilder()
    .name('hopper')
    .output(item('minecraft:hopper'))
    .shape('pcp', 'pgp', 'wph')
    .key('p', ore('plateIron'))
    .key('c', ore('chest'))
    .key('g', ore('gearSmallIron'))
    .key('w', ore('toolWrench'))
    .key('h', ore('toolHammer'))
    .register();

furnace.removeByInput(item('minecraft:clay_ball'));


// remove crude drying rack and make the normal one only use fiber instead of twine
mods.jei.yeet(item('pyrotech:drying_rack', 0));
crafting.remove('pyrotech:tech/basic/drying_rack');
crafting.shapedBuilder()
    .name('drying_rack')
    .output(item('pyrotech:drying_rack', 1))
    .shape('sfs', 'flf', 'sfs')
    .key('s', ore('stickWood'))
    .key('f', item('pyrotech:material', 12))
    .key('l', item('minecraft:ladder'))
    .register();

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
    .key('P', ore('plateWroughtIron'))
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
    .key('P', ore('plateWroughtIron'))
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
    .key('P', ore('plateWroughtIron'))
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

crafting.shapedBuilder()
    .name('wooden_form')
    .output(metaitem('wooden_form.empty'))
    .shape('bb', 'bb')
    .key('b', item('pyrotech:material', 20))
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

// allow stickStone to be used for all pyrotech recipes
crafting.remove('pyrotech:tool/flint_shears');
crafting.shapedBuilder()
    .name('pyro_flint_shears')
    .output(item('pyrotech:flint_shears'))
    .shape('ts', 'ff')
    .key('t', ore('twine'))
    .key('s', ore('stickStone'))
    .key('f', item('pyrotech:material', 10))
    .register();

crafting.remove('pyrotech:tool/bone_shears');
crafting.shapedBuilder()
    .name('pyro_bone_shears')
    .output(item('pyrotech:bone_shears'))
    .shape('ts', 'bb')
    .key('t', ore('twine'))
    .key('s', ore('stickStone'))
    .key('b', item('pyrotech:material', 11))
    .register();

crafting.remove('pyrotech:tech/machine/mechanical_hopper');
crafting.shapedBuilder()
    .name('pyro_mech_hopper')
    .output(item('pyrotech:mechanical_hopper'))
    .shape('b b', 'psp', ' b ')
    .key('b', item('pyrotech:material', 16))
    .key('p', item('pyrotech:planks_tarred'))
    .key('s', ore('stickStone'))
    .register();

crafting.remove('pyrotech:tech/bloomery/tongs_stone');
crafting.shapedBuilder()
    .name('pyro_tongs_stone')
    .output(item('pyrotech:tongs_stone'))
    .shape(' m ', 'smm', ' s ')
    .key('m', item('pyrotech:material', 16))
    .key('s', ore('stickStone'))
    .register();

crafting.remove('pyrotech:tech/bloomery/tongs_flint');
crafting.shapedBuilder()
    .name('pyro_tongs_flint')
    .output(item('pyrotech:tongs_flint'))
    .shape(' m ', 'smm', ' s ')
    .key('m', item('pyrotech:material', 10))
    .key('s', ore('stickStone'))
    .register();

crafting.remove('pyrotech:tech/bloomery/tongs_iron');
crafting.shapedBuilder()
    .name('pyro_tongs_iron')
    .output(item('pyrotech:tongs_iron'))
    .shape(' m ', 'smm', ' s ')
    .key('m', item('pyrotech:material', 19))
    .key('s', ore('stickStone'))
    .register();

// idk, make an inefficient stone rod recipe, we'll get rid of the anvil one
crafting.shapedBuilder()
    .name('stone_rod')
    .output(metaitem('stickStone'))
    .shape('  s', ' s ', 's  ')
    .key('s', ore('cobblestone'))
    .register();

// change pyro quicklime to GT
furnace.removeByInput(item('pyrotech:material', 28));
furnace.add(item('pyrotech:material', 28), metaitem('dustQuicklime'));

// remove pyro crafting table recipe, keep its furnace one but change stone to cobble
crafting.remove('pyrotech:crafting_table');
crafting.remove('pyrotech:chest');
crafting.remove('minecraft:furnace');
crafting.remove('pyrotech:furnace');
crafting.shapedBuilder()
    .name('furnace')
    .output(item('minecraft:furnace'))
    .shape('sss', 'scs', 'sss')
    .key('s', ore('cobblestone'))
    .key('c', item('pyrotech:furnace_core'))
    .register();

crafting.remove('skyresources:dirtfurnace');

crafting.remove('minecraft:andesite');
crafting.remove('minecraft:diorite');
crafting.remove('minecraft:granite');

// bs charcoal
crafting.remove('chisel:charcoal');
crafting.remove('thermalfoundation:storage_resource');
crafting.remove('thermalfoundation:material_7');
crafting.remove('thermalfoundation:material_9');

// convert other types of cobble to standard cobble
crafting.addShapeless("andesite_to_std", item('minecraft:cobblestone'), [item('pyrotech:cobblestone', 0)]);
crafting.addShapeless("diorite_to_std", item('minecraft:cobblestone'), [item('pyrotech:cobblestone', 1)]);
crafting.addShapeless("granite_to_std", item('minecraft:cobblestone'), [item('pyrotech:cobblestone', 2)]);
crafting.addShapeless("limestone_to_std", item('minecraft:cobblestone'), [item('pyrotech:cobblestone', 3)]);

crafting.addShapeless("sand_to_piles", item('pyrotech:rock', 5) * 8, [item('minecraft:sand')]);