package pages;

import org.openqa.selenium.WebDriver;

public class PastebinPage extends Page{

    protected String BASE_URL = "https://pastebin.com/";

    public PastebinPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }
}
