// Dirt * 1
mods.gregtech.macerator.removeByInput(2, [metaitem('bio_chaff')], null)
mods.gregtech.macerator.recipeBuilder()
    .inputs(metaitem('bio_chaff'))
    .outputs(item('minecraft:dirt') * 2)
    .duration(300)
    .EUt(2)
    .buildAndRegister()

// compressor: 8x plant fiber -> plant ball
mods.gregtech.compressor.recipeBuilder()
    .inputs(item('pyrotech:material', 12) * 8)
    .outputs(metaitem('plant_ball'))
    .duration(300)
    .EUt(2)
    .buildAndRegister()

// compressor: 8x leaves -> plant ball
mods.gregtech.compressor.recipeBuilder()
    .inputs(ore('treeLeaves') * 8)
    .outputs(metaitem('plant_ball'))
    .duration(300)
    .EUt(2)
    .buildAndRegister()


// change macerator recipe to avoid diamonds, same with rock breaker
crafting.remove('gregtech:steam_macerator_bronze');
crafting.shapedBuilder()
    .name('steam_macerator_bronze')
    .output(metaitem('steam_macerator_bronze'))
    .shape('PGP',
           'PHP',
           'SPS')
    .key('P', ore('pipeSmallFluidBronze'))
    .key('G', ore('gearPotin'))
    .key('H', item('gregtech:steam_casing'))
    .key('S', ore('craftingPiston'))
    .register();

// need to come up with wrought iron method
// fuck it let's use granite
recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustIron') * 4, ore('dustGranite'))
    .outputs(metaitem('dustWroughtIron') * 4)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustStone'))
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('stone_solution') * 1000)
    .duration(40)
    .EUt(16)
    .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
    .inputs(item('minecraft:dirt'))
    .outputs(item('minecraft:clay_ball') * 2) // clay, grass seeds, bone
    .chancedOutput(item('minecraft:bone'), 5000, 500)
    .chancedOutput(item('randomthings:grassseeds'), 1500, 500)
    .chancedOutput(item('gregtech:rubber_sapling'), 1500, 500)
    .duration(100)
    .EUt(7)
    .buildAndRegister();

// update ulv conveyor to take carpet instead of rubber sheet


// update ulv pump to take iron ring instead of rubber


// allow for ulv and lv hatches and buses to have standard crafting recipes instead of assembler only


// wooden crate just 8 planks surrounding saw



// add 2 fine dirt to dirt sifting



// crude mix fine dirt and netherrack dust for 2 sulfur dust (or maybe 1 to line up with raw rubber)
// 4 steel botany growers = 4 resin = 12 raw rubber pulp per minute
// 8 leaves/minute = 1 dirt/minute = 2 fine dirt / minute. 2 dirt + 2 nether = 4 sulfur dust. prob have something at LV for better sulfur.
// this lines up to make 4 rubber per minute. w/ alloy smelter it's 2 rubber sheet per minute.
// reminder that this is just to passive rubber, you could manually chop rubber trees to go faster than the BGs.
// with chem reactor we get 9 raw rubber + 1 sulfur = 9 fluid rubber. this becomes 12 rubber per minute (6x faster for sheets)
// move these notes to LV:
// botany growers are great for this, greenhouses better for benzene production as you need like 4 logs per second there.
// at 1 log/second you get 3500 wood tar/16 seconds (or 20 with bad coils) => 1225 benzene/16|20 seconds => 1347|1078 eu/t of benzene.
// maybe aim for 2 GH per pyro oven.
