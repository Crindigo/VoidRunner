import mods.foundry.BurnerHeater;
import mods.foundry.Melting;
import mods.foundry.CastingTable;

// 2330K
BurnerHeater.addFuel(<ore:blockCoke>, 32000, 233000);

Melting.addRecipe(<liquid:lava> * 250, <ore:stone>, 2200, 300);
Melting.addRecipe(<liquid:lava> * 250, <ore:cobblestone>, 2200, 300);
Melting.addRecipe(<liquid:lava> * 250, <ore:gravel>, 2200, 300);
Melting.addRecipe(<liquid:lava> * 500, <ore:netherrack>, 1200, 200);

// melt clay for 250L per ball. setting durations 4x higher because low temp makes it melt faster.
Melting.addRecipe(<liquid:liquid_clay> * 250, <minecraft:clay_ball>, 600, 600);
Melting.addRecipe(<liquid:liquid_clay> * 1000, <minecraft:clay>, 600, 1800);

// melt sticky resin for 125L glue
Melting.addRecipe(<liquid:glue> * 125, <gregtech:meta_item_1:438>, 600, 300);

// remove glass melting, re-add with glass dust and make 144L base.
// replace plate and block mold recipes for glass.
Melting.removeRecipe(<minecraft:glass>);
Melting.removeRecipe(<minecraft:glass_pane>);
Melting.addRecipe(<liquid:glass> * 144, <minecraft:glass>, 1450, 200);
Melting.addRecipe(<liquid:glass> * 54, <minecraft:glass_pane>, 1450, 200); // same ratio as cutting saw
Melting.addRecipe(<liquid:glass> * 144, <gregtech:meta_dust:2000>, 1450, 200);

CastingTable.removeBlockRecipe(<liquid:glass> * 1000);
CastingTable.removePlateRecipe(<liquid:glass> * 375);
CastingTable.addBlockRecipe(<minecraft:glass>, <liquid:glass> * 144);
CastingTable.addPlateRecipe(<minecraft:glass_pane>, <liquid:glass> * 72);