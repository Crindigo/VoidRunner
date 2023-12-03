package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;


class OreProcMaterials
{
    public static void init()
    {
        StoneExtract = newBuilder(1i, "stone_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xCDCDCD)
            .fluidTemp(293)
            .build();
        
        GraniteExtract = newBuilder(2i, "granite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xD9726A)
            .fluidTemp(293)
            .build();
    
        AndesiteExtract = newBuilder(3i, "andesite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xC6C6C6)
            .fluidTemp(293)
            .build();
        
        DioriteExtract = newBuilder(4i, "diorite_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0xDFDFDF)
            .fluidTemp(293)
            .build();
        
        LimestoneExtract = newBuilder(5i, "limestone_extract")
            .fluid("liquid", false) // liquid, acid, gas, plasma
            .color(0x78855A)
            .fluidTemp(293)
            .build();
    }
}