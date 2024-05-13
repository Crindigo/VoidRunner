import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.MetaOreDictItem;
import com.bartz24.skyresources.alchemy.item.ItemOreAlchDust;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;

eventManager.listen { PostMaterialEvent event ->
    
    StandardMetaItem m = new StandardMetaItem();
    m.setRegistryName("voidrunner:meta_item");

    m.addItem(1, "shiny_stone_chunk");
    m.addItem(2, "shiny_magma_chunk");
    m.addItem(3, "leyden_jar");
    m.addItem(4, "resistor_carbon_pile");

    MetaOreDictItem d = new MetaOreDictItem((short) 0);
    d.setRegistryName("voidrunner:ore_dict_item");

    // id, name, color, iconset, oreprefix, [formula]
    d.addOreDictItem(1, "cork", 0xd08757, MaterialIconSet.WOOD, OrePrefix.crushed);
    d.addOreDictItem(2, "carbon_clay_compound", 0x4e4e4e, MaterialIconSet.DULL, OrePrefix.dust);
    d.addOreDictItem(3, "carbon_resistor_core", 0x4e4e4e, MaterialIconSet.DULL, OrePrefix.bolt);
}

//ItemOreAlchDust.addOreInfo("naquadah", 0xFF222324i);

//content.createItem("shiny_stone_chunk").register();
//content.createItem("shiny_magma_chunk").register();
