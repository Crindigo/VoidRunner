import classes.GQ
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
//import groovy.json.JsonGenerator
//import groovy.json.JsonOutput



/*
def gson = new GsonBuilder().setPrettyPrinting().create()

GQ.reset()

def c1_intro = GQ.quest(1, "Intro") {}

def c1_dirt_scavenge = GQ.quest(2, "Digging Around") {
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


def bq = new JsonObject()
bq.addProperty("build:8", "4.1.0")
bq.addProperty("format:8", "2.0.0")

def questDatabase = new JsonObject()
GQ.allQuests.eachWithIndex { GQ.Quest q, int i ->
    questDatabase.add("$i:10", q.toJson())
}
bq.add("questDatabase:9", questDatabase)

log.info(gson.toJson(c1_dirt_scavenge.toJson()));
*/