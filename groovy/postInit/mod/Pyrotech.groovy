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
