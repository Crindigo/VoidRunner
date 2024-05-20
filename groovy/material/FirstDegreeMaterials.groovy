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
            .components(Potassium, Oxygen, Hydrogen)
            .colorAverage()
            .build();

        LeadOxide = material(1001, "lead_oxide") {
            dust()
            components Lead, Oxygen
            flags 'disable_decomposition'
            colorAverage()
        }

        LeadSulfate = material(1002, "lead_sulfate") {
            dust()
            components Lead, Sulfur, Oxygen * 4
            flags 'disable_decomposition'
            colorAverage()
        }

        Lanarkite = material(1003, "lanarkite") {
            dust()
            components Lead * 2, Sulfur, Oxygen * 5
            flags 'disable_decomposition'
            colorAverage()
        }
        Lanarkite.setFormula("Pb2(SO4)O");

        CopperPhosphide = material(1004, "copper_phosphide") {
            dust()
            components Copper * 3, Phosphorus
            flags 'disable_decomposition'
            colorAverage()
        }

        CopperSulfide = material(1005, "copper_sulfide") {
            dust()
            components Copper * 2, Sulfur
            flags 'decomposition_by_centrifuging'
            colorAverage()
        }

        // in GTFO
        /*SodiumSulfate = material(1006, "sodium_sulfate") {
            dust()
            components(Sodium * 2, Sulfur, Oxygen * 4)
            flags 'disable_decomposition'
            color(0xefefef)
        }*/

    }
}
