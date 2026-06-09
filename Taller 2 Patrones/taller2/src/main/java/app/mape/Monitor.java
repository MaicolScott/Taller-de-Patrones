package app.mape;
import app.knowledge.KnowledgeBase;

public class Monitor {
    public static void check() {
        int count = KnowledgeBase.getInstance().incrementAndGetRequests();
        System.out.println("[MONITOR] Solicitud registrada. Total actual: " + count);
        Analyzer.analyze();
    }
}