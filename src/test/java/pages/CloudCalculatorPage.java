package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Form;

import java.util.List;

public class CloudCalculatorPage extends CloudPage {

    private final String URL = BASE_URL + "products/calculator/";
    private Form form = new Form();
    @FindBy(id = "idIframe")
    private WebElement iFrame;
    //@FindBy(xpath = "//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")
    @FindBy(xpath = "//div[@title='Compute Engine']")
    private WebElement computeEngineButton;
    //@FindBy(id = "input_46")
    @FindBy(name = "quantity")
    private WebElement instancesLabel;
    //@FindBy(id = "input_47")
    @FindBy(name = "label")
    private WebElement whatAreTheseInstancesForLabel;
    //@FindBy(id = "input_58")
    @FindBy(id = "select_value_label_40")
    private WebElement operationSystemLabel;
    //@FindBy(id = "input_62")
    @FindBy(id = "select_value_label_41")
    private WebElement vmClassLabel;
    //@FindBy(id = "input_93")
    @FindBy(id = "select_value_label_42")
    private WebElement instanceTypeLabel;
    @FindBy(xpath = "//*[@role='checkbox'][@aria-label='Add GPUs']")
    private WebElement addGPUsBox;
    @FindBy(xpath = "//*[@id=\"select_338\"]")
    private WebElement numberOfGPUsLabel;
    @FindBy(xpath = "//*[@id=\"select_340\"]")
    private WebElement GPUsTypeLabel;
    @FindBy(xpath = "//*[@id=\"select_value_label_43\"]")
    private WebElement localSSDLabel;
    //@FindBy(xpath = "//*[@id=\"select_97\"]")
    @FindBy(id = "select_value_label_44")
    private WebElement dataCenterLabel;
    //@FindBy(xpath = "//*[@id=\"select_102\"]")
    @FindBy(id = "select_value_label_45")
    private WebElement commitedUsageLabel;
    @FindBy(id = "select_container_59")
    private WebElement selectOSAndSoftwareContainer;
    @FindBy(id = "select_container_63")
    private WebElement selectVMClassContainer;
    @FindBy(id = "select_container_94")
    private WebElement selectInstanceTypeContainer;
    @FindBy(id = "select_container_330")
    private WebElement selectNumberOfGPUsContainer;
    @FindBy(id = "select_container_332")
    private WebElement selectGPUTypeContainer;
    @FindBy(id = "select_container_96")
    private WebElement selectLocalSSDContainer;
    @FindBy(id = "select_container_98")
    private WebElement selectDataCenterLocationContainer;
    @FindBy(id = "select_container_103")
    private WebElement selectCommitedUsageContainer;

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void computeEngine() {
        wait.until(ExpectedConditions.elementToBeClickable(computeEngineButton)).click();
    }

    public void setInstance(String instance) {
        wait.until(ExpectedConditions.elementToBeClickable(instancesLabel)).sendKeys(instance);
    }

    private String getInstance() {

        return instancesLabel.getAttribute("value");
    }

