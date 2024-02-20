import classes.Quest
import com.google.gson.GsonBuilder
//import groovy.json.JsonGenerator
//import groovy.json.JsonOutput


Quest quest(int id, String name, @DelegatesTo(Quest) Closure cl) {
    def quest = new Quest(id, name)
    def code = cl.rehydrate(quest, this, this)
    code.resolveStrategy = Closure.DELEGATE_ONLY
    code()
    return quest
}

def gson = new GsonBuilder().setPrettyPrinting().create()

def c1_intro = quest(1, "Intro") {}

def c1_dirt_scavenge = quest(2, "Digging Around") {
    prereqs = [c1_intro]
    icon = item("minecraft:dirt")
    desc = "Only have my bare hands to work with here. All the gear I took with me is gone.\n\n" +
        "Might be able to get something useful out of this dirt.\n\n" +
        "<gray>(Dig into the dirt by holding shift and the right mouse button with an empty hand.)"

    rewards = [
        item("pyrotech:iron_hammer"),
        item("minecraft:stone", 3) * 4,
    ]

    requirements = [metaitem("plateStainlessSteel")]
}

log.info(gson.toJson(c1_dirt_scavenge.toJson()));