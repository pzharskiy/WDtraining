package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

      private static WebDriver driver;

      private DriverSingleton() {
      }

      public static WebDriver getDriver() {
            if (null == driver) {
                 /* System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);*/

                  driver = new FirefoxDriver();
                  driver.manage().window().maximize();
            }
            return driver;
      }

      public static void closeDriver() {
            driver.quit();
            driver = null;
      }
}
