package steps;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CloudPage;
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
        CloudPage page = new CloudPage(driver);
        page.open();
    }

    public void fillGoogleCloudForm(){}

}
