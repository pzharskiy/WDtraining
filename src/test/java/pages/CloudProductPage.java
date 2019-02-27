package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudProductPage extends CloudPage {

    private final String URL = BASE_URL+"products/";

   // @FindBy(xpath = "//a[@class='cloud-button cloud-button--secondary' and @href='https://cloud.google.com/pricing/']")
    @FindBy(xpath = "//a[starts-with(@href,'https://cloud.google.com/pricing/')")
    WebElement seePricingButton;

    public CloudProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public CloudPricingPage seePricing()
    {
        seePricingButton.click();
        return PageFactory.initElements(driver, CloudPricingPage.class);
    }
}
