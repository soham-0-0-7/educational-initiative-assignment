package Exercise1.CreationalDP.Singleton;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private String databaseUrl;

    private AppConfig() {
        this.databaseUrl = "jdbc:postgresql://localhost/mydatabase";
        System.out.println("AppConfig initialized.");
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}