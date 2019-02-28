package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudStartPage extends CloudPage {


    @FindBy(xpath = "//a[@class='cloud-button cloud-button--primary' and @href='https://cloud.google.com/products/']")
    private WebElement exploreAllProductsButton;

    private String URL = "https://cloud.google.com/";

    public CloudStartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public CloudProductPage exploreAllProducts() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(exploreAllProductsButton)).click();
        return PageFactory.initElements(driver, CloudProductPage.class);
    }

}
