// achievable in steam age

recipemap('crude_mixer').recipeBuilder()
    .inputs(item('minecraft:gravel'))
    .fluidInputs(fluid('andesite_extract') * 125, fluid('sulfur_dioxide') * 50)
    .outputs(item('gregtech:ore_stibnite_0'))
    .EUt(7)
    .duration(400)
    .buildAndRegister();

recipemap('mixer').recipeBuilder()
    .inputs(item('minecraft:gravel'))
    .fluidInputs(fluid('andesite_extract') * 125, fluid('sulfur_dioxide') * 50)
    .outputs(item('gregtech:ore_stibnite_0'))
    .EUt(7)
    .duration(200)
    .buildAndRegister();