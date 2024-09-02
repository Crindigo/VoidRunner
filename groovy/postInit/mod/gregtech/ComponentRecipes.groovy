package postInit.mod.gregtech;
import gregtech.api.GTValues;

// Make components like robot arms, fluid regulators, field generators, sensors, emitters, programmed circuit,
// smart item filter use the chipXX instead of circuitXX

//def recipeNames = ['gregtech:robot_arm_lv', 'gregtech:field_generator_lv', 'sensor_lv', 'emitter_lv', 
//    'integrated_circuit', 'smart_item_filter_olivine', 'smart_item_filter_emerald'];

//def arm = metaitem('robot.arm.lv');

def robotArmWires = [
    metaitem('cableGtSingleTin'),
    metaitem('cableGtSingleCopper'),
    metaitem('cableGtSingleGold'),
    metaitem('cableGtSingleAluminium'),
    metaitem('cableGtSingleTungsten'),
];
def robotArmRod = [
    metaitem('stickSteel'),
    metaitem('stickAluminium'),
    metaitem('stickStainlessSteel'),
    metaitem('stickTitanium'),
    metaitem('stickTungstenSteel'),
];

def fieldGenWires = [
    metaitem('wireGtDoubleManganesePhosphide'),
];
def fieldGenPearl = [

];
def emitterRod = [

];


// circuit.electronic, circuit.good_electronic
def assemblerCircuits = ['electronic', 'good_electronic', 'advanced_integrated', 'workstation', 'mainframe'];

// electric.motor.lv
// electric.piston.lv

def tiers = ['lv', 'mv', 'hv', 'ev'];

// todo change ULV robot arm to use metaitem('voidrunner:relay')
crafting.replaceShaped("ulv_covers:robot_arm_ulv_easy", metaitem('ulv_covers:robot.arm.ulv'), [
    [metaitem('ulv_covers:electric.motor.ulv'), ore('stickBronze')],
    [metaitem('ulv_covers:electric.piston.ulv'), metaitem('voidrunner:relay')]
]);

int i = 0;
for ( tier in tiers ) {
    // Robot Arms

    /*crafting.replaceShaped("gregtech:robot_arm_$tier", metaitem("robot.arm.$tier"), [
        [robotArmWires[i], robotArmWires[i], robotArmWires[i]],
        [metaitem("electric.motor.$tier"), robotArmRod[i], metaitem("electric.motor.$tier")],
        [metaitem("electric.piston.$tier"), ore("chip.$tier"), robotArmRod[i]]
    ]);

    mods.gregtech.assembler.removeByInput(30, [
        robotArmWires[i] * 3, robotArmRod[i] * 2, metaitem("electric.motor.$tier") * 2, metaitem("electric.piston.$tier"), 
        metaitem("circuit." + assemblerCircuits[i])
    ], null);

    mods.gregtech.assembler.recipeBuilder()
        .inputs(robotArmWires[i] * 3, robotArmRod[i] * 2, metaitem("electric.motor.$tier") * 2, 
            metaitem("electric.piston.$tier"), ore("chip.$tier"))
        .outputs(metaitem("robot.arm.$tier"))
        .duration(100)
        .EUt(30)
        .buildAndRegister();*/

    // Fluid regulators

    /*mods.gregtech.assembler.removeByInput(GTValues.VA[i + 1], [
        metaitem("electric.pump.$tier"), metaitem('circuit.' + assemblerCircuits[i]) * 2, 
        metaitem('circuit.integrated').withNbt(["Configuration": 1])
    ], null)

    mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem("electric.pump.$tier"), ore("chip.$tier") * 2)
        .circuitMeta(1)
        .outputs(metaitem("fluid.regulator.$tier"))
        .EUt(GTValues.VA[i + 1])
        .duration(400 - (i * 50)) // 400 ticks, 350 ticks, etc.
        .buildAndRegister();*/
    
    i++;
}



/*crafting.streamRecipes().forEach { recipe ->
    if ( recipe.output.item.registryName.toString() == arm.item.registryName.toString() && recipe.output.item.metadata == arm.metadata ) {
        log.info(recipe)
    }
}*/