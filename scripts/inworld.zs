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

Mortar.addRecipe(['stone'], <metaitem:dustTin>, 20, <metaitem:dustIron>, 0.5, [<voidrunner:shiny_stone_chunk>]);
Mortar.addRecipe(['stone'], <metaitem:dustCopper>, 20, <metaitem:dustRedstone>, 0.5, [<voidrunner:shiny_magma_chunk>]);

StoneCrucible.removeAllRecipes();
BrickCrucible.removeAllRecipes();

// you can do 8 operations at once so this is 2 buckets per minute
StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 1200, true);
BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 1200);

// placeholder rare earth. make some other material that dissolves into fun stuff.
mods.alchemistry.Evaporator.addRecipe(<voidrunner:shiny_stone_chunk>, <liquid:stone_solution> * 250);
// also replace the one for lava
mods.alchemistry.Evaporator.removeRecipe(<liquid:lava>);
mods.alchemistry.Evaporator.addRecipe(<voidrunner:shiny_magma_chunk>, <liquid:lava> * 250);

// fisher price method
// mods.alchemistry.Combiner.removeRecipe(IItemStack output);
// mods.alchemistry.Combiner.addRecipe(IItemStack output, IItemstack[] input);
// Dissolver.removeRecipe(output)
// Dissolver.addRecipe(output, weighted, rolls, [ [chance, item, ...], [chance2, item, ...] ])

Dissolver.removeAllRecipes();
// custom ore prefix for ore chunks probably better here. maybe research gregification
Dissolver.addRecipe(<voidrunner:shiny_stone_chunk>, false, 1, [
    [100, <metaitem:oreTin>],
    [100, <metaitem:oreIron>],
    [50, <metaitem:dustStone>],
    [25, <metaitem:dustSilver>]
]);
Dissolver.addRecipe(<voidrunner:shiny_magma_chunk>, false, 1, [
    [100, <metaitem:oreCopper>],
    [50, <metaitem:oreRedstone>],
    [50, <metaitem:dustNetherrack>],
    [25, <metaitem:dustGold>]
]);
