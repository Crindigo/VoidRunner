import mods.pyrotech.StoneCrucible;
import mods.pyrotech.BrickCrucible;
import mods.pyrotech.Bloomery;
import mods.pyrotech.CompactingBin;
import mods.pyrotech.MechanicalCompactor;
import mods.pyrotech.Burn;
import mods.pyrotech.SoakingPot;
import mods.pyrotech.GraniteAnvil;
import mods.pyrotech.IroncladAnvil;
import mods.pyrotech.BrickKiln;
import mods.pyrotech.StoneKiln;
import mods.pyrotech.Barrel;

SoakingPot.addRecipe("string_from_durable_twine", 
    <minecraft:string>, <liquid:water> * 125, <pyrotech:material:26>, 4 * 60 * 20);

// treated wood in soaking pot too
SoakingPot.addRecipe("treated_planks",
    <gregtech:planks:1>, <liquid:creosote> * 125, <ore:plankWood>, 4 * 60 * 20);

Burn.createBuilder("water_from_mud", <minecraft:clay>, "pyrotech:mud:*")
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
// make this return sand, then just craft sand into 8 piles
GraniteAnvil.addRecipe("gravel_to_sand", <minecraft:sand>, <ore:gravel>, 4, "hammer", true);

// remove pyrotech flint dust
GraniteAnvil.removeRecipes(<pyrotech:material:31> * 3);
IroncladAnvil.removeRecipes(<pyrotech:material:31> * 3);
// replace with gregtech small flint dust
GraniteAnvil.addRecipe("small_flint_dust", <metaitem:dustSmallFlint>, <pyrotech:material:10>, 3, "hammer", true);
GraniteAnvil.addRecipe("flint_dust", <metaitem:dustFlint>, <minecraft:flint>, 4, "hammer", true);

// remove pyrotech stone rod
GraniteAnvil.removeRecipes(<pyrotech:material:27> * 4);
IroncladAnvil.removeRecipes(<pyrotech:material:27> * 4);

// add hammer anvil recipe for iron
//GraniteAnvil.removeRecipes(<pyrotech:material:19> * 9);
//IroncladAnvil.removeRecipes(<pyrotech:material:19> * 9);
IroncladAnvil.addRecipe("iron_to_wrought", <metaitem:ingotWroughtIron>, <ore:ingotIron>, 4, "hammer");

// for steam we need iron, copper, tin
// for LV we need redstone, rubber, lead, antimony

// sand pile in granite extract -> redstone. 96s per 8 redstone makes it line up nicely 
// (5/min and 250 granite/min). same consumption rate as copper, can rebalance how you want.
SoakingPot.addRecipe("sand_pile_to_redstone",
    <minecraft:redstone>, <liquid:granite_extract> * 50, <pyrotech:rock:5>, false, 96 * 20);

// sand pile in limestone ext -> sulfur
SoakingPot.addRecipe("sand_pile_to_sulfur",
    <metaitem:dustSulfur>, <liquid:limestone_extract> * 50, <pyrotech:rock:5>, true, 2 * 60 * 20);

// gravel in stone ext -> magnetite
SoakingPot.addRecipe("gravel_to_iron",
    <gregtech:ore_magnetite_0:0>, <liquid:stone_extract> * 125, <minecraft:gravel>, false, 4 * 60 * 20);

// gravel in granite ext -> copper
SoakingPot.addRecipe("gravel_to_copper",
    <gregtech:ore_chalcopyrite_0:0>, <liquid:granite_extract> * 125, <minecraft:gravel>, false, 4 * 60 * 20);

// gravel in diorite ext -> tin
SoakingPot.addRecipe("gravel_to_tin",
    <gregtech:ore_cassiterite_0:0>, <liquid:diorite_extract> * 125, <minecraft:gravel>, false, 4 * 60 * 20);

// gravel in andesite ext -> zinc
SoakingPot.addRecipe("gravel_to_zinc",
    <gregtech:ore_sphalerite_0:0>, <liquid:andesite_extract> * 125, <minecraft:gravel>, false, 4 * 60 * 20);

