package postInit.mod;

def removals = [
    'white', 'orange', 'magenta', 'light_blue', 'yellow', 'lime', 'pink', 'gray', 'silver', 'cyan', 'purple', 'blue',
    'brown', 'green', 'red', 'black',
];

removals.eachWithIndex { r, i  ->
    crafting.remove("elevatorid:elevator_$r");

    crafting.addShaped("elevator_$r", item("elevatorid:elevator_$r") * 2, [
        [null, ore('wireGtDoubleSteel'), null],
        [null, ore('wireGtDoubleSteel'), null],
        [item('minecraft:wool', i), metaitem('electric.motor.lv'), item('minecraft:wool', i)]
    ]);
}
