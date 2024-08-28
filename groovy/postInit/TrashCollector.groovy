
def TC = recipemap('trash_collector');

// air gives aluminium scrap
TC.recipeBuilder()
    .circuitMeta(1)
    .outputs(metaitem('voidrunner:aluminium_scrap_gem_chipped'))
    .EUt(24)
    .duration(200)
    .buildAndRegister();


// air to clean air? faster centrifuging?
// could give plastic bottles as early and slow PET source for mylar
TC.recipeBuilder()
    .fluidInputs(fluid('air') * 1000)
    .outputs(metaitem('voidrunner:aluminium_scrap_gem_chipped'))
    .EUt(24)
    .duration(100)
    .buildAndRegister();

// water recipe for some of the water strainer items?
def strainer = item('waterstrainer:strainer_survivalist_reinforced', 0);
def denseStrainer = item('waterstrainer:strainer_survivalist_dense_reinforced', 0);

// averages to 4 seconds in water strainer block. we keep at 4s but double chances.
// maybe it should output clean/filtered/junk-free water and that distills faster.
// this is 2x faster and 2x more output than base strainer, so 4x better (and lasts forever).

TC.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .notConsumable(strainer)
    .chancedOutput(item('pyrotech:rock', 0) * 4, 3000, 500)
    .chancedOutput(item('pyrotech:rock', 1) * 4, 3000, 500)
    .chancedOutput(item('pyrotech:rock', 2) * 4, 3000, 500)
    .chancedOutput(item('pyrotech:rock', 3) * 4, 3000, 500)
    .chancedOutput(item('pyrotech:rock', 4) * 4, 2000, 500)
    .chancedOutput(item('pyrotech:rock', 8) * 4, 2000, 500)
    .chancedOutput(item('pyrotech:rock', 11) * 4, 2000, 500)
    .chancedOutput(item('minecraft:clay_ball') * 2, 2000, 500)
    .EUt(24)
    .duration(80)
    .buildAndRegister();

TC.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .notConsumable(denseStrainer)
    .chancedOutput(item('pyrotech:material', 12), 5000, 500)
    .chancedOutput(item('pyrotech:material', 10), 3000, 500)
    .chancedOutput(item('waterstrainer:worm', 0), 2000, 500)
    .chancedOutput(item('pyrotech:rock', 5) * 2, 5000, 500)
    .chancedOutput(item('minecraft:reeds'), 2000, 500)
    .EUt(24)
    .duration(80)
    .buildAndRegister();

/*
strainer_survivalist|STONE|pyrotech:rock|0|4|15
strainer_survivalist|GRANITE|pyrotech:rock|1|4|15
strainer_survivalist|DIORITE|pyrotech:rock|2|4|15
strainer_survivalist|ANDESITE|pyrotech:rock|3|4|15
strainer_survivalist|DIRT|pyrotech:rock|4|4|10
strainer_survivalist|LIMESTONE|pyrotech:rock|8|4|10
strainer_survivalist|MUD|pyrotech:rock|11|4|10
strainer_survivalist|CLAY|minecraft:clay_ball|0|2|10

// plant fiber, flint shard, worm, sand pile
strainer_survivalist_dense|BLANK|BLANK|0|1|15
strainer_survivalist_dense|FIBER|pyrotech:material|12|1|25
strainer_survivalist_dense|FLINT|pyrotech:material|10|1|15
strainer_survivalist_dense|WORM|waterstrainer:worm|0|1|10
strainer_survivalist_dense|SAND|pyrotech:rock|5|2|25
strainer_survivalist_dense|REED|minecraft:reeds|0|1|10
*/