//import mods.advancedmortars.Mortar;
//import mods.alchemistry.Dissolver;
import mods.pyrotech.StoneCrucible;
import mods.pyrotech.BrickCrucible;
import mods.pyrotech.Bloomery;
import mods.pyrotech.CompactingBin;
import mods.pyrotech.MechanicalCompactor;
import mods.pyrotech.Burn;
import mods.pyrotech.SoakingPot;
import mods.pyrotech.GraniteAnvil;
import mods.pyrotech.IroncladAnvil;
import mods.appliedenergistics2.Grinder;

val oreDustAsh = <ore:dustAsh>;
oreDustAsh.add(<pyrotech:material:0>);

// clay dust to clay in water
//mods.inworldcrafting.FluidToItem.transform(<minecraft:clay_ball>, <liquid:water>, [<ore:dustClay>], false);

// stone dust in water makes stone solution
//mods.inworldcrafting.FluidToFluid.transform(<liquid:stone_solution>, <liquid:water>, [<ore:dustStone>]);

//mods.skyresources.waterextractor.extract.removeRecipe(20, null, <ore:treeLeaves>);
//mods.skyresources.waterextractor.extract.addRecipe(250, null, <pyrotech:mud>);

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

//StoneCrucible.removeAllRecipes();
//BrickCrucible.removeAllRecipes();

SoakingPot.addRecipe("string_from_durable_twine", 
    <minecraft:string>, <liquid:water> * 125, <pyrotech:material:26>, 4 * 60 * 20);

// treated wood in soaking pot too
SoakingPot.addRecipe("treated_planks",
    <gregtech:planks:1>, <liquid:creosote> * 125, <ore:plankWood>, 4 * 60 * 20);

Burn.createBuilder("water_from_mud", <minecraft:dirt>, "pyrotech:mud:*")
    .setBurnStages(1)
    .setTotalBurnTimeTicks(2 * 60 * 20)
    .setFluidProduced(<liquid:water> * 250)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:4>)
    .addFailureItem(<pyrotech:rock:4> * 2)
    .addFailureItem(<pyrotech:rock:4> * 4)
    .setRequiresRefractoryBlocks(false)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("extract_from_stone", <pyrotech:rock:0>, "minecraft:stone:0")
    .setBurnStages(5)
    .setTotalBurnTimeTicks(5 * 60 * 20)
    .setFluidProduced(<liquid:stone_extract> * 50)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:0>)
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("extract_from_granite", <pyrotech:rock:1>, "minecraft:stone:1")
    .setBurnStages(5)
    .setTotalBurnTimeTicks(5 * 60 * 20)
    .setFluidProduced(<liquid:granite_extract> * 50)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:1>)
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("extract_from_diorite", <pyrotech:rock:2>, "minecraft:stone:3")
    .setBurnStages(5)
    .setTotalBurnTimeTicks(5 * 60 * 20)
    .setFluidProduced(<liquid:diorite_extract> * 50)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:2>)
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("extract_from_andesite", <pyrotech:rock:3>, "minecraft:stone:5")
    .setBurnStages(5)
    .setTotalBurnTimeTicks(5 * 60 * 20)
    .setFluidProduced(<liquid:andesite_extract> * 50)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:3>)
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("extract_from_limestone", <pyrotech:rock:8>, "pyrotech:limestone")
    .setBurnStages(5)
    .setTotalBurnTimeTicks(5 * 60 * 20)
    .setFluidProduced(<liquid:limestone_extract> * 50)
    .setFailureChance(0.25)
    .addFailureItem(<pyrotech:rock:8>)
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(false)
    .register();

Burn.createBuilder("charcoal_to_coal", <minecraft:coal:0>, "gregtech:meta_block_compressed_16:10")
    .setBurnStages(10)
    .setTotalBurnTimeTicks(8 * 60 * 20)
    .setFluidProduced(<liquid:creosote> * 50)
    .setFailureChance(0.15)
    .addFailureItem(<pyrotech:material:15> * 4)
    .addFailureItem(<pyrotech:material:15> * 6)
    .addFailureItem(<pyrotech:material:15> * 8) // charcoal flakes
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(true)
    .register();

// change coke recipe in burn to make creosote
Burn.removeRecipes(<pyrotech:material:1>);
Burn.createBuilder("coal_to_coke", <metaitem:gemCoke>, "minecraft:coal_block")
    .setBurnStages(10)
    .setTotalBurnTimeTicks(8 * 60 * 20)
    .setFluidProduced(<liquid:creosote> * 50)
    .setFailureChance(0.15)
    .addFailureItem(<pyrotech:material:21> * 4)
    .addFailureItem(<pyrotech:material:21> * 6)
    .addFailureItem(<pyrotech:material:21> * 8) // coal flakes
    .setRequiresRefractoryBlocks(true)
    .setFluidLevelAffectsFailureChance(true)
    .register();

// you can do 8 operations at once so this is 2 buckets per minute
// pyrotech already has a lava one apparently
//StoneCrucible.addRecipe("water_from_leaves", <liquid:water> * 250, <ore:treeLeaves>, 1200, true);
//BrickCrucible.addRecipe("lava_from_cobble", <liquid:lava> * 250, <ore:cobblestone>, 1200);

CompactingBin.removeRecipes(<pyrotech:coal_coke_block>);
MechanicalCompactor.removeRecipes(<pyrotech:coal_coke_block>);
CompactingBin.addRecipe("gt_coke_block", <metaitem:blockCoke>, <ore:gemCoke>, 9, true);

CompactingBin.removeRecipes(<pyrotech:charcoal_block>);
MechanicalCompactor.removeRecipes(<pyrotech:charcoal_block>);
CompactingBin.addRecipe("gt_charcoal_block", <metaitem:blockCharcoal>, <minecraft:coal:1>, 9, true);
CompactingBin.addRecipe("gt_charcoal_block_flakes", <metaitem:blockCharcoal>, <pyrotech:material:15>, 72, true);

// change coke recipe in anvil
GraniteAnvil.removeRecipes(<pyrotech:material:1> * 9);
IroncladAnvil.removeRecipes(<pyrotech:material:1> * 9);
GraniteAnvil.addRecipe("coke_split", <metaitem:gemCoke> * 9, <ore:blockFuelCoke>, 8, "pickaxe", true);

// ash in granite extract -> redstone?
SoakingPot.addRecipe("ash_to_redstone",
    <minecraft:redstone>, <liquid:granite_extract> * 50, <ore:dustTinyAsh>, true, 2 * 60 * 20);

// Give wrought iron directly
Bloomery.removeBloomeryRecipes(<minecraft:iron_nugget>);
Bloomery.createBloomeryBuilder(
        "bloom_from_iron_ore",   // recipe name
        <metaitem:nuggetWroughtIron>, // output
        <ore:oreIron>     // input
    )
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.0)
    .setBloomYield(9, 12)
    .register();

Bloomery.removeBloomeryRecipes(<metaitem:nuggetCopper>);
Bloomery.createBloomeryBuilder(
        "bloom_from_copper_ore",   // recipe name
        <metaitem:nuggetCopper>, // output
        <ore:oreCopper>     // input
    )
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.0)
    .setBloomYield(9, 12)
    .register();

mods.chisel.Carving.addVariation("limestone", <pyrotech:limestone>);

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
