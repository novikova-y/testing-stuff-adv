import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SeleniumFilterTests {
    final String siteURL = "http://ellenwhite.org/library?f%5B0%5D=bundle%3Afiles";
    private static WebDriver driver;

    @BeforeClass
    public static void initDriver() {

        System.setProperty("webdriver.chrome.driver", "/home/me/Downloads/chromedriver");
        /*System.setProperty("webdriver.gecko.driver", "/home/me/Downloads/geckodriver");*/
        /*driver = new FirefoxDriver();*/
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
    @Test
    public void FilterDocumentsTest() throws InterruptedException {

        driver.get(siteURL);

        WebElement element = driver.findElement(By.id("edit-checkboxes-4-document"));
        element.click();

        driver.findElement(By.id("edit-filter-button--9")).click();


        //Thread.sleep(10000);
        //assertEquals("http://ellenwhite.org/library?f[0]=bundle%3Afiles&f[1]=sm_field_files_primary_media%3Adocument", driver.getCurrentUrl());
        driver.findElement(By.linkText("1. Original Documentation About John White by the Justice of Pease (DF 701)")).click();

        WebElement docVwr = driver.findElement(By.id("toolbar_documentViewer0"));
        Assert.assertEquals(true, docVwr.isDisplayed());

    }

    @Test
    public void FilterVideosTest() throws InterruptedException {

        driver.get(siteURL);

        WebElement element = driver.findElement(By.id("edit-checkboxes-4-video"));
        element.click();

        driver.findElement(By.id("edit-filter-button--9")).click();


        Thread.sleep(10000);
        assertEquals("http://ellenwhite.org/library?f[0]=bundle%3Afiles&f[1]=sm_field_files_primary_media%3Avideo", driver.getCurrentUrl());
    }

    @Test
    public void FilterImagesTest() throws InterruptedException {

        driver.get(siteURL);

        WebElement element = driver.findElement(By.id("edit-checkboxes-4-image"));
        element.click();

        driver.findElement(By.id("edit-filter-button--9")).click();


        Thread.sleep(10000);
        assertEquals("http://ellenwhite.org/library?f[0]=bundle%3Afiles&f[1]=sm_field_files_primary_media%3Aimage", driver.getCurrentUrl());
    }

    @Test
    public void FilterAudiosTest() throws InterruptedException {

        driver.get(siteURL);

        WebElement element = driver.findElement(By.id("edit-checkboxes-4-audio"));
        element.click();

        driver.findElement(By.id("edit-filter-button--9")).click();


        Thread.sleep(10000);
        assertEquals("http://ellenwhite.org/library?f[0]=bundle%3Afiles&f[1]=sm_field_files_primary_media%3Aaudio", driver.getCurrentUrl());

    }

}
