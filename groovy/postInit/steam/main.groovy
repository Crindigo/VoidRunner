println('Hello World!')

def stoneTypes = [
    "cobblestone": [item('minecraft:cobblestone'), ore('dustStone')],
    "andesite": [item('minecraft:stone', 5), ore('dustAndesite')],
    "diorite": [item('minecraft:stone', 3), ore('dustDiorite')],
    "granite": [item('minecraft:stone', 1), ore('dustGranite')],
    "marble": [item('gregtech:stone_cobble', 2), ore('dustMarble')],
    "basalt": [item('gregtech:stone_cobble', 3), ore('dustBasalt')],
    "redgranite": [item('gregtech:stone_cobble', 1), ore('dustGraniteRed')],
    "blackgranite": [item('gregtech:stone_cobble'), ore('dustGraniteBlack')],
    "netherrack": [item('minecraft:netherrack'), ore('dustNetherrack')],
];
for (stoneType in stoneTypes ) {
    crafting.addShapeless("clay_${stoneType.key}", stoneType.value[0], [stoneType.value[1], ore("dustSmallClay")]);
}

crafting.remove("pyrotech:tool/crude_axe");
crafting.addShaped("crude_axe", item('pyrotech:crude_axe'), [
    [ore('cobblestone'), item('pyrotech:material', 12)],
    [null, ore('stickWood')]
]);

crafting.addShaped("masonry_brick", item('pyrotech:material', 16) * 4, [
    [ore('dustClay'), ore('dustClay'), ore('dustClay')],
    [ore('dustStone'), metaitem('wooden_form.brick').reuse(), ore('dustStone')],
    [ore('dustStone'), ore('dustStone'), ore('dustStone')]
]);

// plant fiber drying, smelt twine to string
furnace.add(item('pyrotech:material', 12), item('pyrotech:material', 13))
furnace.add(item('pyrotech:material', 14), item('minecraft:string'));

crafting.remove('pyrotech:refractory_brick_unfired');
crafting.addShaped("refractory_brick", item('pyrotech:material', 9) * 4, [
    [ore('itemClay'), ore('itemClay'), ore('itemClay')],
    [ore('dustFlint'), metaitem('wooden_form.brick').reuse(), ore('dustFlint')],
    [ore('sand'), ore('sand'), ore('sand')]
]);

crafting.remove("randomthings:fertilizeddirt");
crafting.addShapeless("fertilized_dirt", item("randomthings:fertilizeddirt"), [ore('dirt'), metaitem('fertilizer')]);

// need to mold this w/ machines
crafting.remove('minecraft:glass_bottle');

crafting.shapelessBuilder()
    .name('leaves_to_fiber')
    .output(item('pyrotech:material', 12))
    .input(ore('treeLeaves'))
    .input(ore('toolKnife'))
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
crafting.remove('pyrotech:clay');
crafting.remove('pyrotech:clay_ball');

// we will need a primitive evaporator multi for making shiny chunks
// and a steam/electric decomposer for getting stuff from chunks