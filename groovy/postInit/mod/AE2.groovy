package mod;

// fluix in-world crafting disabled
recipemap('mixer').recipeBuilder()
    .inputs(ore('dustNetherQuartz'), ore('dustQuartzite'), ore('dustCertusQuartz'))
    .fluidInputs(fluid('redstone') * 144)
    .outputs(ore('dustFluix').first * 2)
    .EUt(240)
    .duration(200)
    .buildAndRegister();

recipemap('autoclave').recipeBuilder()
    .inputs(ore('dustFluix'))
    .fluidInputs(fluid('distilled_water') * 50)
    .outputs(ore('crystalFluix').first)
    .EUt(24)
    .duration(600)
    .buildAndRegister();

recipemap('macerator').recipeBuilder()
    .inputs(ore('crystalFluix'))
    .outputs(ore('dustFluix').first)
    .EUt(2)
    .duration(20)
    .buildAndRegister();

recipemap('macerator').recipeBuilder()
    .inputs(item('appliedenergistics2:fluix_block'))
    .outputs(ore('dustFluix').first * 4)
    .EUt(2)
    .duration(80)
    .buildAndRegister();

crafting.remove("appliedenergistics2:misc/grindstone");
crafting.remove("appliedenergistics2:misc/grindstone_crank");

// remove certus byproduct from quartz sand centrifuge
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustQuartzSand') * 2], null);
mods.gregtech.centrifuge.recipeBuilder()
    .inputs(metaitem('dustQuartzSand') * 2)
    .outputs(metaitem('dustQuartzite'))
    .chancedOutput(metaitem('dustQuartzite'), 2000, 200)
    .EUt(30)
    .duration(60)
    .buildAndRegister();


// might just remove "pure" variants of quartz
// replace inscriber with excimer KrF used for EV circuits, or use high purity silicon wafers
// maybe certus-doped wafers
// collect certus dusts from a high-altitude air filter machine or drones "strange alien material"
