import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.api.items.metaitem.*;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;

eventManager.listen { PostMaterialEvent event ->
    
    StandardMetaItem m = new StandardMetaItem();
    m.setRegistryName("voidrunner:meta_item");

    m.addItem(1, "shiny_stone_chunk");
    m.addItem(2, "shiny_magma_chunk");
    m.addItem(3, "leyden_jar");
    m.addItem(4, "resistor_carbon_pile");
    m.addItem(5, "williams_tube");
    m.addItem(6, "relay");
    m.addItem(7, "drum_memory");
    m.addItem(8, "large_hdd_platter");
    m.addItem(9, "retro_hdd");
    m.addItem(10, "basic_air_cooler");
    m.addItem(11, "retro_capacitor");
    m.addItem(12, "plated_wire_memory");

    // Circuits
    m.addItem(501, "circuit_primitive");
    m.addItem(502, "circuit_retro");
    m.addItem(503, "circuit_standard");
    m.addItem(504, "circuit_reliable");

    m.addItem(551, "computer_primitive");
    m.addItem(552, "computer_retro");
    m.addItem(553, "computer_standard");
    m.addItem(554, "computer_reliable");

    // Batteries
    m.addItem(1000, "battery.lv.lead_acid")
        .addComponents(ElectricStats.createRechargeableBattery(100000, GTValues.LV))
        .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LV)
        .setModelAmount(8)
        .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

    MetaOreDictItem d = new MetaOreDictItem((short) 0);
    d.setRegistryName("voidrunner:ore_dict_item");

    // id, name, color, iconset, oreprefix, [formula]
    d.addOreDictItem(1, "cork", 0xd08757, MaterialIconSet.WOOD, OrePrefix.crushed);
    d.addOreDictItem(2, "carbon_clay_compound", 0x4e4e4e, MaterialIconSet.DULL, OrePrefix.dust);
    d.addOreDictItem(3, "carbon_resistor_core", 0x4e4e4e, MaterialIconSet.DULL, OrePrefix.bolt);
    // al recycling
    d.addOreDictItem(4, "aluminium_scrap", 0x80C8F8, MaterialIconSet.FINE, OrePrefix.gemChipped);
    d.addOreDictItem(5, "aluminium_scrap", 0x80C8F8, MaterialIconSet.FINE, OrePrefix.crushed);
    d.addOreDictItem(6, "aluminium_scrap", 0x80C8F8, MaterialIconSet.FINE, OrePrefix.dustImpure);
    d.addOreDictItem(7, "aluminium_scrap", 0x80C8F8, MaterialIconSet.FINE, OrePrefix.dustPure);
    // kraft paper chain
    d.addOreDictItem(8, "impregnated_wood_pulp", 0x703818, MaterialIconSet.DULL, OrePrefix.dust);
    d.addOreDictItem(9, "brownstock", 0x2b1508, MaterialIconSet.DULL, OrePrefix.dust);
    d.addOreDictItem(10, "kraft_pulp", 0x99673f, MaterialIconSet.DULL, OrePrefix.dust);
    d.addOreDictItem(11, "kraft_paper", 0x99673f, MaterialIconSet.DULL, OrePrefix.foil);
    
    d.addOreDictItem(12, "soy_wax", 0xefede2, MaterialIconSet.DULL, OrePrefix.crushedCentrifuged);
    d.addOreDictItem(13, "sulfuric_lead_paste", 0x6436ad, MaterialIconSet.DULL, OrePrefix.crushedCentrifuged);
}

//content.createItem("shiny_stone_chunk").register();
//content.createItem("shiny_magma_chunk").register();
