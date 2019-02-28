package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchiveCalculate extends CloudPage{

    private final String URL = BASE_URL + "products/calculator/";
    @FindBy(id = "idIframe")
    private WebElement iFrame;
    /*@FindBy(xpath = "//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")
    private WebElement computeEngineButton;
    @FindBy(id = "input_492")
    private WebElement instancesLabel;*/
    @FindBy(id = "input_493")
    private WebElement whatAreTheseInstancesForLabel;
    @FindBy(xpath = "//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")
    private WebElement operationSystemLabel;
    @FindBy(xpath = "//a[]")
    private WebElement vmClassLabel;
    @FindBy(id = "select_option_70")
    private WebElement instanceTypeLabel;
    @FindBy(id = "select_option_70")
    private WebElement addGPUsBox;
    @FindBy(xpath = "//a[]")
    private WebElement numberOfGPUsLabel;
    @FindBy(xpath = "//a[]")
    private WebElement GPUsTypeLabel;
    @FindBy(xpath = "//a[]")
    private WebElement localSSDLabel;
    @FindBy(xpath = "//a[]")
    private WebElement dataCenterLabel;
    @FindBy(xpath = "//a[]")
    private WebElement commitedUsageLabel;
    @FindBy(xpath = "//a[]")
    private WebElement addToEstimateButton;

    public ArchiveCalculate(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void computeEngine() {
/*
        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")).click();
        driver.switchTo().defaultContent();*/
        findElementInFrame(iFrame, By.xpath("//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")).click();
        //computeEngineButton.click();
    }

    public void setInstance(String instance) {
        //driver.switchTo().frame("idIframe");
        //instancesLabel.sendKeys(instance);
        findElementInFrame(iFrame, By.xpath("//*[@id='input_46']")).sendKeys(instance);
    }

    //TODO parametres
    public void setOperationSystem() {
        //operationSystemLabel.click();
        findElementInFrame(iFrame, By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        driver.findElement(By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();

    }

    public void setInstanceType() {
        //instanceTypeLabel.click();
        findElementInFrame(iFrame, By.id("select_93")).click();
        findElementInFrame(iFrame, By.id("select_option_70")).click();
    }


}
