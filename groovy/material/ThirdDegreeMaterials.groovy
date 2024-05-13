package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;

// Use ids 3000-3999
class ThirdDegreeMaterials
{
    public static void init()
    {
        //  41 Pb9Cu(PO4)6O + 15 Cu2S + 7 Cu + Pb
        LK99Mixture = material(3000, "lk_99_mixture") {
            dust()
            components LK99Good, 41, CopperSulfide, 15, Copper, 7, Lead, 1
            flags 'no_unification', 'disable_decomposition'
            colorAverage()
        }
    }
}
