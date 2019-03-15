package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            /* System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);*/

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getRemoteDriver(String browserName) throws MalformedURLException {

        String CHROME_NODE_URL = "http://192.168.56.1:4444/wd/hub";
        String FF_NODE_URL = "http://192.168.56.1:4444/wd/hub";
        String EDGE_NODE_URL = "empty";

        if (null == driver) {
            if (browserName.equals("firefox")) {
                driver = new RemoteWebDriver(new URL(FF_NODE_URL), new FirefoxOptions());
            } else if (browserName.equals("chrome")) {
                driver = new RemoteWebDriver(new URL(CHROME_NODE_URL), new ChromeOptions());
            } else if (browserName.equals("Edge")) {
                driver = new RemoteWebDriver(new URL(EDGE_NODE_URL), new EdgeOptions());
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
