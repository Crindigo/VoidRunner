def variations = [
    "limestone": [
        item('pyrotech:limestone'),
        item('geology:rock_sedimentary', 0),
        item('geology:rock_sedimentary_cracked', 0),
        item('geology:rock_sedimentary_polished', 0),
        item('geology:rock_sedimentary_bricks', 0),
    ],
    "obsidian": [
        item('geology:rock_volcanic', 6),
        item('geology:rock_volcanic_cracked', 6),
        item('geology:rock_volcanic_polished', 6),
        item('geology:rock_volcanic_bricks', 6),
    ],
    "andesite": [
        item('geology:rock_volcanic', 2),
        item('geology:rock_volcanic_cracked', 2),
        item('geology:rock_volcanic_polished', 2),
        item('geology:rock_volcanic_bricks', 2),
    ],
    "basalt": [
        item('geology:rock_volcanic', 4),
        item('geology:rock_volcanic_cracked', 4),
        item('geology:rock_volcanic_polished', 4),
        item('geology:rock_volcanic_bricks', 4),
    ],
    "granite": [
        item('geology:rock_plutonic', 0),
        item('geology:rock_plutonic_cracked', 0),
        item('geology:rock_plutonic_polished', 0),
        item('geology:rock_plutonic_bricks', 0),
    ],
    "diorite": [
        item('geology:rock_plutonic', 2),
        item('geology:rock_plutonic_cracked', 2),
        item('geology:rock_plutonic_polished', 2),
        item('geology:rock_plutonic_bricks', 2),
    ],
    "sandstoneyellow": [
        item('geology:rock_sedimentary', 8),
        item('geology:rock_sedimentary_cracked', 8),
        item('geology:rock_sedimentary_polished', 8),
        item('geology:rock_sedimentary_bricks', 8),
    ],
    "sandstonered": [
        item('geology:rock_sedimentary', 9),
        item('geology:rock_sedimentary_cracked', 9),
        item('geology:rock_sedimentary_polished', 9),
        item('geology:rock_sedimentary_bricks', 9),
    ],
];

for ( entry in variations ) {
    for ( variant in entry.value ) {
        mods.chisel.carving.addVariation(entry.key, variant);
    }
}


