package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import api.config.ConfigReader;

public abstract class UiBaseTest {

    protected WebDriver driver;
    protected static final String UI_BASE_URL = ConfigReader.get("ui.base.url");

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.get(UI_BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
