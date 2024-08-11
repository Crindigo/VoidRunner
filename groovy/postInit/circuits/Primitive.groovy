package postInit.circuits;

// capacitor: leyden jar
// transistor: vacuum tube
// resistor: carbon-core resistor
// cpu: wire-spring relay
// ram: williams tube
// storage: drum memory
// cooling: tin rotor
// casing: steel plate

def assembler = mods.gregtech.assembler;

// cork - mix sticky resin + wood dust
recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustWood'), metaitem('rubber_drop'))
    .outputs(metaitem('voidrunner:cork_crushed') * 2)
    .duration(160)
    .EUt(7)
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


assembler.recipeBuilder()
    .inputs(ore('stickCopper'), metaitem('voidrunner:cork_crushed'), item('minecraft:glass_bottle'))
    .fluidInputs(fluid('zinc') * 72)
    .outputs(metaitem('voidrunner:leyden_jar') * 2)
    .EUt(7)
    .duration(160)
    .buildAndRegister();

// vacuum tubes moved to be an mv component

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

// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100]);
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100]);
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100]);
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100]);
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100]);
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100]);

assembler.recipeBuilder()
    .inputs(ore('wireFineCopper') * 4, metaitem('voidrunner:carbon_resistor_core_bolt'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('component.resistor') * 2)
    .EUt(6)
    .duration(160)
    .buildAndRegister();

assembler.recipeBuilder()
    .inputs(ore('wireFineAnnealedCopper') * 4, metaitem('voidrunner:carbon_resistor_core_bolt'))
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('component.resistor') * 4)
    .EUt(6)
    .duration(160)
    .buildAndRegister();

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

// Circuit Board * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('foilCopper') * 4, metaitem('plateWood')], [fluid('glue') * 100])
assembler.recipeBuilder()
    .inputs(ore('foilCopper') * 4, ore('plateWood'))
    .fluidInputs(fluid('glue') * 125)
    .outputs(metaitem('circuit_board.basic'))
    .EUt(7)
    .duration(200)
    .buildAndRegister();

// relay - fine copper wire, fine silver wire, magnetic iron rod
crafting.shapedBuilder()
    .name('relay')
    .output(metaitem('voidrunner:relay'))
    .shape('p  ', 'wb ', 'wr ')
    .key('p', ore('plateIron'))
    .key('w', ore('wireFineCopper'))
    .key('b', ore('boltIron'))
    .key('r', ore('stickIronMagnetic'))
    .register();

assembler.recipeBuilder()
    .inputs(ore('plateIron'), ore('wireFineCopper') * 2, ore('boltIron'), ore('stickIronMagnetic'))
    .outputs(metaitem('voidrunner:relay'))
    .EUt(7)
    .duration(160)
    .buildAndRegister();

assembler.recipeBuilder()
    .inputs(ore('plateIron'), ore('wireFineAnnealedCopper') * 2, ore('boltIron'), ore('stickIronMagnetic'))
    .outputs(metaitem('voidrunner:relay') * 2)
    .EUt(7)
    .duration(160)
    .buildAndRegister();

// williams tube
crafting.shapedBuilder()
    .name('williams_tube')
    .output(metaitem('voidrunner:williams_tube'))
    .shape(' f ', 'ptp', 'wew')
    .key('f', ore('foilIron'))
    .key('p', ore('dustSmallSphalerite'))
    .key('t', metaitem('component.glass.tube'))
    .key('e', ore('stickCopper'))
    .key('w', ore('wireGtSingleTin'))
    .register();

assembler.recipeBuilder()
    .inputs(ore('dustSmallSphalerite') * 2, metaitem('component.glass.tube'), ore('stickCopper'), ore('wireGtSingleTin') * 2)
    .fluidInputs(fluid('iron') * 36)
    .outputs(metaitem('voidrunner:williams_tube') * 2)
    .EUt(7)
    .duration(200)
    .buildAndRegister();

// Final circuit
crafting.remove('gregtech:electronic_circuit_lv');
crafting.shapedBuilder()
    .name('circuit_primitive')
    //.output(metaitem('voidrunner:circuit_primitive'))
    .output(metaitem('circuit.electronic'))
    .shape('wjw', 'rbr', 'RcW')
    .key('w', ore('wireGtSingleCopper'))
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
// don't know about that either, since circuit progression here doesn't require previous tiers, so less reason to make old ones.
// maybe due to "less clumsy crafting" we can make 2 circuits with 2 boards but the same # of components.
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('voidrunner:leyden_jar'), 
            metaitem('voidrunner:relay'), metaitem('voidrunner:williams_tube'), ore('wireGtSingleCopper') * 2)
    // fluids auto added
    .outputs(metaitem('circuit.electronic') * 2)
    .duration(200)
    .EUt(30)
    .buildAndRegister();

// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('soldering_alloy') * 72])
// Electronic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('wireGtSingleRedAlloy') * 2, metaitem('circuit.vacuum_tube') * 2], [fluid('tin') * 144])



//
// PRIMITIVE COMPUTER
//


// casing = steel plate
// storage = drum memory
// cooling = just bronze rotor

/*crafting.shapedBuilder()
    .name('drum_memory')
    .output(metaitem('voidrunner:drum_memory'))
    .shape(' p ', 'rp ', 'mp ')
    .key('p', ore('plateIron'))
    .key('r', ore('stickIronMagnetic'))
    .key('m', metaitem('electric.motor.lv'))
    .register();

assembler.recipeBuilder()
    .inputs(ore('plateIron') * 3, ore('stickIronMagnetic'), metaitem('electric.motor.lv'))
    .outputs(metaitem('voidrunner:drum_memory'))
    .duration(200)
    .EUt(7)
    .buildAndRegister();*/

// crafting recipe
// PRP
// WCW
// PSP
// 4 plate, rotor, 2 wire, circuit, storage

/*crafting.shapedBuilder()
    .name('computer_primitive')
    .output(metaitem('voidrunner:computer_primitive'))
    .shape('prp', 'wcw', 'psp')
    .key('p', ore('plateSteel'))
    .key('r', ore('rotorTin'))
    .key('w', ore('wireGtSingleCopper'))
    .key('c', metaitem('voidrunner:circuit_primitive'))
    .key('s', metaitem('voidrunner:drum_memory'))
    .register();

// assembler recipe (not circuit assembler)
assembler.recipeBuilder()
    .inputs(ore('plateSteel') * 2, ore('rotorTin'), ore('wireGtSingleCopper') * 2, 
        metaitem('voidrunner:circuit_primitive'), metaitem('voidrunner:drum_memory'))
    .outputs(metaitem('voidrunner:computer_primitive'))
    .EUt(16)
    .duration(200)
    .buildAndRegister();*/

// remove GT circuits
//mods.jei.ingredient.yeet(metaitem('circuit.electronic'));
//mods.jei.ingredient.yeet(metaitem('circuit.basic_integrated'));
//mods.jei.ingredient.yeet(metaitem('circuit.microprocessor'));