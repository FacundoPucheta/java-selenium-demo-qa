package ui.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.saucedemo.InventoryPage;
import pages.saucedemo.LoginPage;

public class SauceDemoLoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);

        login.open();
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventory.isLoaded(),
                "La página de inventario no se cargó correctamente");
    }
}
