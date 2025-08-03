def cobblestones = [
    [item('pyrotech:cobblestone', 2), metaitem('dustGranite'), 'granite_dust'],
    [item('pyrotech:cobblestone', 0), metaitem('dustAndesite'), 'andesite_dust'],
    [item('pyrotech:cobblestone', 1), metaitem('dustDiorite'), 'diorite_dust'],
    [item('pyrotech:cobblestone', 3), item('pyrotech:material', 28), 'limestone_dust'],
    [item('minecraft:cobblestone'), metaitem('dustStone'), 'stone_dust'],
    [item('gregtech:stone_cobble', 2), metaitem('dustMarble'), 'marble_dust'],
    [item('gregtech:stone_cobble', 3), metaitem('dustBasalt'), 'basalt_dust'],
    [item('gregtech:stone_cobble', 1), metaitem('dustGraniteRed'), 'red_granite_dust'],
    [item('gregtech:stone_cobble', 0), metaitem('dustGraniteBlack'), 'black_granite_dust'],
];

mods.pyrotech.anvil.remove('pyrotech:cobbled_granite_to_rocks');
mods.pyrotech.anvil.remove('pyrotech:cobbled_andesite_to_rocks');
mods.pyrotech.anvil.remove('pyrotech:cobbled_diorite_to_rocks');
mods.pyrotech.anvil.remove('pyrotech:cobbled_limestone_to_rocks');
mods.pyrotech.anvil.remove('pyrotech:cobblestone_to_rocks');
mods.pyrotech.anvil.remove('pyrotech:limestone_rocks_to_crushed_limestone');

// replace this with standardized recipe
mods.gregtech.macerator.removeByInput(2, [item('minecraft:cobblestone')], null)

for ( r in cobblestones ) {
    mods.pyrotech.anvil.recipeBuilder()
        .input(r[0]).output(r[1])
        .hits(2).typeHammer().tierGranite()
        .name(r[2])
        .register();

    mods.gregtech.macerator.recipeBuilder()
        .inputs(r[0])
        .outputs(r[1])
        .EUt(2)
        .duration(100)
        .buildAndRegister();
}

// Granite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:stone', 1)], null)
// Diorite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:stone', 3)], null)
// Andesite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:stone', 5)], null)
// Marble Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('chisel:marble')], null)
// Marble Dust * 9
mods.gregtech.macerator.removeByInput(2, [item('astralsorcery:blockmarble')], null)
// Basalt Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('chisel:basalt')], null)
// Endstone Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:end_stone:*')], null)
// Red Granite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('gregtech:stone_smooth', 1)], null)
// Black Granite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('gregtech:stone_smooth')], null)
// Obsidian Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:obsidian')], null)


def stones = [
    [item('minecraft:stone', 0), metaitem('dustStone')],
    [ore('stoneGranite'), metaitem('dustGranite')],
    [ore('stoneDiorite'), metaitem('dustDiorite')],
    [ore('stoneAndesite'), metaitem('dustAndesite')],
    [ore('stoneLimestone'), item('pyrotech:material', 28)],
    [ore('stoneMarble'), metaitem('dustMarble')],
    [ore('stoneBasalt'), metaitem('dustBasalt')],
    [ore('endstone'), metaitem('dustEndstone')],
    [ore('stoneGraniteRed'), metaitem('dustGraniteRed')],
    [ore('stoneGraniteBlack'), metaitem('dustGraniteBlack')],
    [item('minecraft:obsidian'), metaitem('dustObsidian')],
];

for ( r in stones ) {
    mods.gregtech.macerator.recipeBuilder()
        .inputs(r[0])
        .outputs(r[1])
        .EUt(2)
        .duration(100)
        .buildAndRegister();
}

// Forge hammer cobbled variants of granite, diorite, andesite, and limestone
def stoneToCobble = [:];

stoneToCobble[ore('stoneAndesite')]  = item('pyrotech:cobblestone', 0);
stoneToCobble[ore('stoneDiorite')]   = item('pyrotech:cobblestone', 1);
stoneToCobble[ore('stoneGranite')]   = item('pyrotech:cobblestone', 2);
stoneToCobble[ore('stoneLimestone')] = item('pyrotech:cobblestone', 3);

