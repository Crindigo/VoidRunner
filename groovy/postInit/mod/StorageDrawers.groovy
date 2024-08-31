// upgrades:
// 2x: masonry brick
// 4x: iron plate
// 8x: electrum plate
// 16x: aluminium plate
// 32x: stainless

def materials = [
    item('pyrotech:material', 16),
    ore('plateIron'),
    ore('plateElectrum'),
    ore('plateAluminium'),
    ore('plateStainlessSteel'),
];

def template = item('storagedrawers:upgrade_template');
def stick = ore('stickWood');

for ( index in 0..4 ) {
    def mat = materials[index];
    crafting.replaceShaped(item('storagedrawers:upgrade_storage', index), [
        [stick, stick, stick],
        [mat, template, mat],
        [stick, stick, stick],
    ]);
}

crafting.replaceShapeless(item('storagedrawers:upgrade_void'), [template, item('trashcans:item_trash_can')]);