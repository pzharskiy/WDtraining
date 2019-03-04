package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public abstract class CloudPage {

    protected WebDriver driver;
    protected String BASE_URL = "https://cloud.google.com/";
    protected WebDriverWait wait;

    public CloudPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

    protected WebElement findElementInFrame(WebElement iFrame, By by) {
        switchToFrame(iFrame);
        //WebElement webElement = new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement webElement=driver.findElement(by);
        leaveFrame();
        return webElement;
    }

    private void leaveFrame() {
        driver.switchTo().defaultContent();
    }

    private void switchToFrame(WebElement iFrame)
    {
        driver.switchTo().frame(iFrame);
    }


}
