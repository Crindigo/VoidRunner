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
// duration=20 is 5 seconds
Mortar.addRecipe(['stone'], <minecraft:gravel>, 20, [<minecraft:cobblestone>]);
Mortar.addRecipe(['stone'], <minecraft:flint>, 20, <minecraft:sand>, 1.0, [<minecraft:gravel>]);
Mortar.addRecipe(['stone'], <gregtech:meta_item_1:1001>, 20, [<ore:sand>, <ore:dustWood>, <ore:dustBone>]);

Mortar.addRecipe(['stone'], <metaitem:dustTin>, 20, <metaitem:dustIron>, 1.0, [<metaitem:voidrunner:shiny_stone_chunk>]);
Mortar.addRecipe(['stone'], <metaitem:dustCopper>, 20, <minecraft:redstone>, 1.0, [<metaitem:voidrunner:shiny_magma_chunk>]);

StoneCrucible.removeAllRecipes();
BrickCrucible.removeAllRecipes();

// you can do 8 operations at once so this is 2 buckets per minute
StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 1200, true);
BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 1200);

// placeholder rare earth. make some other material that dissolves into fun stuff.
mods.alchemistry.Evaporator.addRecipe(<metaitem:voidrunner:shiny_stone_chunk>, <liquid:stone_solution> * 500);
// also replace the one for lava
mods.alchemistry.Evaporator.removeRecipe(<liquid:lava>);
// lava slower to make so give it 2x more
mods.alchemistry.Evaporator.addRecipe(<metaitem:voidrunner:shiny_magma_chunk>, <liquid:lava> * 250);

// fisher price method
// mods.alchemistry.Combiner.removeRecipe(IItemStack output);
// mods.alchemistry.Combiner.addRecipe(IItemStack output, IItemstack[] input);
// Dissolver.removeRecipe(output)
// Dissolver.addRecipe(output, weighted, rolls, [ [chance, item, ...], [chance2, item, ...] ])

mods.alchemistry.Combiner.removeAllRecipes();

Dissolver.removeAllRecipes();
// custom ore prefix for ore chunks probably better here. maybe research gregification.
// actually gregification is getting merged into ceu so just wait a bit and use ore for now.
Dissolver.addRecipe(<metaitem:voidrunner:shiny_stone_chunk>, false, 1, [
    [100, <gregtech:ore_tin_0>, <gregtech:ore_iron_0>]
    [50, <gregtech:ore_nickel_0>],
    // no stone dust here or else you loop that and don't need rockbreaker
    [15, <metaitem:dustGranite>],
    [15, <metaitem:dustDiorite>],
    [15, <metaitem:dustAndesite>],
    [15, <metaitem:dustMarble>],
]);
Dissolver.addRecipe(<metaitem:voidrunner:shiny_magma_chunk>, false, 1, [
    [100, <gregtech:ore_copper_0>, <gregtech:ore_redstone_0>],
    [50, <gregtech:ore_galena_0>],
    [15, <metaitem:dustNetherrack>],
    [15, <metaitem:dustBasalt>],
    [15, <metaitem:dustGraniteRed>],
    [15, <metaitem:dustGraniteBlack>],
]);

// sapling casino
Dissolver.addRecipe(<minecraft:sapling>, true, 1, [
    [10, <minecraft:sapling:1>],
    [10, <minecraft:sapling:2>],
    [10, <minecraft:sapling:3>],
    [10, <minecraft:sapling:4>],
    [10, <minecraft:sapling:5>],
]);
