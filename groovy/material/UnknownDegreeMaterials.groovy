package material;
import static material.VoidMaterials.*;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import gregtech.api.fluids.FluidBuilder;

// Use ids 4000-4999
class UnknownDegreeMaterials
{
    public static void init() {
        WeakBlackLiquor = newBuilder(4000, "weak_black_liquor")
            .liquid(new FluidBuilder().temperature(343))
            .color(0x404040)
            .build();

        StrongBlackLiquor = newBuilder(4001, "strong_black_liquor")
            .liquid(new FluidBuilder().temperature(343))
            .color(0x202020)
            .build();
    }
}