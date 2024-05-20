package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;

class OreProcMaterials
{
    public static void init()
    {
        StoneExtract = newBuilder(1, "stone_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0xCDCDCD)
            .build();
        
        GraniteExtract = newBuilder(2, "granite_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0xD9726A)
            .build();
    
        AndesiteExtract = newBuilder(3, "andesite_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0xC6C6C6)
            .build();
        
        DioriteExtract = newBuilder(4, "diorite_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0xDFDFDF)
            .build();
        
        LimestoneExtract = newBuilder(5, "limestone_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0x78855A)
            .build();
        
        DirtExtract = newBuilder(6, "dirt_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0x7A4115)
            .build();
        
        NatureExtract = newBuilder(7, "nature_extract")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .color(0x58B809)
            .build();

        SaltEvaporate = newBuilder(8, "salt_evaporate")
            .dust()
            .iconSet("fine")
            .components(Salt, RockSalt)
            .colorAverage()
            .flags("decomposition_by_centrifuging")
            .build();
        
        AcidicDirtExtract = newBuilder(9, "acidic_dirt_extract")
            .liquid(new FluidBuilder().temperature(293).attribute(FluidAttributes.ACID))
            .color(0x8A5125)
            .build();

        UltramaficExtract = newBuilder(10, "ultramafic_extract")
            .liquid(293)
            .color(0xA59605)
            .build();
    }
}