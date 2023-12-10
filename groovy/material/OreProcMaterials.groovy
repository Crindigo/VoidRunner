package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.info.MaterialFlags.*;

class OreProcMaterials
{
    public static void init()
    {
        StoneExtract = newBuilder(1, "stone_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xCDCDCD)
            .fluidTemp(293)
            .build();
        
        GraniteExtract = newBuilder(2, "granite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xD9726A)
            .fluidTemp(293)
            .build();
    
        AndesiteExtract = newBuilder(3, "andesite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xC6C6C6)
            .fluidTemp(293)
            .build();
        
        DioriteExtract = newBuilder(4, "diorite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xDFDFDF)
            .fluidTemp(293)
            .build();
        
        LimestoneExtract = newBuilder(5, "limestone_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0x78855A)
            .fluidTemp(293)
            .build();
        
        DirtExtract = newBuilder(6, "dirt_extract")
            .fluid("liquid", false)
            .color(0x7A4115)
            .fluidTemp(293)
            .build();
        
        NatureExtract = newBuilder(7, "nature_extract")
            .fluid("liquid", false)
            .color(0x58B809)
            .fluidTemp(293)
            .build();
    }
}