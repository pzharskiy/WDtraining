package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends CloudPage{

    //protected String URL = BASE_URL+"products/";

    @FindBy(xpath = "//a[@class='cloud-button cloud-button--secondary' and @href='https://cloud.google.com/pricing/']")
    WebElement seePricingButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(BASE_URL+"products/");
    }

    public PricingPage seePricing()
    {
        seePricingButton.click();
        return PageFactory.initElements(driver, PricingPage.class);
    }
}
