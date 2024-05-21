package chemistry.elements;

/*
aluminium line based on recycling collected trash and purifying out the Al? [https://en.wikipedia.org/wiki/Aluminium\_recycling](https://en.wikipedia.org/wiki/Aluminium_recycling) grind, magnetic separate, thermal centrifuge.  
Melt it down in an EBF w/ a flux: Rosin, tallow, olive oil, or zinc chloride. Reusable flux after cleaning. Al dust can be EBF'd directly at HV. Some LV air sieve multi that passively collects trash floating through the void? Aluminium Scrap Dust => Separated Aluminium Scrap Dust => Clean Aluminium Scrap Dust => (ebf) Molten Aluminium Blend => (centrifuge) Al(l) + ZnCl2(l)
*/

def scrapRaw = metaitem('voidrunner:aluminium_scrap_gem_chipped');
def scrapCrushed = metaitem('voidrunner:aluminium_scrap_crushed');
def scrapSeparated = metaitem('voidrunner:aluminium_scrap_dust_impure');
def scrapCleaned = metaitem('voidrunner:aluminium_scrap_dust_pure');

def EBF = mods.gregtech.electric_blast_furnace;

// move simple dust => ingot to later MV

// Aluminium Ingot * 1
EBF.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Aluminium Ingot * 1
EBF.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('nitrogen') * 1000])

EBF.recipeBuilder()
    .inputs(metaitem('dustAluminium')).circuitMeta(1)
    .outputs(metaitem('ingotAluminium'))
    .duration(900).EUt(480)
    .buildAndRegister();

EBF.recipeBuilder()
    .inputs(metaitem('dustAluminium')).fluidInputs(fluid('nitrogen') * 1000).circuitMeta(2)
    .outputs(metaitem('ingotAluminium'))
    .duration(600).EUt(480)
    .buildAndRegister();

// new line for LV

mods.gregtech.macerator.recipeBuilder()
    .inputs(scrapRaw * 2)
    .outputs(scrapCrushed, scrapCrushed)
    .duration(200)
    .EUt(8)
    .buildAndRegister();

mods.gregtech.electromagnetic_separator.recipeBuilder()
    .inputs(scrapCrushed)
    .outputs(scrapSeparated)
    .chancedOutput(metaitem('dustIron'), 1000, 250)
    .chancedOutput(item('minecraft:iron_nugget') * 2, 2000, 600)
    .duration(200)
    .EUt(24)
    .buildAndRegister();

mods.gregtech.thermal_centrifuge.recipeBuilder()
    .inputs(scrapSeparated)
    .outputs(scrapCleaned)
    .duration(200)
    .EUt(30)
    .buildAndRegister();

EBF.recipeBuilder()
    .inputs(scrapCleaned)
    .circuitMeta(1)
    .fluidOutputs(fluid('aluminium') * 144)
    .duration(600)
    .EUt(60)
    .buildAndRegister();

EBF.recipeBuilder()
    .inputs(scrapCleaned)
    .fluidInputs(fluid('nitrogen') * 1000)
    .circuitMeta(2)
    .fluidOutputs(fluid('aluminium') * 144)
    .duration(400)
    .EUt(60)
    .buildAndRegister();

EBF.recipeBuilder()
    .inputs(scrapCleaned)
    .notConsumable(ore('dustZincChloride'))
    .fluidInputs(fluid('nitrogen') * 1000)
    .circuitMeta(3)
    .fluidOutputs(fluid('aluminium') * 144)
    .duration(300)
    .EUt(60)
    .buildAndRegister();