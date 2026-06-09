package app;
import app.web.ContentController;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/content", ContentController::getContent); // [cite: 17]
        app.get("/status", ContentController::getStatus); // [cite: 18]
        app.get("/reset", ContentController::reset); // [cite: 18]
    }
}