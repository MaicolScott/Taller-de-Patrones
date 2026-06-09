
package app.knowledge;

import java.io.InputStream;
import java.util.Properties;

public class KnowledgeBase {
    private static KnowledgeBase instance;
    private int requestCount = 0;
    private String currentMode = "MULTIMEDIA";
    private int restrictedThreshold;
    private int textThreshold;

    private KnowledgeBase() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            this.restrictedThreshold = Integer.parseInt(prop.getProperty("restricted.threshold"));
            this.textThreshold = Integer.parseInt(prop.getProperty("text.threshold"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KnowledgeBase getInstance() {
        if (instance == null) {
            instance = new KnowledgeBase();
        }
        return instance;
    }

    public int incrementAndGetRequests() { return ++requestCount; }
    public int getRequestCount() { return requestCount; }
    public void resetRequests() { this.requestCount = 0; }

    public String getCurrentMode() { return currentMode; }
    public void setCurrentMode(String currentMode) { this.currentMode = currentMode; }

    public int getRestrictedThreshold() { return restrictedThreshold; }
    public int getTextThreshold() { return textThreshold; }
}