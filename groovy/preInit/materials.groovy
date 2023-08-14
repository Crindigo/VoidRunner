import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.properties.ToolProperty

event_manager.listen { MaterialEvent event -> 
    /*def porcelain = new Material.Builder(32000, new ResourceLocation("voidrunner:porcelain"))
        .ingot()
        .color(0xF0F5F4)
        .iconSet("DULL")
        .flags("mortar_grindable")
        .toolStats(ToolProperty.Builder.of(4, 2, 64, 1).build())
        .build()*/

    def stoneSolution = new Material.Builder(32001, new ResourceLocation("voidrunner:stone_solution"))
        .fluid("liquid", true) // liquid, acid, gas, plasma
        .color(0xCDCDCD)
        .fluidTemp(293)
        .components(material('water') * 1, material('stone') * 1)
        .flags("decomposition_by_electrolyzing")
        .build()
}