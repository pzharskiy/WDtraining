package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPricingPage extends CloudPage {

    private final String URL = BASE_URL + "pricing/";

    @FindBy(xpath = "//a[starts-with(@href,'https://cloud.google.com/pricing/calculators')]")
    WebElement calculatorButton;

    public CloudPricingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public CloudCalculatorPage calculate() {

        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(calculatorButton)).click();
                return PageFactory.initElements(driver, CloudCalculatorPage.class);
        }
        }