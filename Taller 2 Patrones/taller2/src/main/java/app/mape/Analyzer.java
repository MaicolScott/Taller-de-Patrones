package app.mape;
import app.knowledge.KnowledgeBase;

public class Analyzer {
    public static void analyze() {
        KnowledgeBase kb = KnowledgeBase.getInstance();
        int count = kb.getRequestCount();
        String demandLevel;

        if (count >= kb.getTextThreshold()) {
            demandLevel = "ALTA";
            System.out.println("[ANALYZE] Alta demanda detectada.");
        } else if (count >= kb.getRestrictedThreshold()) {
            demandLevel = "MEDIA";
            System.out.println("[ANALYZE] Demanda media detectada.");
        } else {
            demandLevel = "BAJA";
            System.out.println("[ANALYZE] Baja demanda detectada.");
        }
        Planner.plan(demandLevel);
    }
}