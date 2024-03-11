package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;

// Use ids 1000-1999
class FirstDegreeMaterials
{
    public static void init()
    {
        PotassiumHydroxide = newBuilder(1000, "potassium_hydroxide")
            .dust()
            .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
            .colorAverage()
            .build();
    }
}
