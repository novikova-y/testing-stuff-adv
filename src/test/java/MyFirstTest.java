import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by me on 28.10.16.
 */
public class MyFirstTest {
    @Test
    public void startWebDriver() {

        System.setProperty("webdriver.gecko.driver", "/home/me/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://ellenwhite.org");
        Assert.assertTrue("title should start with Ellen G. White",
                driver.getTitle().startsWith("Ellen G. White"));

        driver.close();
        driver.quit();
    }
}
