package pages;

import org.openqa.selenium.WebDriver;

public class CloudPage extends Page{

    protected  String BASE_URL = "https://cloud.google.com/";

    public CloudPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }
}
