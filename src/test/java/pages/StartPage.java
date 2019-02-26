package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends CloudPage {

    @FindBy(xpath = "//a[@class='cloud-button cloud-button--primary' and @href='https://cloud.google.com/products/']")
    private WebElement exploreAllProductsButton;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage exploreAllProducts()
    {
        exploreAllProductsButton.click();
        return PageFactory.initElements(driver, ProductPage.class);
    }

    public void open() {
        driver.get(BASE_URL);
    }

}
