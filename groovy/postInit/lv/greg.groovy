package postInit.lv;

crafting.remove('minecraft:clock');





// Clock * 1
mods.gregtech.assembler.removeByInput(4, [item('minecraft:redstone'), metaitem('plateGold') * 4], null);
mods.gregtech.arc_furnace.removeByInput(30, [item('minecraft:clock')], [fluid('oxygen') * 784]);
mods.gregtech.macerator.removeByInput(2, [item('minecraft:clock')], null);

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('dustRedstone'), ore('foilGold') * 4, ore('screwIron') * 4)
    .outputs(item('minecraft:clock'))
    .duration(100)
    .EUt(4)
    .buildAndRegister();


mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(ore('gravel'))
    .fluidInputs(fluid('dirt_extract') * 250)
    .outputs(item('minecraft:dirt'))
    .duration(120)
    .EUt(16)
    .buildAndRegister();

// chem bath twine + 125 wood tar => durable twine (soaking pot is 225t each)
// chem bath durable twine + 125 water => string
mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(item('pyrotech:material', 14))
    .fluidInputs(fluid('wood_tar') * 125)
    .outputs(item('pyrotech:material', 26))
    .duration(100)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(item('pyrotech:material', 26))
    .fluidInputs(fluid('water') * 125)
    .outputs(item('minecraft:string'))
    .duration(100)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.extractor.recipeBuilder()
    .inputs(ore('dirt'))
    .outputs(item('minecraft:dirt', 1))
    .fluidOutputs(fluid('dirt_extract') * 1000)
    .duration(480)
    .EUt(10)
    .buildAndRegister();

// TODO: change to large barrel multi, 1000L/minute
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('treeLeaves'))
    .fluidInputs(fluid('dirt_extract') * 250)
    .fluidOutputs(fluid('nature_extract') * 250)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// make LV supercon in furnace to gate it before EBF. getting Mn and P takes more than just mining.
// Manganese Phosphide Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustManganesePhosphide'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null);
furnace.add(metaitem('dustManganesePhosphide'), metaitem('ingotManganesePhosphide'));

// silver and gold can be acquired by processing crushed galena and copper in a chemical bath w/ mercury (from redstone).
// thermal centrifuge also an option, no mercury but slower.