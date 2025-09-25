package Exercise1.CreationalDP.Singleton;

public class ConfigDemo {
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        System.out.println("Config 1 DB URL: " + config1.getDatabaseUrl());
        System.out.println("Config 1 HashCode: " + config1.hashCode());

        AppConfig config2 = AppConfig.getInstance();
        System.out.println("Config 2 DB URL: " + config2.getDatabaseUrl());
        System.out.println("Config 2 HashCode: " + config2.hashCode());

        System.out.println("\nAre both instances the same? " + (config1 == config2));
    }
}