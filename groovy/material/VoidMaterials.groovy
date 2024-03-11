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

    // first degree
    public static Material PotassiumHydroxide;

    // second degree
    public static Material PotassiumChlorideSolution;
    public static Material PotassiumHydroxideSolution;
    
    public static void init()
    {
        OreProcMaterials.init();
        FirstDegreeMaterials.init();
        SecondDegreeMaterials.init();
    }

    public static ResourceLocation voidId(String name) {
        return new ResourceLocation("voidrunner:$name");
    }

    public static Material.Builder newBuilder(int id, String name) {
        //return GSUtil.newMaterialBuilder(id, voidId(name));
        return new Material.Builder(id, voidId(name));
    }
}