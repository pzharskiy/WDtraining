package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    @FindBy(id="mailAddress")
    WebElement copyAddress;
    private String mail;
    protected WebDriver driver;
    protected String BASE_URL = "https://10minutemail.com/";
    protected WebDriverWait wait;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
        mail = wait.until(ExpectedConditions.visibilityOf(copyAddress)).getAttribute("value");
    }

    public void open(){
        driver.get(BASE_URL);
    }

    public String getMail()
    {
        return mail;
    }

    public String getPriceFromMail(String subject1)
    {
        String subject="Google Cloud Platform Price Estimate";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-id-1']/span[contains(text(), '"+subject+"')]")));

        return null;
    }
}
