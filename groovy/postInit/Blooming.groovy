def refractoryBlock = item('pyrotech:refractory_brick_block');
crafting.addShaped("bloomery_primitive", metaitem('voidrunnercore:bloomery'), [
    [refractoryBlock, refractoryBlock, refractoryBlock],
    [refractoryBlock, ore('craftingToolHardHammer'), refractoryBlock],
    [refractoryBlock, refractoryBlock, refractoryBlock]
]);

def invarCasing = item('gregtech:metal_casing', 2);
crafting.addShaped('bloomery_electric', metaitem('voidrunnercore:electric_bloomery'), [
    [refractoryBlock, ore('cableGtSingleTin'), refractoryBlock],
    [ore('circuitLv'), invarCasing, ore('circuitLv')],
    [refractoryBlock, ore('cableGtSingleTin'), refractoryBlock]
]);

def createBloom(integrity, recipeId) {
    return item('pyrotech:bloom').withNbt([
        "BlockEntityTag": [
            "maxIntegrity": integrity, 
            "integrity": integrity,
            "experiencePerComplete": 0.0F, 
            "recipeId": recipeId, 
            "langKey": "tile.ore_block"
        ]
    ]);
}

def createBlastBlooming(oreKey, recipeId) {
    def cokes = ['gemCoke', 'dustCoke'];
    for ( coke in cokes ) {
        recipemap('bloomery').recipeBuilder()
            .inputs(ore(oreKey) * 4)
            .inputs(ore(coke) * 2)
            .outputs(createBloom(20, recipeId))
            .duration(600)
            .buildAndRegister();
    }

    def coals = ['gemCoal', 'gemCharcoal', 'dustCoal', 'dustCharcoal'];
    for (coal in coals) {
        recipemap('bloomery').recipeBuilder()
            .inputs(ore(oreKey) * 4)
            .inputs(ore(coal) * 4)
            .outputs(createBloom(20, recipeId))
            .duration(800)
            .buildAndRegister();
    }

    recipemap('electric_bloomery').recipeBuilder()
        .inputs(ore(oreKey) * 4)
        .outputs(createBloom(20, recipeId))
        .duration(300)
        .EUt(30)
        .buildAndRegister();
}

createBlastBlooming('oreMagnetite', 'crafttweaker:bloom_from_iron_ore');
createBlastBlooming('oreChalcopyrite', 'crafttweaker:bloom_from_copper_ore');
createBlastBlooming('oreCassiterite', 'crafttweaker:bloom_from_tin_ore');
createBlastBlooming('oreSphalerite', 'crafttweaker:bloom_from_zinc_ore');
createBlastBlooming('oreGalena', 'crafttweaker:bloom_from_galena_ore');

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(createBloom(20, 'crafttweaker:bloom_from_iron_ore'))
    .outputs(metaitem('ingotWroughtIron') * 18, item('minecraft:gold_ingot') * 2)
    .EUt(16)
    .duration(300)
    .buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(createBloom(20, 'crafttweaker:bloom_from_copper_ore'))
    .outputs(metaitem('ingotCopper') * 16, metaitem('ingotCobalt') * 4)
    .EUt(16)
    .duration(300)
    .buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(createBloom(20, 'crafttweaker:bloom_from_tin_ore'))
    .outputs(metaitem('ingotTin') * 18, metaitem('ingotBismuth') * 2)
    .EUt(16)
    .duration(300)
    .buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(createBloom(20, 'crafttweaker:bloom_from_zinc_ore'))
    .outputs(metaitem('ingotZinc') * 18, metaitem('ingotGallium') * 2)
    .EUt(16)
    .duration(300)
    .buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
    .inputs(createBloom(20, 'crafttweaker:bloom_from_galena_ore'))
    .outputs(metaitem('ingotLead') * 17, metaitem('ingotSilver') * 3)
    .EUt(16)
    .duration(300)
    .buildAndRegister();
