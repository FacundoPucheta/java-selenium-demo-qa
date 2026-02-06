package ui.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void shouldOpenGoogleHomePage() throws InterruptedException {
        GoogleHomePage google = new GoogleHomePage(driver);
        google.open();
        google.search("QA Automation");
        Thread.sleep(2000);
        String descTitle = google.getDescTitle();

        //Verificación
        Assert.assertEquals(descTitle, "Acerca de esta página", "Error: El título no se corresponde con el esperado");
    }
}