import com.crindigo.voidrunnercore.gq.RequestReloadEvent
import com.crindigo.voidrunnercore.gq.Quest
import com.crindigo.voidrunnercore.gq.Chapter
import com.crindigo.voidrunnercore.gq.Book
import static classes.GQ.quest
import static classes.GQ.chapter
import static classes.GQ.book
import quests.Ch1;

eventManager.listen { RequestReloadEvent event ->
    // run all the code to create and save the quests
    log.info("quests reloading")


    def chapter1 = chapter(0, "Earth & Stone") {
        desc = "Reality, made from scratch"
        add Ch1.intro
        add Ch1.new_surroundings
        add Ch1.fiberone
        add Ch1.waterstrainer
        add Ch1.strainerfish
        add Ch1.leatherchain
    }

    def questbook = book {
        add chapter1
    }
    questbook.save()
}