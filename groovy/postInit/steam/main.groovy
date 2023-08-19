import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.event.entity.player.PlayerEvent

import net.minecraft.item.ItemStack

println('Hello World!')

crafting.addShapeless("early_cobble", item("minecraft:cobblestone"), [ore("dustStone"), ore("dustSmallClay")]);

crafting.remove("advancedmortars:mortar_wood");
crafting.remove("advancedmortars:mortar_stone");
crafting.remove("advancedmortars:mortar_iron");
crafting.remove("advancedmortars:mortar_diamond");
crafting.remove("advancedmortars:mortar_gold");
crafting.remove("advancedmortars:mortar_obsidian");
crafting.remove("advancedmortars:mortar_emerald");

crafting.remove("pyrotech:tool/crude_axe");
crafting.addShaped("crude_axe", item('pyrotech:crude_axe'), [
    [ore('cobblestone'), item('pyrotech:material', 12)],
    [null, ore('stickWood')]
]);

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

crafting.addShaped("refractory_brick", item('pyrotech:material', 9) * 4, [
    [ore('itemClay'), ore('itemClay'), ore('itemClay')],
    [ore('dustFlint'), metaitem('wooden_form.brick').reuse(), ore('dustFlint')],
    [ore('sand'), ore('sand'), ore('sand')]
]);

crafting.remove("randomthings:fertilizeddirt");
crafting.addShapeless("fertilized_dirt", item("randomthings:fertilizeddirt"), [ore('dirt'), metaitem('fertilizer')]);

// Dissolver recipe
crafting.remove('alchemistry:chemical_dissolver');
crafting.addShaped("alc_dissolver", item('alchemistry:chemical_dissolver'), [
    [ore('plateTin'), ore('wireGtSingleCopper'), ore('plateTin')],
    [ore('plateTin'), ore('blockRedstone'), ore('plateTin')],
    [ore('plateTin'), ore('wireGtSingleCopper'), ore('plateTin')],
]);

// Survival gen recipe
crafting.remove('extrautils2:generator_survivalist')
crafting.addShaped("survival_gen", item('extrautils2:machine').withNbt(["Type": "extrautils2:generator_survival"]), [
    [ore('plateIron'), ore('plateIron'), ore('plateIron')],
    [ore('plateIron'), item('minecraft:furnace'), ore('plateIron')],
    [ore('craftingPiston'), ore('wireGtSingleCopper'), ore('craftingPiston')],
]);
