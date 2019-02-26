package pages;

import org.openqa.selenium.WebDriver;

public class CloudPricingPage extends CloudStartPage {

    public CloudPricingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "pricing/");
    }
}
