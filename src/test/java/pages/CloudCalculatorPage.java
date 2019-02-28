package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudCalculatorPage extends CloudPage {

    private final String URL = BASE_URL + "products/calculator/";
    @FindBy(id = "idIframe")
    private WebElement iFrame;
    /*@FindBy(xpath = "//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")
    private WebElement computeEngineButton;
    @FindBy(id = "input_492")
    private WebElement instancesLabel;*/
    @FindBy(id = "input_493")
    private WebElement whatAreTheseInstancesForLabel;
    @FindBy(xpath = "//*[@id='select_value_label_40']")
    private WebElement operationSystemLabel;
    @FindBy(xpath = "//a[]")
    private WebElement vmClassLabel;
    @FindBy(id = "select_option_70")
    private WebElement instanceTypeLabel;
    @FindBy(id = "select_option_70")
    private WebElement addGPUsBox;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[6]/div[1]/md-input-container/md-checkbox/div[1]")
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

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void computeEngine() {

        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")).click();
        driver.switchTo().defaultContent();
    }

    public void setInstance(String instance) {
        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='input_46']")).sendKeys(instance);
        driver.switchTo().defaultContent();
        //instancesLabel.sendKeys(instance);
        //findElementInFrame(iFrame, By.xpath("//*[@id='input_46']")).sendKeys(instance);
    }

    //TODO parametres
    public void setOperationSystem() {
        //operationSystemLabel.click();

        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        driver.switchTo().defaultContent();


        /*findElementInFrame(iFrame, By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        driver.findElement(By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();*/

    }

    public String getOperationSystem()
    {
        driver.switchTo().frame("idIframe");
        String text = driver.findElement(By.xpath("//*[@id='select_value_label_40']")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void setInstanceType() {
        //instanceTypeLabel.click();
        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='select_93']")).click();
        driver.findElement(By.xpath("//*[@id='select_option_70']")).click();
        driver.switchTo().defaultContent();


        /*findElementInFrame(iFrame, By.id("select_93")).click();
        findElementInFrame(iFrame, By.id("select_option_70")).click();*/
    }

    public void clickAddGPUsBox()
    {
        driver.switchTo().frame("idIframe");
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='checkbox'][@aria-label='Add GPUs']"))).click();
        driver.switchTo().defaultContent();
    }

    public void setNumberOfGPU()
    {
        driver.switchTo().frame("idIframe");
        //new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_value_label_319']"))).click();
        //new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_356']"))).click();
        driver.switchTo().defaultContent();
    }

}
