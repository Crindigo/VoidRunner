package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;

// use ids 5000-5999
class OchemMaterials
{
    public static void init()
    {
        Formaldehyde = newBuilder(5000, 'formaldehyde')
            .gas()
            .components(Carbon, Hydrogen * 2, Oxygen)
            .flags("disable_decomposition")
            .colorAverage()
            .build();
        
        // needs a liquid, solid chunk, dust, plate
        Bakelite = newBuilder(5001, 'bakelite')
            .gem()
            .liquid(new FluidBuilder().temperature(393))
            .flags("no_unification", "generate_plate")
            .color(0xeb6942)
            .iconSet("QUARTZ")
            .build();
    }
}