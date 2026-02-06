package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    private WebDriver driver;

    private final By searchInput = By.name("q");
    private final By descriptionTitle = By.xpath("//div[@style='font-size:13px;']/b");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos
    public void open() {
        driver.get("https://www.google.com");
    }

    public String getDescTitle() {
        return driver.findElement(descriptionTitle).getText();
    }

    public void search(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).submit();
    }
}
