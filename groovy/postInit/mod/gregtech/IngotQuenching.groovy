package postInit.mod.gregtech;

def quenchingList = [
    'ingotHotBlackBronze': 'ingotBlackBronze',
];

for (entry in quenchingList) {
    mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(ore(entry.key))
        .fluidInputs(fluid('water') * 100)
        .outputs(metaitem(entry.value))
        .duration(300)
        .EUt(120)
        .buildAndRegister();

    mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(ore(entry.key))
        .fluidInputs(fluid('distilled_water') * 100)
        .outputs(metaitem(entry.value))
        .duration(200)
        .EUt(120)
        .buildAndRegister();
}
