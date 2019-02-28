package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudProductPage extends CloudPage {

    private final String URL = BASE_URL + "products/";

    @FindBy(xpath = "//*[@class='cloud-button cloud-button--secondary'][starts-with(@href,'https://cloud.google.com/pricing/')]")
    WebElement seePricingButton;

    public CloudProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public CloudPricingPage seePricing() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(seePricingButton)).click();
        return PageFactory.initElements(driver, CloudPricingPage.class);
    }
}
