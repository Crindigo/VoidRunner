package mod.gregtech;

recipemap('crude_mixer').recipeBuilder()
    .inputs(ore('dustLead'))
    .fluidInputs(fluid('sulfuric_acid') * 250, fluid('water') * 250)
    .outputs(metaitem('voidrunner:sulfuric_lead_paste_crushed_centrifuged'))
    .EUt(7)
    .duration(200)
    .buildAndRegister();

recipemap('mixer').recipeBuilder()
    .inputs(ore('dustLead'))
    .fluidInputs(fluid('sulfuric_acid') * 250, fluid('water') * 250)
    .outputs(metaitem('voidrunner:sulfuric_lead_paste_crushed_centrifuged') * 2)
    .EUt(7)
    .duration(200)
    .buildAndRegister();

crafting.addShapeless('lead_acid_battery', metaitem('voidrunner:battery.lv.lead_acid'), [
    metaitem('battery.hull.lv'), 
    metaitem('voidrunner:sulfuric_lead_paste_crushed_centrifuged'),
    metaitem('voidrunner:sulfuric_lead_paste_crushed_centrifuged')
]);