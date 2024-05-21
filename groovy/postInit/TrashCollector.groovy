
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