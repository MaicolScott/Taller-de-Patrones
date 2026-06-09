package app.web;
import app.knowledge.KnowledgeBase;
import app.mape.Monitor;
import io.javalin.http.Context;
import java.util.Map;

public class ContentController {

    public static void getContent(Context ctx) {
        // Al recibir la solicitud, se dispara el ciclo MAPE-K [cite: 45]
        Monitor.check();

        String mode = KnowledgeBase.getInstance().getCurrentMode();
        String response;

        switch (mode) {
            case "TEXT":
                response = "<h1>Título</h1><p>Descripción resumida.</p><i>Imágenes, videos y enlaces multimedia desactivados temporalmente debido a alta demanda.</i>"; // [cite: 13]
                break;
            case "RESTRICTED":
                response = "<h1>Título</h1><p>Descripción completa.</p><img src='...' alt='Imagen'> <br><i>Videos o enlaces multimedia desactivados.</i>"; // [cite: 12]
                break;
            default:
                response = "<h1>Título</h1><p>Descripción completa.</p><img src='...' alt='Imagen'> <br><video>Video multimedia</video>"; // [cite: 11]
                break;
        }
        ctx.html(response);
    }

    public static void getStatus(Context ctx) {
        KnowledgeBase kb = KnowledgeBase.getInstance();
        ctx.json(Map.of(
                "mode", kb.getCurrentMode(),
                "requests", kb.getRequestCount(),
                "restrictedThreshold", kb.getRestrictedThreshold(),
                "textThreshold", kb.getTextThreshold()
        )); // [cite: 82, 83, 84, 85]
    }

    public static void reset(Context ctx) {
        KnowledgeBase.getInstance().resetRequests();
        KnowledgeBase.getInstance().setCurrentMode("MULTIMEDIA");
        ctx.result("Simulación reiniciada. Sistema en modo MULTIMEDIA."); // [cite: 86]
    }
}