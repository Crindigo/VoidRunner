package postInit.steam;

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
    //crafting.addShapeless("clay_${stoneType.key}", stoneType.value[0], [stoneType.value[1], ore("dustSmallClay")]);
}

/*
crafting.addShaped("masonry_brick", item('pyrotech:material', 16) * 4, [
    [ore('dustClay'), ore('dustClay'), ore('dustClay')],
    [ore('dustStone'), metaitem('wooden_form.brick').reuse(), ore('dustStone')],
    [ore('dustStone'), ore('dustStone'), ore('dustStone')]
]);
*/

// plant fiber drying, smelt twine to string
//furnace.add(item('pyrotech:material', 12), item('pyrotech:material', 13))
//furnace.add(item('pyrotech:material', 14), item('minecraft:string'));

//crafting.remove('pyrotech:refractory_brick_unfired');
//crafting.addShaped("refractory_brick", item('pyrotech:material', 9) * 4, [
//    [ore('itemClay'), ore('itemClay'), ore('itemClay')],
//    [ore('dustFlint'), metaitem('wooden_form.brick').reuse(), ore('dustFlint')],
//    [ore('sand'), ore('sand'), ore('sand')]
//]);

crafting.remove("randomthings:fertilizeddirt");
crafting.addShapeless("fertilized_dirt", item("randomthings:fertilizeddirt"), [ore('dirt'), metaitem('fertilizer')]);

// need to mold this w/ machines
crafting.remove('minecraft:glass_bottle');


// we will need a primitive evaporator multi for making shiny chunks
// and a steam/electric decomposer for getting stuff from chunks