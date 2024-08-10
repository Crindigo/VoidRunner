package postInit.mod;
import static classes.Helpers.*;

crafting.remove('extendedcrafting:black_iron_ingot');

recipemap('alloy_smelter').recipeBuilder()
    .inputs(ore('dustObsidian') * 4, ore('ingotBlackSteel'))
    .outputs(ore('ingotBlackIron').first)
    .EUt(16 * toHV)
    .duration(200)
    .buildAndRegister();

crafting.remove('extendedcrafting:black_iron_rod');
recipemap('lathe').recipeBuilder()
    .inputs(ore('ingotBlackIron'))
    .outputs(item('extendedcrafting:material', 3) * 2)
    .EUt(16)
    .duration(120)
    .buildAndRegister();

// no guarantee this mod sticks around