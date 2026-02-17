package ui.tests;

import base.UiBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

public class GoogleSearchTest extends UiBaseTest {

    @Test
    public void shouldOpenGoogleHomePage() throws InterruptedException {
        GoogleHomePage google = new GoogleHomePage(driver);
        google.open();
        google.search("QA Automation");
        Thread.sleep(2000);
        String descTitle = google.getDescTitle();
        System.out.println("Título encontrado: " + descTitle);

        //Verificación
        Assert.assertNotNull(descTitle, "Error: El título debe existir");
        Assert.assertFalse(descTitle.isBlank(), "Error: El título no debe ser vacío");

    }
}