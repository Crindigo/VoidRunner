//import mods.advancedmortars.Mortar;
//import mods.alchemistry.Dissolver;
import mods.pyrotech.StoneCrucible;
import mods.pyrotech.BrickCrucible;
import mods.appliedenergistics2.Grinder;


// clay dust to clay in water
mods.inworldcrafting.FluidToItem.transform(<minecraft:clay_ball>, <liquid:water>, [<ore:dustClay>], false);

// stone dust in water makes stone solution
mods.inworldcrafting.FluidToFluid.transform(<liquid:stone_solution>, <liquid:water>, [<ore:dustStone>]);

// types, output, duration, inputs
// or: types, output, duration, secondary, chance, inputs
// duration=20 is 5 seconds
//Mortar.addRecipe(['stone'], <minecraft:gravel>, 20, [<minecraft:cobblestone>]);
//Mortar.addRecipe(['stone'], <minecraft:flint>, 20, <minecraft:sand>, 1.0, [<minecraft:gravel>]);
//Mortar.addRecipe(['stone'], <gregtech:meta_item_1:1001>, 20, [<ore:sand>, <ore:dustWood>, <ore:dustBone>]);

//Mortar.addRecipe(['stone'], <metaitem:dustTin>, 20, <metaitem:dustIron>, 1.0, [<metaitem:voidrunner:shiny_stone_chunk>]);
//Mortar.addRecipe(['stone'], <metaitem:dustCopper>, 20, <minecraft:redstone>, 1.0, [<metaitem:voidrunner:shiny_magma_chunk>]);

// Grinder.addRecipe(IItemStack output, IItemStack input, int turns, @Optional IItemStack secondary1Output,
//                   @Optional float secondary1Chance, @Optional IItemStack secondary2Output, @Optional float secondary2Chance);
Grinder.addRecipe(<minecraft:gravel>, <minecraft:cobblestone>, 5);
Grinder.addRecipe(<minecraft:flint>, <minecraft:gravel>, 5, <minecraft:sand>, 1.0);
Grinder.addRecipe(<metaItem:dustTin>, <metaitem:voidrunner:shiny_stone_chunk>, 5, <metaitem:dustIron>, 1.0);
Grinder.addRecipe(<metaItem:dustCopper>, <metaitem:voidrunner:shiny_magma_chunk>, 5, <minecraft:redstone>, 1.0);

StoneCrucible.removeAllRecipes();
BrickCrucible.removeAllRecipes();

// you can do 8 operations at once so this is 2 buckets per minute
StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 1200, true);
BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 1200);

// placeholder rare earth. make some other material that dissolves into fun stuff.
//mods.alchemistry.Evaporator.addRecipe(<metaitem:voidrunner:shiny_stone_chunk>, <liquid:stone_solution> * 500);
// also replace the one for lava
//mods.alchemistry.Evaporator.removeRecipe(<liquid:lava>);
// lava slower to make so give it 2x more
//mods.alchemistry.Evaporator.addRecipe(<metaitem:voidrunner:shiny_magma_chunk>, <liquid:lava> * 250);

// fisher price method
// mods.alchemistry.Combiner.removeRecipe(IItemStack output);
// mods.alchemistry.Combiner.addRecipe(IItemStack output, IItemstack[] input);
// Dissolver.removeRecipe(output)
// Dissolver.addRecipe(output, weighted, rolls, [ [chance, item, ...], [chance2, item, ...] ])

//mods.alchemistry.Combiner.removeAllRecipes();

//Dissolver.removeAllRecipes();
// custom ore prefix for ore chunks probably better here. maybe research gregification.
// actually gregification is getting merged into ceu so just wait a bit and use ore for now.
/*Dissolver.addRecipe(<metaitem:voidrunner:shiny_stone_chunk>, false, 1, [
    [100, <gregtech:ore_tin_0>, <gregtech:ore_iron_0>],
    [50, <gregtech:ore_nickel_0>],
    // no stone dust here or else you loop that and don't need rockbreaker
    [20, <metaitem:dustGranite>],
    [20, <metaitem:dustDiorite>],
    [20, <metaitem:dustAndesite>],
    [20, <metaitem:dustMarble>],
]);

// idk about all these extra stone dusts maybe do them later with centrifuge when relevant
Dissolver.addRecipe(<metaitem:voidrunner:shiny_magma_chunk>, false, 1, [
    [100, <gregtech:ore_copper_0>, <gregtech:ore_redstone_0>],
    [50, <gregtech:ore_galena_0>],
    [50, <metaitem:dustSulfur>],
    [20, <metaitem:dustNetherrack>],
    [20, <metaitem:dustBasalt>],
    [20, <metaitem:dustGraniteRed>],
    [20, <metaitem:dustGraniteBlack>],
]);

Dissolver.addRecipe(<alchemistry:mineral_salt>, false, 1, [
    [100, <gregtech:ore_salt_0>, <gregtech:ore_rock_salt_0>],
    [50, <gregtech:ore_lepidolite_0>],
    [25, <gregtech:ore_spodumene_0>],
]);

// sapling casino
Dissolver.addRecipe(<minecraft:sapling>, true, 1, [
    [10, <minecraft:sapling:1>],
    [10, <minecraft:sapling:2>],
    [10, <minecraft:sapling:3>],
    [10, <minecraft:sapling:4>],
    [10, <minecraft:sapling:5>],
]);*/
