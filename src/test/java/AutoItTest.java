import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoItTest {

    WebDriver driver = DriverSingleton.getDriver();
    String SCRIPT_FOR_UPLOAD = "D:\\autoIt\\testUpload.exe";
     @BeforeTest
    public void init() {
         driver.get("http://www.tinyupload.com/");
     }

     @Test
     public void testUpload() throws IOException  {
         new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[1]/input[2]"))).click();
         //waitForActive in *.au3 file
         Runtime.getRuntime().exec(SCRIPT_FOR_UPLOAD);
     }

     @AfterTest
         public void close(){
         driver.quit();
     }
}
