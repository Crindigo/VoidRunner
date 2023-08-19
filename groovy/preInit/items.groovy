import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.*;

eventManager.listen { GregTechAPI.PostMaterialEvent event ->
    
    StandardMetaItem m = new StandardMetaItem();
    m.setRegistryName("meta_item");

    m.addItem(1, "shiny_stone_chunk");
    m.addItem(2, "shiny_magma_chunk");
}


//content.createItem("shiny_stone_chunk").register();
//content.createItem("shiny_magma_chunk").register();
