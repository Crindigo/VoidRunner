package quests
import static classes.GQ.quest

class Ch1 {
    static def intro = quest(0, "Across the Rift") { 
        desc = "Hmm, not sure what I was expecting.\n\nAt least I can breathe.\n\nNo obvious way back, but that's fine. Figured it was a one-way trip."
        icon = item('minecraft:writable_book')
    }

    static def new_surroundings = quest(1, "New Surroundings") {
        prereqs << Ch1.intro
        desc = "Only have my bare hands to work with here. All the gear I took with me is gone.\n\nThere's some useful items around this cabin, at least."
        icon = item('minecraft:dirt')
        task item('minecraft:sapling')
        rewards << item('minecraft:sapling')
    }

    static def fiberone = quest(2, "Daily Source of Fiber") {
        prereqs << Ch1.new_surroundings
        desc = "Instead of letting all the leaves fall on their own, let's see if breaking them apart by hand will give me anything better."
        icon = item('pyrotech:material', 12)
        task item('pyrotech:material', 12)
        task item('pyrotech:drying_rack', 1)
        task item('pyrotech:material', 13)
    }

    static def waterstrainer = quest(3, "Something in the Water") {
        prereqs << Ch1.fiberone
        desc = "This water doesn\u0027t look very clear. There\u0027s probably a lot of stuff that can be filtered out of it.\n\n§bOther strainers should not be placed in the surrounding 8 blocks of one strainer. You can dig an H shape and place down 4 strainers in a square, sharing the same water source."
        icon = item('waterstrainer:strainer_base')
        task item('pyrotech:material', 14)
        task item('waterstrainer:net', 0)
        task item('waterstrainer:net', 1)
        task item('waterstrainer:strainer_base')
    }

    static def strainerfish = quest(4, "There's Fish Too") {
        prereqs << Ch1.waterstrainer
        desc = "Some other things exist in the water besides rocks and dirt. Worms are required to gather them, however."
        icon = item('waterstrainer:worm')
        task item('waterstrainer:strainer_fisherman')
        task item('waterstrainer:worm')
    }

    static def leatherchain = quest(5, "Leather Chain") {
        prereqs << Ch1.strainerfish
        desc = "The animal hide caught in the net can be further processed into leather and durable leather, then cut into sheets and cords.\n\n" + 
            "Create tannin by filling a barrel with water and 4 leaves, then cover it with a lid."
        icon = item('minecraft:leather')
        task item('minecraft:leather')
    }
}