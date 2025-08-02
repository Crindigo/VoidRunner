// mods_loaded: nuclearcraft

package postInit.mod;

def toRemove = [
    'cobblestone_generator',
    'cobblestone_generator_compact',
    'cobblestone_generator_dense',
    //'water_source',
    //'water_source_compact',
    //'water_source_dense',
    'nitrogen_collector',
    'nitrogen_collector_compact',
    'nitrogen_collector_dense',
];

for ( it in toRemove ) {
    mods.jei.ingredient.yeet(item("nuclearcraft:$it"));
}

for (x in 0..15) {
     mods.jei.ingredient.yeet(item("nuclearcraft:ingot", x));
}
for (x in 0..6) {
     mods.jei.ingredient.yeet(item("nuclearcraft:ingot2", x));
}
for (x in 0..17) {
     mods.jei.ingredient.yeet(item("nuclearcraft:alloy", x));
}

// steel/machine chassis
mods.jei.ingredient.yeet(item('nuclearcraft:part', 10));
mods.jei.ingredient.yeet(item('nuclearcraft:part', 12));

// plating
crafting.remove('nuclearcraft:part');
crafting.remove('nuclearcraft:part_1');
crafting.remove('nuclearcraft:part_2');
def basicPlating = item('nuclearcraft:part', 0);
def advPlating = item('nuclearcraft:part', 1);

mods.gregtech.forming_press.recipeBuilder()
    .inputs(ore('plateLead'), ore('dustGraphite'))
    .outputs(basicPlating)
    .EUt(30)
    .duration(80)
    .buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
    .inputs(basicPlating * 2, ore('plateRedSteel'))
    .outputs(advPlating)
    .EUt(480)
    .duration(80)
    .buildAndRegister();

// water sources
crafting.remove('nuclearcraft:water_source');
crafting.remove('nuclearcraft:water_source_compact');
crafting.remove('nuclearcraft:water_source_dense');

crafting.shapedBuilder()
    .name('nc_water_source')
    .output(item('nuclearcraft:water_source'))
    .shape('PTP',
           'W W',
           'PTP')
    .key('P', ore('plankTreatedWood'))
    .key('T', ore('plateTin'))
    .key('W', fluid('water') * 1000)
    .register();

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plankTreatedWood') * 4, ore('plateTin') * 2)
    .fluidInputs(fluid('water') * 2000)
    .outputs(item('nuclearcraft:water_source'))
    .circuitMeta(4)
    .EUt(7)
    .duration(300)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(basicPlating * 4, ore('plateAluminium') * 2)
    .fluidInputs(fluid('water') * 2000)
    .outputs(item('nuclearcraft:water_source_compact'))
    .circuitMeta(4)
    .EUt(120)
    .duration(300)
    .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
    .inputs(advPlating * 4, ore('plateTitanium') * 2)
    .fluidInputs(fluid('distilled_water') * 16000)
    .outputs(item('nuclearcraft:water_source_dense'))
    .circuitMeta(4)
    .EUt(1920)
    .duration(300)
    .buildAndRegister();

// tungsten filament (technically qmd)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('wireFineTungsten') * 8)
    .outputs(item('qmd:source').withNbt(['particle_storage': ['particle_amount': 50000000, 'particle_capacity': 50000000]]))
    .EUt(240)
    .duration(400)
    .buildAndRegister();


def ncCategories = [
 'nuclearcraft_collector',
 'nuclearcraft_decay_generator',
 'nuclearcraft_manufactory',
 'nuclearcraft_separator',
 'nuclearcraft_decay_hastener',
 'nuclearcraft_fuel_reprocessor',
 'nuclearcraft_alloy_furnace',
 'nuclearcraft_infuser',
 'nuclearcraft_melter',
 'nuclearcraft_supercooler',
 'nuclearcraft_electrolyzer',
 'nuclearcraft_assembler',
 'nuclearcraft_ingot_former',
 'nuclearcraft_pressurizer',
 'nuclearcraft_chemical_reactor',
 'nuclearcraft_salt_mixer',
 'nuclearcraft_crystallizer',
 'nuclearcraft_enricher',
 'nuclearcraft_centrifuge',
 'nuclearcraft_rock_crusher',
 'nuclearcraft_electric_furnace',
 //'nuclearcraft_radiation_scrubber',
 'nuclearcraft_fission_irradiator',
 'nuclearcraft_solid_fission',
 'nuclearcraft_salt_fission',
 'nuclearcraft_fission_moderator',
 'nuclearcraft_fission_reflector',
 'nuclearcraft_pebble_fission',
 'nuclearcraft_fission_heating',
 'nuclearcraft_coolant_heater',
 'nuclearcraft_fission_emergency_cooling',
 'nuclearcraft_heat_exchanger',
 'nuclearcraft_condenser',
 'nuclearcraft_turbine',
];

for ( cat in ncCategories ) {
    mods.jei.category.remove(cat);
}