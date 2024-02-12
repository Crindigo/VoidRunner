import net.minecraft.item.ItemStack;
class Items
{
    public static HashMap items = new HashMap();

    public static void init()
    {
        items["Granite"] = item("minecraft:stone", 2);
    }
}