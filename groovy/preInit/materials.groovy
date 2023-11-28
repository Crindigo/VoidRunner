import gregtech.api.GregTechAPI
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.event.MaterialRegistryEvent
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.properties.ToolProperty

event_manager.listen { MaterialRegistryEvent event ->
    GregTechAPI.materialManager.createRegistry("voidrunner");
}

event_manager.listen { MaterialEvent event -> 
    new Material.Builder(1, new ResourceLocation("voidrunner:stone_extract"))
        .fluid("liquid", false) // liquid, acid, gas, plasma
        .color(0xCDCDCD)
        .fluidTemp(293)
        .build()
    
    new Material.Builder(2, new ResourceLocation("voidrunner:granite_extract"))
        .fluid("liquid", false) // liquid, acid, gas, plasma
        .color(0xD9726A)
        .fluidTemp(293)
        .build()
    
     new Material.Builder(3, new ResourceLocation("voidrunner:andesite_extract"))
        .fluid("liquid", false) // liquid, acid, gas, plasma
        .color(0xC6C6C6)
        .fluidTemp(293)
        .build()
    
     new Material.Builder(4, new ResourceLocation("voidrunner:diorite_extract"))
        .fluid("liquid", false) // liquid, acid, gas, plasma
        .color(0xDFDFDF)
        .fluidTemp(293)
        .build()
    
     new Material.Builder(5, new ResourceLocation("voidrunner:limestone_extract"))
        .fluid("liquid", false) // liquid, acid, gas, plasma
        .color(0x78855A)
        .fluidTemp(293)
        .build()
}