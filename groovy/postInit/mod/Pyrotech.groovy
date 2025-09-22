def barrelRecipes = [
    'dustGranite': 'granite_extract',
    'dustDiorite': 'diorite_extract',
    'dustAndesite': 'andesite_extract',
    'dustLimestone': 'limestone_extract',
    'dustStone': 'stone_extract',
];

for ( kv in barrelRecipes ) {
    // 500L/minute. old refractory burn was 800L/minute if you built 2x2x2 but this is smaller.
    mods.pyrotech.barrel.recipeBuilder()
        .input(ore(kv.key), ore(kv.key), ore(kv.key), ore(kv.key))
        .fluidInput(fluid('water') * 1000)
        .fluidOutput(fluid(kv.value) * 1000)
        .duration(2400)
        .name(kv.value)
        .register();


    // large barrel should do 1000L/minute to match the old coke oven method
}

mods.pyrotech.compacting_bin.remove("pyrotech:bone_block");
mods.pyrotech.compacting_bin.remove("pyrotech:compacting_bin/bone_block");

// using Foundry to melt items
crafting.remove('pyrotech:tech/machine/stone_crucible');
crafting.remove('pyrotech:tech/machine/brick_crucible');

// pyrotech brick machines use iron plates, except for kiln which uses wrought iron.
crafting.remove('pyrotech:tech/machine/brick_sawmill');
crafting.shapedBuilder()
    .name('brick_sawmill')
    .output(item('pyrotech:brick_sawmill'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateWroughtIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_sawmill'))
    .register();

crafting.remove('pyrotech:tech/machine/brick_oven');
crafting.shapedBuilder()
    .name('brick_oven')
    .output(item('pyrotech:brick_oven'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateWroughtIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_oven'))
    .register();

crafting.remove('pyrotech:tech/machine/brick_kiln');
crafting.shapedBuilder()
    .name('brick_kiln')
    .output(item('pyrotech:brick_kiln'))
    .shape('PBP',
           'BMB',
           'PBP')
    .key('P', ore('plateWroughtIron'))
    .key('B', item('pyrotech:refractory_brick_block'))
    .key('M', item('pyrotech:stone_kiln'))
    .register();