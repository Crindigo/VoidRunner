package classes
import betterquesting.api.utils.NBTConverter
import com.google.gson.JsonObject

class GQ {

    public static List<GQ.Quest> allQuests = []

    static def reset() {
        allQuests = []
    }

    static GQ.Quest quest(int id, String name, @DelegatesTo(GQ.Quest) Closure cl) {
        def quest = new GQ.Quest(id, name)
        def code = cl.rehydrate(quest, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return quest
    }

    static GQ.Book book(int id, String name, @DelegatesTo(GQ.Book) Closure cl) {
        def b = new GQ.Book()
        def code = cl.rehydrate(b, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return b
    }

    public static class Book {
        public List<GQ.Chapter> chapters
        public Map<Integer, GQ.Chapter> byId

        GQ.Chapter chapter(int id, String name, @DelegatesTo(GQ.Chapter) Closure cl) {
            def ch = new GQ.Chapter(id, name)
            def code = cl.rehydrate(ch, this, this)
            code.resolveStrategy = Closure.DELEGATE_ONLY
            code()
            this.chapters << ch
            this.byId[id] = ch
            return ch
        }

        JsonObject toJson() {
            JsonObject obj = new JsonObject()

            return obj
        }
    }

    public static class Chapter {
        public ItemStack icon
        public String desc
        public Map<GQ.Quest, int[]> quests
        public Map<Integer, GQ.Quest> byId

        Chapter(int id, String name) {
            this.id = id
            this.name = name
        }

        def quest(GQ.Quest quest, int[] pos) {
            this.quests[quest] = pos
            this.byId[quest.id] = quest
        }

        def repos(int id, int[] pos) {
            this.quests[this.byId[id]] = pos
        }

        JsonObject toJson() {
            JsonObject obj = new JsonObject()

            return obj
        }
    }

    public static class Quest {
        public int id
        public String name
        public String desc
        public ItemStack icon
        public ItemStack[] rewards
        public Quest[] prereqs
        public ItemStack[] requirements

        Quest(int id, String name) {
            this.id = id
            this.name = name
        }

        //ItemStack item(String id, int meta = 0) {
        //    return new ItemStack(id, meta)
        //}

        //ItemStack metaitem(String id) {
        //    return new ItemStack(id, 0)
        //}

        Map<String, Object> toJson() {
            def rewardMap = [:]
            rewards.eachWithIndex { ItemStack entry, int i ->
                rewardMap["$i:10"] = [
                    "Count:3"  : entry.count,
                    "Damage:2" : entry.metadata,
                    "OreDict:8": "",
                    "id:8"     : entry.item.registryName.toString(),
                    // tag:10 nbt
                ]
                if ( entry.nbt ) {
                    rewardMap["$i:10"]["tag:10"] = NBTConverter.NBTtoJSON_Compound(entry.nbt, new JsonObject(), true)
                }
            }

            def tasksMap = [:]
            requirements.eachWithIndex { ItemStack entry, int i ->
                tasksMap["$i:10"] = [
                    "Count:3"  : entry.count,
                    "Damage:2" : entry.metadata,
                    "OreDict:8": "",
                    "id:8"     : entry.item.registryName.toString(),
                    // tag:10 nbt
                ]
                
                if ( entry.nbt ) {
                    tasksMap["$i:10"]["tag:10"] = NBTConverter.NBTtoJSON_Compound(entry.nbt, new JsonObject(), true)
                }
            }

            return [
                "preRequisites:11": prereqs.collect { it.id },
                "properties:10"   : [
                    "betterquesting:10": [
                        "autoclaim:1": 0,
                        "desc:8": desc,
                        "globalshare:1": 0,
                        "icon:10": [
                            "Count:3": 1,
                            "Damage:2": icon.metadata, // metadata
                            "OreDict:8": "",
                            "id:8": icon.item.registryName.toString(), //  item id
                            // can have tag:10 for custom nbt on items
                        ],
                        "ignoresview:1": 0,
                        "ismain:1": 0,
                        "issilent:1": 0,
                        "lockedprogress:1": 0,
                        "name:8": name,
                        "questlogic:8": "AND",
                        "repeat_relative:1": 1,
                        "repeattime:3": -1,
                        "simultaneous:1": 0,
                        "snd_complete:8": "minecraft:entity.player.levelup",
                        "snd_update:8": "minecraft:entity.player.levelup",
                        "tasklogic:8": "AND",
                        "visibility:8": "NORMAL",
                    ]
                ],
                "questID:3": id,
                "rewards:9": [
                    "0:10": [
                        "index:3": 0,
                        "rewardID:8": "bq_standard:item",
                        "rewards:9": rewardMap,
                    ]
                ],
                "tasks:9": [
                    "0:10": [
                        "autoConsume:1": 0,
                        "consume:1": 0,
                        "groupDetect:1": 0,
                        "ignoreNBT:1": 0,
                        "index:3": 0,
                        "partialMatch:1": 1,
                        "requiredItems:9": tasksMap,
                        "taskID:8": "bq_standard:retrieval",
                    ]
                ]
            ]
        }
    }
}