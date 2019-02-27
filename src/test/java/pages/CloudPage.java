package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CloudPage {

    protected WebDriver driver;
    protected  String BASE_URL = "https://cloud.google.com/";

    public CloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

}
