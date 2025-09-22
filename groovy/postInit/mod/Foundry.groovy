crafting.remove('foundry:alloy_mixer');
crafting.remove('foundry:metal_infuser');
crafting.remove('foundry:induction_heater');
crafting.remove('foundry:melting_crucible_advanced');

mods.jei.ingredient.yeet(item('foundry:machine', 1));
mods.jei.ingredient.yeet(item('foundry:machine', 2));
mods.jei.ingredient.yeet(item('foundry:machine', 3));
mods.jei.ingredient.yeet(item('foundry:machine', 4));
mods.jei.ingredient.yeet(item('foundry:machine', 5));
mods.jei.ingredient.yeet(item('foundry:machine', 6));
mods.jei.ingredient.yeet(item('foundry:machine', 9));
mods.jei.ingredient.yeet(item('foundry:componentblock', 1)); // advanced casing

mods.jei.ingredient.hide(item('foundry:mold', 2));
mods.jei.ingredient.hide(item('foundry:mold', 5));
mods.jei.ingredient.hide(item('foundry:mold', 6));
for (int i = 7; i <= 21; i++) {
    mods.jei.ingredient.hide(item('foundry:mold', i));
}

crafting.replaceShaped('foundry:bronze_cauldron', item('foundry:bronze_cauldron'), [
    [ore('plateBronze'), null, ore('plateBronze')],
    [ore('plateBronze'), ore('craftingToolHardHammer'), ore('plateBronze')],
    [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')],
]);

def brick = item('minecraft:brick');
def masBrick = item('pyrotech:material', 16);
def porBrick = item('ceramics:unfired_clay', 5);

crafting.replaceShaped('foundry:refractory_casing_basic', item('foundry:componentblock', 2), [
    [brick, brick, brick],
    [brick, item('ceramics:clay_hard'), brick],
    [masBrick, masBrick, masBrick]
]);
crafting.replaceShaped('foundry:refractory_casing_standard', item('foundry:componentblock', 0), [
    [ore('plateIron'), ore('plateIron'), ore('plateIron')],
    [ore('plateIron'), item('ceramics:clay_hard'), ore('plateIron')],
    [ore('plateIron'), ore('plateIron'), ore('plateIron')]
]);

crafting.replaceShaped('foundry:melting_crucible_basic', item('foundry:machine', 0), [
    [porBrick, null, porBrick],
    [porBrick, item('ceramics:porcelain_barrel'), porBrick],
    [porBrick, item('foundry:componentblock', 2), porBrick],
]);

//crafting.replaceShaped('foundry:melting_crucible_standard', item('foundry:machine', 7), [
//]);

crafting.replaceShaped('foundry:alloy_crucible', item('foundry:machine', 8), [
    [porBrick, porBrick, porBrick],
    [item('ceramics:porcelain_barrel'), item('foundry:componentblock', 2), item('ceramics:porcelain_barrel')],
    [ore('plateTin'), ore('plateTin'), ore('plateTin')],
]);

crafting.replaceShaped('foundry:mold_crafting_station', item('foundry:mold_station'), [
    [porBrick, item('minecraft:crafting_table'), porBrick],
    [porBrick, item('minecraft:stone_slab'), porBrick],
    [porBrick, item('pyrotech:masonry_brick_block'), porBrick]
]);

crafting.replaceShaped('foundry:burner_heater', item('foundry:burner_heater'), [
    [item('foundry:componentblock', 2)],
    [item('pyrotech:stone_kiln')]
]);