def stoneToPolished = [:];
def stoneToBricks = [:];
def polishedToBricks = [:];
def cobbleToBoulder = [:];

for ( i in 0..8 ) {
    stoneToCobble[item('geology:rock_volcanic', i)] = item('geology:rock_volcanic_cracked', i);
    stoneToPolished[item('geology:rock_volcanic', i)] = item('geology:rock_volcanic_polished', i);
    stoneToBricks[item('geology:rock_volcanic', i)] = item('geology:rock_volcanic_bricks', i);
    polishedToBricks[item('geology:rock_volcanic_polished', i)] = item('geology:rock_volcanic_bricks', i);
    cobbleToBoulder[item('geology:rock_volcanic_cracked', i)] = item('geology:rock_volcanic_boulder', i);
}
for ( i in 0..10 ) {
    stoneToCobble[item('geology:rock_plutonic', i)] = item('geology:rock_plutonic_cracked', i);
    stoneToPolished[item('geology:rock_plutonic', i)] = item('geology:rock_plutonic_polished', i);
    stoneToBricks[item('geology:rock_plutonic', i)] = item('geology:rock_plutonic_bricks', i);
    polishedToBricks[item('geology:rock_plutonic_polished', i)] = item('geology:rock_plutonic_bricks', i);
    cobbleToBoulder[item('geology:rock_plutonic_cracked', i)] = item('geology:rock_plutonic_boulder', i);
}
for ( i in 0..11 ) {
    stoneToCobble[item('geology:rock_sedimentary', i)] = item('geology:rock_sedimentary_cracked', i);
    stoneToPolished[item('geology:rock_sedimentary', i)] = item('geology:rock_sedimentary_polished', i);
    stoneToBricks[item('geology:rock_sedimentary', i)] = item('geology:rock_sedimentary_bricks', i);
    polishedToBricks[item('geology:rock_sedimentary_polished', i)] = item('geology:rock_sedimentary_bricks', i);
    cobbleToBoulder[item('geology:rock_sedimentary_cracked', i)] = item('geology:rock_sedimentary_boulder', i);
}

int count = 0;
for ( kv in stoneToCobble ) {
    mods.gregtech.forge_hammer.recipeBuilder()
        .inputs(kv.key)
        .outputs(kv.value)
        .EUt(16)
        .duration(10)
        .buildAndRegister();

    // smelt and extrude
    if ( count > 3 ) {
        furnace.add(kv.value, kv.key);
        mods.gregtech.extruder.recipeBuilder()
            .inputs(kv.value)
            .notConsumable(metaitem('shape.extruder.block'))
            .outputs(kv.key)
            .EUt(8)
            .duration(24)
            .buildAndRegister();
    } else {
        mods.gregtech.extruder.recipeBuilder()
            .inputs(kv.value)
            .notConsumable(metaitem('shape.extruder.block'))
            .outputs(count == 3 ? item('pyrotech:limestone') : kv.key.getAt(0))
            .EUt(8)
            .duration(24)
            .buildAndRegister();
    }

    count++;
}

for ( kv in stoneToPolished ) {
    furnace.add(kv.key, kv.value);
    mods.gregtech.extruder.recipeBuilder()
        .inputs(kv.key)
        .notConsumable(metaitem('shape.extruder.block'))
        .outputs(kv.value)
        .EUt(8)
        .duration(24)
        .buildAndRegister();
}

for ( kv in stoneToBricks ) {
    mods.gregtech.extruder.recipeBuilder()
        .inputs(kv.key)
        .notConsumable(metaitem('shape.extruder.ingot'))
        .outputs(kv.value)
        .EUt(8)
        .duration(24)
        .buildAndRegister();
}

for ( kv in polishedToBricks ) {
    mods.gregtech.laser_engraver.recipeBuilder()
        .inputs(kv.key)
        .notConsumable(ore('craftingLensLightBlue'))
        .outputs(kv.value)
        .EUt(16)
        .duration(50)
        .buildAndRegister();
}

for ( kv in cobbleToBoulder ) {
    mods.gregtech.forge_hammer.recipeBuilder()
        .inputs(kv.key)
        .outputs(kv.value)
        .EUt(16)
        .duration(10)
        .buildAndRegister();
}

// Geology mod stone dusts