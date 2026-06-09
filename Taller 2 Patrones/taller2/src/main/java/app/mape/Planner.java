package app.mape;

public class Planner {
    public static void plan(String demandLevel) {
        String targetMode = "MULTIMEDIA";

        if (demandLevel.equals("ALTA")) {
            targetMode = "TEXT";
            System.out.println("[PLAN] Activar modo texto.");
        } else if (demandLevel.equals("MEDIA")) {
            targetMode = "RESTRICTED";
            System.out.println("[PLAN] Activar modo restringido.");
        } else {
            System.out.println("[PLAN] Mantener modo multimedia.");
        }

        Executor.execute(targetMode);
    }
}