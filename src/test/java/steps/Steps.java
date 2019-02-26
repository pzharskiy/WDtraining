package steps;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CloudStartPage;
import pages.PastebinPage;

public class Steps {

    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void createNewPaste(String code, String expiration, String title) {
        PastebinPage page = new PastebinPage(driver);
        ///
        page.open();
        ///
        page.pasteCode(code);
        page.fillTitle(title);
        page.fillExpiration(expiration);
    }

    public void createNewPaste(String code, String highlighting, String expiration, String title) {

    }

    public String getTitle() {
        return null;
    }

    public String getCode() {
        return null;
    }

    public boolean isSyntaxHighlighted() {
        return false;
    }

    public void openPastebin() {
        PastebinPage page = new PastebinPage(driver);
        page.open();
    }

    public void openGoogleCloud() {
        CloudStartPage page = new CloudStartPage(driver);
        page.open();
    }

    public void fillGoogleCloudForm() {
    }

}
