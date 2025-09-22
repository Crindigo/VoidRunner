crafting.remove('ceramics:decoration/unfired_porcelain_quartz');
crafting.remove('ceramics:decoration/unfired_porcelain_bone_meal');

crafting.addShapeless('unfired_porcelain', item('ceramics:unfired_clay', 4) * 2, 
    [item('minecraft:clay_ball'), item('minecraft:clay_ball'), item('pyrotech:material', 28)]);

def kilnRecipes = [
    ['porcelain_brick', item('ceramics:unfired_clay', 4), item('ceramics:unfired_clay', 5), item('foundry:small_clay')],
    ['porcelain_block', item('ceramics:clay_soft'), item('ceramics:porcelain'), item('foundry:small_clay') * 3],
    ['porcelain_barrel', item('ceramics:clay_barrel_unfired', 2), item('ceramics:porcelain_barrel'), item('foundry:small_clay') * 4],
    ['porcelain_ext', item('ceramics:clay_barrel_unfired', 3), item('ceramics:porcelain_barrel_extension'), item('foundry:small_clay') * 2],
    ['porcelain_faucet', item('ceramics:unfired_clay', 6), item('ceramics:faucet'), item('foundry:small_clay')],
    ['porcelain_channel', item('ceramics:unfired_clay', 7), item('ceramics:channel'), item('foundry:small_clay')],

    ['clay_barrel', item('ceramics:clay_barrel_unfired'), item('ceramics:clay_barrel'), item('pyrotech:material', 7)],
    ['clay_ext', item('ceramics:clay_barrel_unfired', 1), item('ceramics:clay_barrel', 1), item('pyrotech:material', 7)],
];

for (kr in kilnRecipes) {
    mods.pyrotech.stone_kiln.add(kr[0], kr[1], kr[2], 1200, 0.1f, kr[3]);
    mods.pyrotech.brick_kiln.add(kr[0], kr[1], kr[2], 1200, 0.02f, kr[3]);
}