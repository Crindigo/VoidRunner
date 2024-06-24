package mod;

// ender bridge, ender anchor


// platforms. replace ender pearl with GT wood frame
def platforms = ['oak', 'spruce', 'birch', 'jungle', 'acacia', 'darkoak'];
platforms.eachWithIndex { n, i ->
    def plank = item('minecraft:planks', i);
    crafting.replaceShaped("randomthings:platform_$n", item('randomthings:platform', i) * 6, [
        [plank, plank, plank],
        [null, ore('frameGtWood'), null]
    ]);
}

crafting.remove('randomthings:blockbreaker');
crafting.remove('randomthings:igniter');

crafting.remove('randomthings:superlubricentstone');
recipemap('chemical_bath').recipeBuilder()
    .inputs(item('minecraft:stone') * 8)
    .fluidInputs(fluid('lubricant') * 250)
    .outputs(item('randomthings:superlubricentstone') * 8)
    .EUt(4)
    .duration(100)
    .buildAndRegister();

crafting.remove('randomthings:superlubricentboots');
recipemap('chemical_bath').recipeBuilder()
    .inputs(item('minecraft:iron_boots'))
    .fluidInputs(fluid('lubricant') * 1000)
    .outputs(item('randomthings:superlubricentboots'))
    .EUt(4)
    .duration(100)
    .buildAndRegister();


crafting.remove('randomthings:spectrecoil_normal');
crafting.remove('randomthings:spectrecoil_redstone');
crafting.remove('randomthings:spectrecoil_ender');
crafting.remove('randomthings:blazeandsteel');

// debatable - GT has one but this does things like teleport instead of move entities around
crafting.remove('randomthings:itemcollector');
crafting.remove('randomthings:advanceditemcollector');

crafting.remove('randomthings:timeinabottle');
/*
mods.gregtech.canner.recipeBuilder()
    .inputs(item('minecraft:clock'), item('minecraft:glass_bottle'))
    .outputs(item('randomthings:timeinabottle').withNbt(["timeData": ["storedTime": 0]]))
    .duration(6000)
    .EUt(4)
    .buildAndRegister();
*/