package material;
import gregtech.api.unification.material.Material;
import net.minecraft.util.ResourceLocation;
import com.crindigo.voidrunnercore.util.GSUtil;


class VoidMaterials
{
    // ore proc
    public static Material StoneExtract;
    public static Material GraniteExtract;
    public static Material DioriteExtract;
    public static Material AndesiteExtract;
    public static Material LimestoneExtract;
    public static Material DirtExtract;
    public static Material NatureExtract;
    public static Material SaltEvaporate;
    public static Material AcidicDirtExtract;
    public static Material UltramaficExtract;

    // first degree
    public static Material PotassiumHydroxide;
    public static Material LeadOxide;
    public static Material LeadSulfate;
    public static Material Lanarkite;
    public static Material CopperPhosphide;
    public static Material CopperSulfide;
    public static Material SodiumSulfate;
    public static Material ZincChloride;
    public static Material Permalloy;
    public static Material NickelPure;

    // second degree
    public static Material PotassiumChlorideSolution;
    public static Material PotassiumHydroxideSolution;
    public static Material LK99Good;
    public static Material WhiteLiquor;
    public static Material NickelCarbonyl;

    // third degree
    public static Material LK99Mixture;

    // unknown
    public static Material WeakBlackLiquor;
    public static Material StrongBlackLiquor;

    // ochem
    public static Material Formaldehyde;
    public static Material Bakelite;
    
    public static void init()
    {
        OreProcMaterials.init();
        FirstDegreeMaterials.init();
        SecondDegreeMaterials.init();
        ThirdDegreeMaterials.init();
        UnknownDegreeMaterials.init();
        OchemMaterials.init();
    }

    public static ResourceLocation voidId(String name) {
        return new ResourceLocation("voidrunner:$name");
    }

    public static Material.Builder newBuilder(int id, String name) {
        //return GSUtil.newMaterialBuilder(id, voidId(name));
        return new Material.Builder(id, voidId(name));
    }

    public static Material material(int id, String name, @DelegatesTo(Material.Builder) Closure cl) {
        def mb = new Material.Builder(id, voidId(name))
        def code = cl.rehydrate(mb, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return mb.build()
    }
}