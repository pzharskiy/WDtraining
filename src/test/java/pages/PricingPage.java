package pages;

import org.openqa.selenium.WebDriver;

public class PricingPage extends CloudPage {

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "pricing/");
    }
}