// gravel in limestone ext -> lead
SoakingPot.addRecipe("gravel_to_lead",
    <gregtech:ore_galena_0:0>, <liquid:limestone_extract> * 125, <minecraft:gravel>, false, 4 * 60 * 20);

// gravel in dirt ext -> dirt
SoakingPot.addRecipe("gravel_to_dirt",
    <minecraft:dirt>, <liquid:dirt_extract> * 250, <minecraft:gravel>, false, 2 * 60 * 20);

// leaves in dirt ext barrel -> nature extract
Barrel.addRecipe("nature_extract", <liquid:nature_extract> * 1000, <liquid:dirt_extract> * 1000, 
    [<ore:treeLeaves>, <ore:treeLeaves>, <ore:treeLeaves>, <ore:treeLeaves>], 5 * 60 * 20);

// dirt in nature ext -> grass
SoakingPot.addRecipe("dirt_to_grass",
    <minecraft:grass>, <liquid:nature_extract> * 125, <minecraft:dirt>, false, 5 * 60 * 20);

Bloomery.removeAllBloomeryRecipes();

// Give wrought iron directly, with a chance at gold nuggets
Bloomery.createBloomeryBuilder(
        "bloom_from_iron_ore",   // recipe name
        <metaitem:nuggetWroughtIron> * 3, // output
        <ore:oreMagnetite>)     // input
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.2)
    .setBloomYield(12, 15)
    .addFailureItem(<minecraft:gold_nugget> * 3, 1)
    .register();

// Copper
Bloomery.createBloomeryBuilder(
        "bloom_from_copper_ore",   // recipe name
        <metaitem:nuggetCopper> * 3, // output
        <ore:oreChalcopyrite>)     // input
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.2)
    .setBloomYield(12, 15)
    .addFailureItem(<metaitem:nuggetCobalt> * 3, 1)
    .register();

// Tin
Bloomery.createBloomeryBuilder(
        "bloom_from_tin_ore",   // recipe name
        <metaitem:nuggetTin> * 3, // output
        <ore:oreCassiterite>)     // input
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.2)
    .setBloomYield(12, 15)
    .addFailureItem(<metaitem:nuggetBismuth> * 3, 1)
    .register();

// Zinc
Bloomery.createBloomeryBuilder(
        "bloom_from_zinc_ore",   // recipe name
        <metaitem:nuggetZinc> * 3, // output
        <ore:oreSphalerite>)     // input
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.1)
    .setBloomYield(10, 13)
    .addFailureItem(<metaitem:nuggetGallium> * 3, 1)
    .register();

// Lead with chance of silver
Bloomery.createBloomeryBuilder(
        "bloom_from_galena_ore",   // recipe name
        <metaitem:nuggetLead> * 3, // output
        <ore:oreGalena>)     // input
    .setAnvilTiers(["granite", "ironclad"])
    .setBurnTimeTicks(14400)
    .setFailureChance(0.2)
    .setBloomYield(9, 12)
    .addFailureItem(<metaitem:nuggetSilver> * 3, 1)
    .register();

// brick kiln wrought iron to iron. furnace can do this too in groovy.
BrickKiln.addRecipe('wrought_iron_to_iron', <minecraft:iron_ingot>, <metaitem:ingotWroughtIron>, 2 * 60 * 20);

StoneKiln.removeRecipes(<pyrotech:material:22>);
BrickKiln.removeRecipes(<pyrotech:material:22>);
StoneKiln.addRecipe("quicklime", <metaitem:dustQuicklime>, <pyrotech:material:28>, 4 * 60 * 20,
    0.05, [<pyrotech:material:0>], true);

// faster refractory bricks since you need so many
StoneKiln.removeRecipes(<pyrotech:material:5>);
BrickKiln.removeRecipes(<pyrotech:material:5>);
StoneKiln.addRecipe("refractory_faster", <pyrotech:material:5>, <pyrotech:material:9>, 2 * 60 * 20,
    0.05, [<pyrotech:material:6>, <pyrotech:material:7>], true);

SoakingPot.addRecipe("slaked_lime",
    <pyrotech:material:8>, <liquid:water> * 125, <metaitem:dustQuicklime>, false, 4 * 60 * 20);
