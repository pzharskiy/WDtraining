package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage extends Page {

    @FindBy(id = "paste_code")
    WebElement pasteCodeTextArea;

    @FindBy(id = "select2-paste_expire_date-zi-container")
    WebElement expiration;

    @FindBy(name = "paste_name")
    WebElement title;

    @FindBy(id = "submit")
    WebElement pasteCodeButton;

    protected String BASE_URL = "https://pastebin.com/";

    public PastebinPage(WebDriver driver) {
        super(driver);
    }

    public void pasteCode(String code)
    {
       pasteCodeTextArea.sendKeys(code);
    }

    public void fillExpiration(String expiration) {

        this.expiration.click();
        WebElement tenMinutesExpirationField = new WebDriverWait(driver,5).
                until(ExpectedConditions.presenceOfElementLocated(By.
                                xpath("span[@aria-activedescendant='select2-paste_expire_date-zi-result-iuwz-10M']")));
        tenMinutesExpirationField.click();
    }

    public void fillTitle(String title) {

        this.title.sendKeys(title);
    }

    public void submitPasteCode()
    {
        pasteCodeButton.click();
    }

    public void open() {
        driver.get(BASE_URL);
    }
}
