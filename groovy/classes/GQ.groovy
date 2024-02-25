package classes
import com.crindigo.voidrunnercore.gq.Quest
import com.crindigo.voidrunnercore.gq.Chapter
import com.crindigo.voidrunnercore.gq.Book

class GQ {
    static Quest quest(int id, String name, @DelegatesTo(Quest) Closure cl) {
        def quest = new Quest(id, name)
        def code = cl.rehydrate(quest, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return quest
    }

    static Book book(@DelegatesTo(Book) Closure cl) {
        def b = new Book()
        def code = cl.rehydrate(b, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return b
    }

    static Chapter chapter(int id, String name, @DelegatesTo(Chapter) Closure cl) {
        def c = new Chapter(id, name)
        def code = cl.rehydrate(c, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return c
    }
}