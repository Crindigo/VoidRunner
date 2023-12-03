import gregtech.api.GregTechAPI
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.event.MaterialRegistryEvent
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.properties.ToolProperty
import material.VoidMaterials;

event_manager.listen { MaterialRegistryEvent event ->
    GregTechAPI.materialManager.createRegistry("voidrunner");
}

event_manager.listen { MaterialEvent event -> 
    VoidMaterials.init();
}