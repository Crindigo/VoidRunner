import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.event.entity.player.PlayerEvent

import net.minecraft.item.ItemStack

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

crafting.remove("advancedmortars:mortar_stone");
crafting.addShaped("mortar_stone", item("advancedmortars:mortar", 1), [
    [null, null, ore('stickWood')],
    [ore('stone'), ore('plankWood'), ore('stone')],
    [null, ore('stone'), null]
]);

crafting.addShaped("masonry_brick", item('pyrotech:material', 16) * 4, [
    [ore('dustClay'), ore('dustClay'), ore('dustClay')],
    [ore('dustStone'), metaitem('wooden_form.brick').reuse(), ore('dustStone')],
    [ore('dustStone'), ore('dustStone'), ore('dustStone')]
]);

furnace.add(item('pyrotech:material', 12), item('pyrotech:material', 13))

furnace.removeByInput(item('minecraft:sand'));
furnace.add(metaitem('dustGlass'), item('minecraft:glass'));

crafting.addShapeless("twine_to_string", item('minecraft:string'), 
    [item('pyrotech:material', 14), item('pyrotech:material', 14)]);

crafting.remove('pyrotech:refractory_brick_unfired');
crafting.addShaped("refractory_brick", item('pyrotech:material', 9) * 4, [
    [ore('itemClay'), ore('itemClay'), ore('itemClay')],
    [ore('dustFlint'), metaitem('wooden_form.brick').reuse(), ore('dustFlint')],
    [ore('sand'), ore('sand'), ore('sand')]
]);

crafting.remove("randomthings:fertilizeddirt");
crafting.addShapeless("fertilized_dirt", item("randomthings:fertilizeddirt"), [ore('dirt'), metaitem('fertilizer')]);

// Dissolver recipe
crafting.remove('alchemistry:chemical_dissolver');
crafting.shapedBuilder()
    .name('alc_dissolver')
    .output(item('alchemistry:chemical_dissolver'))
    .shape('TTT',
           'WRW',
           'TTT')
    .key('T', ore('plateTin'))
    .key('W', ore('wireGtSingleCopper'))
    .key('R', ore('blockRedstone'))
    .register();

// Survival gen recipe
crafting.remove('extrautils2:generator_survivalist')
crafting.shapedBuilder()
    .name('survival_gen')
    .output(item('extrautils2:machine').withNbt(["Type": "extrautils2:generator_survival"]))
    .shape('III',
           'IFI',
           'PWP')
    .key('I', ore('plateIron'))
    .key('F', item('minecraft:furnace'))
    .key('P', ore('craftingPiston'))
    .key('W', ore('wireGtSingleCopper'))
    .register();

// need to mold this w/ machines
crafting.remove('minecraft:glass_bottle');

crafting.shapelessBuilder()
    .name('leaves_to_fiber')
    .output(item('pyrotech:material', 12))
    .input(ore('treeLeaves'))
    .input(ore('toolKnife'))
    .register();

// pyrotech brick crucible uses iron places
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

crafting.remove('thermalfoundation:clay_ball');
crafting.remove('thermalfoundation:block_dirt');
crafting.remove('pyrotech:clay');
crafting.remove('pyrotech:clay_ball');