    public void setOperationSystem(String operationSystemToBeSelected) {
        operationSystemLabel.click();
        //wait.until(ExpectedConditions.visibilityOf(operationSystemLabel));
        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));
        String XPath = "//div[@id='select_container_59']/md-select-menu/md-content/md-option/div[@class='md-text']";
        selectOption(XPath, operationSystemToBeSelected);
    }

    private String getOperationSystem() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_40']")).getText();
    }

    public void setInstanceType(String instanceType) {
        wait.until(ExpectedConditions.visibilityOf(instanceTypeLabel)).click();
        //instanceTypeLabel.click();
        String XPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.visibilityOf(selectInstanceTypeContainer));
        selectOption(XPath, instanceType);
    }

    private String getInstanceType() {
        return driver.findElement(By.xpath("//*[@id='select_93']")).getText();
    }

    public void clickAddGPUsBox() {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUsBox)).click();
        //addGPUsBox.click();
        //new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='checkbox'][@aria-label='Add GPUs']"))).click();
    }

    public void setVmClass(String vmClass) {
        vmClassLabel.click();
        String XPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));
        selectOption(XPath, vmClass);

    }

    private String getVmClass() {
        return vmClassLabel.getText();
    }

    public void setNumberOfGPU(String numberOfGPU) {

        String XPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_327']"))).click();
        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGPUsContainer));
        selectOption(XPath, numberOfGPU);

    }

    private String getNumberOfGPU() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_327']")).getText();

    }

    public void setGPUType(String gpuType) {
        String XPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_328']"))).click();
        wait.until(ExpectedConditions.visibilityOf(selectGPUTypeContainer));
        selectOption(XPath, gpuType);
    }

    private String getGPUType() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_328']")).getText();
    }

    public void setSSD(String localSSD) {
        String XPath = "//div[@id='select_container_96']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOf(localSSDLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectLocalSSDContainer));
        selectOption(XPath, localSSD);
    }

    private String getSSD() {
        return driver.findElement(By.xpath("//*[@id='select_95']")).getText();
    }

    public void setLocation(String datacenterLocation) {
        String XPath = "//div[@id='select_container_98']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOf(dataCenterLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectDataCenterLocationContainer));
        selectOption(XPath, datacenterLocation);
    }

    private String getLocation() {
        return driver.findElement(By.xpath("//*[@id='select_97']")).getText();
    }

    public void setCommitUsage(String commitUsage) {
        String XPath = "//div[@id='select_container_103']/md-select-menu/md-content/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.elementToBeClickable(commitedUsageLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectCommitedUsageContainer));
        selectOption(XPath, commitUsage);
    }

    private String getCommitUsage() {
        return driver.findElement(By.xpath("//*[@id='select_102']")).getText();
    }

    public void addToEstimate() {
        fillForm();
        driver.findElement(By.xpath("//*[@type='button'][@aria-label='Add to Estimate']")).click();
    }

    public void emailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email_quote"))).click();
    }

    public void fillEmailEstimateForm(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("input_380"))).sendKeys(email);
    }

    public void sendEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Send Email')]"))).click();
    }

    private void fillForm() {
        form.setCommittedUsage(getCommitUsage());
        form.setDatacenterLocation(getLocation());
        form.setGpuType(getGPUType());
        form.setInstanceType(getInstanceType());
        form.setLocalSSD(getSSD());
        form.setNumberOfGPUs(getNumberOfGPU());
        form.setNumberOfInstances(getInstance());
        form.setOperationSystem(getOperationSystem());
        form.setVmClass(getVmClass());

    }


//////////

    public Form getFilledForm() {
        return form;
    }

    public Form getEstimatedValues() {
        Form estimatedForm = new Form();
        driver.switchTo().frame("idIframe");
        estimatedForm.setCommittedUsage(getEstimatedCommitmentTerm());
        estimatedForm.setDatacenterLocation(getEstimatedRegion());
        estimatedForm.setInstanceType(getEstimatedIntanceType());
        estimatedForm.setLocalSSD(getEstimatedLocalSSD());
        estimatedForm.setVmClass(getEstimatedVMClass());
        driver.switchTo().defaultContent();
        return estimatedForm;
    }

    public String getCostPerMonth() {
        String costPerMonth = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[7]")).getText();
        return costPerMonth;
    }

    private String getEstimatedVMClass() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]")).getText();
    }

    private String getEstimatedIntanceType() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[3]")).getText();
    }

    private String getEstimatedRegion() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[4]")).getText();
    }

    private String getEstimatedLocalSSD() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[5]")).getText();
    }

    private String getEstimatedCommitmentTerm() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[6]")).getText();
    }

    private void selectOption(String XPath, String optionToBeSelected) {

        List<WebElement> listOfSelectOptions = driver.findElements(By.xpath(XPath));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(XPath))));
        for (WebElement webElement : listOfSelectOptions) {
            if (webElement.getText().equals(optionToBeSelected)) {
                webElement.click();
            }
        }
    }

/////////

    /// Не работает, не может найти фрейм, если вход в него выполнен в виде отдельной функции
    public void switchToFrame(String idFrame) {
        driver.switchTo().frame(idFrame);
    }

    public void leaveFrame() {
        driver.switchTo().defaultContent();
    }
}
