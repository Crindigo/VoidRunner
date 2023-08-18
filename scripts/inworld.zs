import mods.advancedmortars.Mortar;
import mods.alchemistry.Dissolver;
import mods.pyrotech.StoneCrucible;
import mods.pyrotech.BrickCrucible;


// clay dust to clay in water
mods.inworldcrafting.FluidToItem.transform(<minecraft:clay_ball>, <liquid:water>, [<ore:dustClay>], false);

// stone dust in water makes stone solution
mods.inworldcrafting.FluidToFluid.transform(<liquid:stone_solution>, <liquid:water>, [<ore:dustStone>]);

// types, output, duration, inputs
// or: types, output, duration, secondary, chance, inputs
Mortar.addRecipe(['stone'], <minecraft:gravel>, 20, [<minecraft:cobblestone>]);
Mortar.addRecipe(['stone'], <minecraft:flint>, 20, <minecraft:sand>, 0.5, [<minecraft:gravel>]);
Mortar.addRecipe(['stone'], <gregtech:meta_item_1:1001>, 50, [<ore:sand>, <ore:dustWood>, <ore:dustBone>]);

StoneCrucible.removeAllRecipes();
BrickCrucible.removeAllRecipes();

// you can do 8 operations at once so this is 2 buckets per minute
StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 1200, true);
BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 1200);

// placeholder rare earth. make some other material that dissolves into fun stuff.
mods.alchemistry.Evaporator.addRecipe(<gregtech:meta_dust:1598>, <liquid:stone_solution> * 250);
// also replace the one for lava
mods.alchemistry.Evaporator.removeRecipe(<liquid:lava>);

// fisher price method
// mods.alchemistry.Combiner.removeRecipe(IItemStack output);
// mods.alchemistry.Combiner.addRecipe(IItemStack output, IItemstack[] input);
// Dissolver.removeRecipe(output)
// Dissolver.addRecipe(output, weighted, rolls, [ [chance, item, ...], [chance2, item, ...] ])
