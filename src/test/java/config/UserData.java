package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserData {
    private static final String PROPERTIES_FILE = "src/test/resources/application.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getEmail() {
        String email = System.getenv("TEST_EMAIL");
        return email != null ? email : properties.getProperty("test.email");
    }

    public static String getPassword() {
        String password = System.getenv("TEST_PASSWORD");
        return password != null ? password : properties.getProperty("test.password");
    }
}
