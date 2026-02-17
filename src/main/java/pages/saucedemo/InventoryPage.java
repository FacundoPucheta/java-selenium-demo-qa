package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Selectores
    private final By inventoryContainer = By.id("inventory_container");

    //Métodos
    public boolean isLoaded() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}
