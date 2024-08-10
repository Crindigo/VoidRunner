package postInit.mod;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import static classes.Helpers.*;

crafting.remove('botania:fertilizer_powder');
crafting.remove('botania:fertilizer_dye');

// idk, temp for now
recipemap('chemical_bath').recipeBuilder()
    .inputs(metaitem('fertilizer'))
    .fluidInputs(fluid('mutagen') * 100)
    .outputs(item('botania:fertilizer'))
    .cleanroom(CleanroomType.STERILE_CLEANROOM)
    .EUt(30 * toZPM)
    .duration(200)
    .buildAndRegister();
