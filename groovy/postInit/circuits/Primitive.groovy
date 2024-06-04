package circuits;

// capacitor: leyden jar
// transistor: vacuum tube
// resistor: carbon-core resistor
// cpu: wire-spring relay
// ram: williams tube
// storage: drum memory
// cooling: tin rotor
// casing: steel plate

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

// carbon-clay compound
crafting.addShapeless("carbon_clay_compound1", metaitem("voidrunner:carbon_clay_compound_dust"),
    [ore('dustCoal'), ore('dustClay')]);
crafting.addShapeless("carbon_clay_compound2", metaitem("voidrunner:carbon_clay_compound_dust"),
    [ore('dustCharcoal'), ore('dustClay')]);
crafting.addShapeless("carbon_clay_compound3", metaitem("voidrunner:carbon_clay_compound_dust") * 2,
    [ore('dustCoke'), ore('dustClay')]);
crafting.addShapeless("carbon_clay_compound4", metaitem("voidrunner:carbon_clay_compound_dust") * 2,
    [ore('dustCarbon'), ore('dustClay')]);

// add mixer recipes for carbon-clay compound too
mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCoal'), ore('dustClay'))
    .outputs(metaitem('voidrunner:carbon_clay_compound_dust') * 2)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCharcoal'), ore('dustClay'))
    .outputs(metaitem('voidrunner:carbon_clay_compound_dust') * 2)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCoke'), ore('dustClay'))
    .outputs(metaitem('voidrunner:carbon_clay_compound_dust') * 4)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

mods.gregtech.mixer.recipeBuilder()
    .inputs(ore('dustCarbon'), ore('dustClay'))
    .outputs(metaitem('voidrunner:carbon_clay_compound_dust') * 4)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

furnace.add(metaitem('voidrunner:carbon_clay_compound_dust'), metaitem('voidrunner:carbon_resistor_core_bolt'));

// resistor - 2 wires, 2 paper, core in middle. crafts 2.
crafting.removeByOutput(metaitem('component.resistor'));
crafting.shapedBuilder()
    .name('resistor_primitive')
    .output(metaitem('component.resistor') * 2)
    .shape(' w ', 'pcp', ' w ')
    .key('w', ore('wireGtSingleCopper') | ore('wireGtSingleTin'))
    .key('p', ore('paper'))
    .key('c', metaitem('voidrunner:carbon_resistor_core_bolt'))
    .register();

// made in soaking pot or chem bath
crafting.remove('gregtech:coated_board');
crafting.remove('gregtech:coated_board_1x');

// SoakingPot.addRecipe("basic_circuit_board", <metaitem:board.coated>, <liquid:glue> * 250, <ore:plateWood>, false, 1200);
mods.gregtech.chemical_bath.recipeBuilder()
    .inputs(ore('plateWood'))
    .fluidInputs(fluid('glue') * 250)
    .outputs(metaitem('board.coated'))
    .duration(60)
    .EUt(16)
    .buildAndRegister();

// make basic board only need 4 wire
crafting.remove('gregtech:basic_circuit_board');
crafting.shapedBuilder()
    .name('basic_board')
    .output(metaitem('circuit_board.basic'))
    .shape(' w ', 'wbw', ' w ')
    .key('w', ore('wireGtSingleCopper'))
    .key('b', metaitem('board.coated'))
    .register();

// relay - fine copper wire, fine silver wire, magnetic iron rod
crafting.shapedBuilder()
    .name('relay')
    .output(metaitem('voidrunner:relay') * 2)
    .shape('p  ', 'wb ', 'wr ')
    .key('p', ore('plateIron'))
    .key('w', ore('wireFineCopper'))
    .key('b', ore('boltIron'))
    .key('r', ore('stickIronMagnetic'))
    .register();

// williams tube
crafting.shapedBuilder()
    .name('williams_tube')
    .output(metaitem('voidrunner:williams_tube'))
    .shape(' f ', 'ptp', ' e ')
    .key('f', ore('foilIron'))
    .key('p', ore('dustSmallSphalerite'))
    .key('t', metaitem('circuit.vacuum_tube'))
    .key('e', ore('stickCopper'))
    .register();

// Final circuit - leyden jar(s), vacuum tube(s), resistor(s), on a board?
crafting.remove('gregtech:electronic_circuit_lv');
crafting.shapedBuilder()
    .name('circuit_primitive')
    .output(metaitem('voidrunner:circuit_primitive'))
    .shape('wjw', 'rbr', 'RcW')
    .key('w', ore('wireFineCopper'))
    .key('j', metaitem('voidrunner:leyden_jar'))
    .key('r', metaitem('component.resistor'))
    .key('R', metaitem('voidrunner:relay'))
    .key('b', metaitem('circuit_board.basic'))
    .key('W', metaitem('voidrunner:williams_tube'))
    .key('c', ore('toolWireCutter'))
    .register();

// for cpu/transistor rework - maybe drop vac tube, add 2nd resistor here.
// williams tube recipe change to not include vacuum tube.
// Retro gets advanced vac tube with purified nickel tubing (?) (change vac tube recipe).

// assembler recipe
// wondering if we don't give x2 by default, but instead upgrading components w/ same board gives 2x or more.
// like tier 2 cpu+ram gives x2, maybe tier 2 all gives x3 or x4, perhaps requiring next power tier.
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('voidrunner:leyden_jar'), 
            metaitem('voidrunner:relay'), metaitem('voidrunner:williams_tube'), ore('wireFineCopper') * 2)
    // fluids auto added
    .outputs(metaitem('voidrunner:circuit_primitive') * 2)
    .duration(200)
    .EUt(30)
    .buildAndRegister();


//
// PRIMITIVE COMPUTER
//


// casing = steel plate
// storage = drum memory
// cooling = just bronze rotor

crafting.shapedBuilder()
    .name('drum_memory')
    .output(metaitem('voidrunner:drum_memory'))
    .shape(' p ', 'rp ', 'mp ')
    .key('p', ore('plateIron'))
    .key('r', ore('stickIronMagnetic'))
    .key('m', metaitem('electric.motor.lv'))
    .register();


// crafting recipe
// PRP
// WCW
// PSP
// 4 plate, rotor, 2 wire, circuit, storage

crafting.shapedBuilder()
    .name('computer_primitive')
    .output(metaitem('voidrunner:computer_primitive'))
    .shape('prp', 'wcw', 'psp')
    .key('p', ore('plateSteel'))
    .key('r', ore('rotorTin'))
    .key('w', ore('wireGtSingleCopper'))
    .key('c', metaitem('voidrunner:circuit_primitive'))
    .key('s', metaitem('voidrunner:drum_memory'))
    .register();

// assembler recipe



// remove GT circuits
mods.jei.ingredient.yeet(metaitem('circuit.electronic'));
mods.jei.ingredient.yeet(metaitem('circuit.basic_integrated'));
mods.jei.ingredient.yeet(metaitem('circuit.microprocessor'));