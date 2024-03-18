// cork - alloy smelt sticky resin + wood dust
mods.gregtech.alloy_smelter.recipeBuilder()
    .inputs(ore('dustWood'), metaitem('rubber_drop'))
    .outputs(metaitem('voidrunner:cork_crushed') * 2)
    .duration(80)
    .EUt(16)
    .buildAndRegister();

// leyden jar - glass bottle + 2 zn foil + 1 cu rod + 1 cork
crafting.shapedBuilder()
    .name('leyden_jar')
    .output(metaitem('voidrunner:leyden_jar'))
    .shape(' r ', ' c ', 'zbz')
    .key('r', ore('stickCopper'))
    .key('c', metaitem('voidrunner:cork_crushed'))
    .key('z', ore('foilZinc'))
    .key('b', item('minecraft:glass_bottle'))
    .register();


// vacuum tube
// 2 copper wire and zinc foil

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


// Final circuit - leyden jar(s), vacuum tube(s), resistor(s), on a board?