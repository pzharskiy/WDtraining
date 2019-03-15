import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RemoteTests {

    WebDriver driver = null;
    String BASE_URL = "http://google.com/";

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void init(String browserName, String url) throws MalformedURLException {

        driver = DriverSingleton.getRemoteDriver(browserName, url);

        /*if (browserName.equals("firefox")) {
            driver = new RemoteWebDriver(new URL(FF_NODE_URL), new FirefoxOptions());
        } else if (browserName.equals("chrome")) {
            driver = new RemoteWebDriver(new URL(CHROME_NODE_URL), new ChromeOptions());
        } else if (browserName.equals("Edge")) {
            driver = new RemoteWebDriver(new URL(EDGE_NODE_URL), new EdgeOptions());
        }*/
        driver.get(BASE_URL);
        /*
        ChromeOptions options = new ChromeOptions();
        options.setCapability("BROWSER_NAME", "chrome");
        options.setCapability("PLATFORM_NAME", Platform.WIN10);
        driver = new RemoteWebDriver(new URL(CHROME_NODE_URL),options);*/

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void getUrlTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }


}
