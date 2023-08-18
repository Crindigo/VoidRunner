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

crafting.shapedBuilder()
    .name("masonry_brick")
    .output(item('pyrotech:material', 16) * 4)
    .row('CCC')
    .row('SMS')
    .row('SSS')
    .key('C', ore('dustClay'))
    .key('S', ore('dustStone'))
    .key('M', metaitem('wooden_form.brick').reuse())
    .register();

furnace.add(item('pyrotech:material', 12), item('pyrotech:material', 13))

furnace.removeByInput(item('minecraft:sand'));
furnace.add(metaitem('dustGlass'), item('minecraft:glass'));

crafting.addShapeless("twine_to_string", item('minecraft:string'), 
    [item('pyrotech:material', 14), item('pyrotech:material', 14)]);

crafting.shapedBuilder()
    .name("refractory_brick")
    .output(item('pyrotech:material', 9) * 4)
    .row('CCC')
    .row('FMF')
    .row('SSS')
    .key('C', ore('itemClay'))
    .key('F', ore('dustFlint'))
    .key('M', metaitem('wooden_form.brick').reuse())
    .key('S', ore('sand'))
    .register();

crafting.remove("randomthings:fertilizeddirt");
crafting.addShapeless("fertilized_dirt", item("randomthings:fertilizeddirt"), [ore('dirt'), metaitem('fertilizer')]);

//event_manager.listen { PlayerEvent.BreakSpeed event -> 
//    log.info("break speed: {} {}", event.getState(), event.getOriginalSpeed())
//}

/*event_manager.listen { HarvestDropsEvent event ->
    log.info('Harvest: {} {} {}', event.getState(), event.getDropChance(), event.getDrops())
    if ( !event.isSilkTouching() ) {
        event.getDrops().add(item("minecraft:sapling", 0))
        event.getDrops().add(item("minecraft:stick"))
        event.setDropChance(0.2)
    }
}*/