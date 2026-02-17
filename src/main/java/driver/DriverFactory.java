package driver;

import api.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Factory class responsible for creating and configuring WebDriver instances.
 */
public class DriverFactory {

    /**
     * Creates a WebDriver instance based on configuration values.
     * <p>
     * Supported browsers: chrome | firefox
     * </p>
     *
     * <p>
     * The execution mode (headless) is also read from configuration.
     * </p>
     *
     * @return configured WebDriver instance
     * @throws IllegalArgumentException if the browser is not supported
     */
    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        return switch (browser) {
            case "chrome" -> createChrome(headless);
            case "firefox" -> createFirefox(headless);
            default -> throw new IllegalArgumentException(
                    "Browser no soportado: " + browser
            );
        };
    }

    private static WebDriver createChrome(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefox(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }
}
