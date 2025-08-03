def barrelRecipes = [
    'dustGranite': 'granite_extract',
    'dustDiorite': 'diorite_extract',
    'dustAndesite': 'andesite_extract',
    'dustLimestone': 'limestone_extract',
    'dustStone': 'stone_extract',
];

for ( kv in barrelRecipes ) {
    // small barrel 400L/minute to match the old refractory burn method
    mods.pyrotech.barrel.recipeBuilder()
        .input(ore(kv.key), ore(kv.key), ore(kv.key), ore(kv.key))
        .fluidInput(fluid('water') * 1000)
        .fluidOutput(fluid(kv.value) * 1000)
        .duration(3000)
        .name(kv.value)
        .register();


    // large barrel should do 1000L/minute to match the old coke oven method
}
