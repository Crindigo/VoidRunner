package postInit.mod;

def toRemove = [
    'cobblestone_generator',
    'cobblestone_generator_compact',
    'cobblestone_generator_dense',
    'water_source',
    'water_source_compact',
    'water_source_dense',
    'nitrogen_collector',
    'nitrogen_collector_compact',
    'nitrogen_collector_dense',
];

for ( it in toRemove ) {
    mods.jei.ingredient.yeet(item("nuclearcraft:$it"));
}

// steel/machine chassis
mods.jei.ingredient.yeet(item('nuclearcraft:part', 10));
mods.jei.ingredient.yeet(item('nuclearcraft:part', 12));


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