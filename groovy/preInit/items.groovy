import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.api.items.metaitem.StandardMetaItem;

eventManager.listen { PostMaterialEvent event ->
    
    StandardMetaItem m = new StandardMetaItem();
    m.setRegistryName("voidrunner:meta_item");

    m.addItem(1, "shiny_stone_chunk");
    m.addItem(2, "shiny_magma_chunk");
    m.addItem(3, "fine_dirt");
}


//content.createItem("shiny_stone_chunk").register();
//content.createItem("shiny_magma_chunk").register();
