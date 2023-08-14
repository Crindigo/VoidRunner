import mods.advancedmortars.Mortar;
import mods.alchemistry.Dissolver;
import mods.pyrotech.StoneCrucible;
import mods.pyrotech.BrickCrucible;


// clay dust to clay in water
mods.inworldcrafting.FluidToItem.transform(<minecraft:clay_ball>, <liquid:water>, [<ore:dustClay>], false);

// types, output, duration, inputs
// or: types, output, duration, secondary, chance, inputs
Mortar.addRecipe(['wood', 'stone'], <minecraft:gravel>, 20, [<minecraft:cobblestone>]);
Mortar.addRecipe(['wood', 'stone'], <minecraft:flint>, 20, [<minecraft:gravel>]);
Mortar.addRecipe(['wood', 'stone'], <gregtech:meta_item_1:1001>, 50, [<ore:sand>, <ore:dustWood>, <ore:dustBone>]);

StoneCrucible.removeAllRecipes();
BrickCrucible.removeAllRecipes();

StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 300);
BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 300);

// fisher price method
// mods.alchemistry.Combiner.removeRecipe(IItemStack output);
// mods.alchemistry.Combiner.addRecipe(IItemStack output, IItemstack[] input);
// Dissolver.removeRecipe(output)
// Dissolver.addRecipe(output, weighted, rolls, [ [chance, item, ...], [chance2, item, ...] ])
