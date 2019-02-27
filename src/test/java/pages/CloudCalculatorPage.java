package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudCalculatorPage extends CloudPage {

    @FindBy(xpath = "//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")
    private WebElement computeEngineButton;
    @FindBy(id="input_492")
    private WebElement instancesLabel;
    @FindBy(id="input_493")
    private WebElement whatAreTheseInstancesForLabel;
    @FindBy(xpath = "//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")
    private WebElement operationSystemLabel;
    @FindBy(xpath = "//a[]")
    private WebElement vmClassLabel;
    @FindBy(xpath = "//a[]")
    private WebElement instanceTypeLabel;
    @FindBy(id="select_option_70")
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


    private final String URL = BASE_URL+"products/calculator/";

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void computeEngine()
    {
        computeEngineButton.click();
    }

    public void setInstance(String instance)
    {
        instancesLabel.sendKeys(instance);
    }

    //TODO parametres
    public void setOperationSystem()
    {
        operationSystemLabel.click();
    }

    public void setInstanceType()
    {
        instanceTypeLabel.click();
    }
}
