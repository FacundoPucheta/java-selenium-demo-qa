package api.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Reads configuration values from the config.properties file.
 * <p>
 * System properties (passed via JVM using -D) have priority over
 * values defined in the properties file. This allows environment
 * customization without modifying the source code.
 * </p>
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    /**
     * Retrieves a configuration value by key.
     *
     * @param key configuration key
     * @return configuration value or null if not found
     */
    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null) return systemValue;

        return properties.getProperty(key);
    }

}
