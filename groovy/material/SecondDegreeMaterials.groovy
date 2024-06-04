package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;

// use ids 2000-2999
class SecondDegreeMaterials
{
    public static void init()
    {
        PotassiumChlorideSolution = newBuilder(2000, "potassium_chloride_solution")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .components(RockSalt, Water)
            .colorAverage()
            .flags("disable_decomposition")
            .build();
        
        PotassiumHydroxideSolution = newBuilder(2001, "potassium_hydroxide_solution")
            .liquid(new FluidBuilder().temperature(293)) // liquid, acid, gas, plasma
            .components(PotassiumHydroxide, Water)
            .colorAverage()
            .build();

        // Pb9Cu(PO4)6O
        // EBF generated recipes always 120eu/t unless override given.
        // EBF duration default is mass * temperature / 50
        LK99Good = newBuilder(2002, "lk_99_good")
            .ingot()
            .cableProperties(128, 4, 0, true, 78)
            .components(Lead * 9, Copper, Phosphate * 6, Oxygen)
            .flags('disable_decomposition')
            .blastTemp(1700, "LOW", 120, 900)
            .colorAverage()
            .build();
        
        WhiteLiquor = newBuilder(2003, "white_liquor")
            .liquid(new FluidBuilder().temperature(343))
            .components(Water, SodiumSulfide, SodiumHydroxide)
            .color(0xf8f8f8)
            .flags('disable_decomposition')
            .build();
        
        NickelCarbonyl = newBuilder(2004, "nickel_carbonyl")
            .gas(new FluidBuilder().temperature(328))
            .components(Nickel, CarbonMonoxide * 4)
            .colorAverage()
            .build();
    }
}
