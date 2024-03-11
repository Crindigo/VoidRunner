crafting.remove('minecraft:clock');

// 2 copper wire and zinc foil
crafting.remove('gregtech:vacuum_tube');
crafting.shapedBuilder()
    .name('vacuum_tube')
    .output(metaitem('circuit.vacuum_tube'))
    .shape(' g ', ' f ', 'wrw')
    .key('f', ore('foilZinc'))
    .key('g', metaitem('component.glass.tube'))
    .key('w', ore('wireGtSingleCopper'))
    .key('r', ore('ringIron'))
    .register();

// Vacuum Tube * 2
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Vacuum Tube * 3
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 4
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleAnnealedCopper') * 2], [fluid('red_alloy') * 18])

// no iron ring for assembler
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('component.glass.tube'), ore('foilZinc'), ore('wireGtSingleCopper') * 2)
    .outputs(metaitem('circuit.vacuum_tube') * 2)
    .duration(160)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('component.glass.tube'), ore('foilZinc'), ore('wireGtSingleAnnealedCopper') * 2)
    .outputs(metaitem('circuit.vacuum_tube') * 3)
    .duration(160)
    .EUt(7)
    .buildAndRegister();

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

crafting.remove('randomthings:timeinabottle');
mods.gregtech.canner.recipeBuilder()
    .inputs(item('minecraft:clock'), item('minecraft:glass_bottle'))
    .outputs(item('randomthings:timeinabottle').withNbt(["timeData": ["storedTime": 0]]))
    .duration(6000)
    .EUt(4)
    .buildAndRegister();


mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(ore('gravel'))
    .fluidInputs(fluid('dirt_extract') * 125)
    .outputs(item('minecraft:dirt'))
    .duration(200)
    .EUt(4)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('treeLeaves'))
    .fluidInputs(fluid('dirt_extract') * 250)
    .fluidOutputs(fluid('nature_extract') * 250)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// silver and gold can be acquired by processing crushed galena and copper in a chemical bath w/ mercury (from redstone).
// thermal centrifuge also an option, no mercury but slower.