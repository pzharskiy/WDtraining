import driver.DriverSingleton;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTests {

    WebDriver driver = null;
    WebDriver driver2;
    //RemoteWebDriver driver;
    String BASE_URL = "http://google.com/";
    String CHROME_NODE_URL = "http://192.168.56.1:4444/wd/hub";
    String FF_NODE_URL = "http://192.168.56.1:4444/wd/hub";
    String EDGE_NODE_URL = "empty";
    @BeforeMethod
    @Parameters("browser")
    public void init(String browserName) throws MalformedURLException {

        driver = DriverSingleton.getRemoteDriver(browserName);

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
