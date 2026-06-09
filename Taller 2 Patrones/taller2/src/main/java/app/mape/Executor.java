package app.mape;
import app.knowledge.KnowledgeBase;

public class Executor {
    public static void execute(String targetMode) {
        KnowledgeBase kb = KnowledgeBase.getInstance();
        if (!kb.getCurrentMode().equals(targetMode)) {
            kb.setCurrentMode(targetMode);
            System.out.println("[EXECUTE] El sistema cambio a modo " + targetMode);
        }
    }
}