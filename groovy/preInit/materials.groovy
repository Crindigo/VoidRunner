import gregtech.api.GregTechAPI
import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.event.MaterialRegistryEvent
import gregtech.api.unification.material.event.PostMaterialEvent
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.properties.ToolProperty
import material.VoidMaterials;
import gregtech.api.unification.material.Materials;
import static gregtech.api.unification.material.info.MaterialFlags.*;

event_manager.listen { MaterialRegistryEvent event ->
    // created in core
    //GregTechAPI.materialManager.createRegistry("voidrunner");
}

event_manager.listen { MaterialEvent event -> 

    VoidMaterials.init();
}

event_manager.listen { PostMaterialEvent event ->
    //Materials.Carbon.addFlags(GENERATE_PLATE);
    //Materials.Manganese.addFlags(GENERATE_ROD, GENERATE_LONG_ROD);
    //Materials.Iron.addFlags(GENERATE_FOIL);
    //Materials.BlackBronze.addFlags(GENERATE_ROTOR);
    material('carbon').addFlags(GENERATE_PLATE);
    material('manganese').addFlags(GENERATE_ROD, GENERATE_LONG_ROD);
    material('iron').addFlags(GENERATE_FOIL);
    material('black_bronze').addFlags(GENERATE_ROTOR);
    // over 1750 generates ingotHot
    material('black_bronze').addBlastProperty(1800, "LOW", 600, 120);
}