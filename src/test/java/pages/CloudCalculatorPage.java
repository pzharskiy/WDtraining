package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    @FindBy(xpath = "//a[]")
    private WebElement addToEstimateButton;
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
        //driver.switchTo().frame("idIframe");
        wait.until(ExpectedConditions.elementToBeClickable(computeEngineButton)).click();
        //computeEngineButton.click();
        //driver.switchTo().defaultContent();
    }

    public void setInstance(String instance) {
        driver.switchTo().frame("idIframe");
        wait.until(ExpectedConditions.elementToBeClickable(instancesLabel)).sendKeys(instance);
        //instancesLabel.sendKeys(instance);
        driver.switchTo().defaultContent();
        }

    private String getInstance() {
        return driver.findElement(By.xpath("//*[@id='input_46']")).getText();
    }

    public void setOperationSystem(String operationSystemToBeSelected) {
        driver.switchTo().frame("idIframe");
        operationSystemLabel.click();
        wait.until(ExpectedConditions.visibilityOf(operationSystemLabel));
        String selectElementXPath = "//*[@id='select_container_59']/md-select-menu/md-content/md-option";
        List<WebElement> operationSystemList = driver.findElements(By.xpath(selectElementXPath));
            for (WebElement operationSystem : operationSystemList) {
                if (operationSystem.getText().equals(operationSystemToBeSelected)) {
                    operationSystem.click();
                }
            }
            driver.switchTo().defaultContent();
    }

    private String getOperationSystem() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_40']")).getText();
    }

    public void setInstanceType(String instanceType) {
        driver.switchTo().frame("idIframe");
        instanceTypeLabel.click();
        wait.until(ExpectedConditions.visibilityOf(instanceTypeLabel));
        String selectElementXPath = "//*[@id='select_container_94']/md-select-menu/md-content/md-optgroup[3]";
        List<WebElement> instanceTypeList = driver.findElements(By.xpath(selectElementXPath));
        //selectElementFromList(instanceTypeList, instanceType);
        driver.findElement(By.xpath("//*[@id='select_option_70']")).click();
        driver.switchTo().defaultContent();

    }

    private String getInstanceType() {
        return driver.findElement(By.xpath("//*[@id='select_93']")).getText();
    }

    public void clickAddGPUsBox() {
        driver.switchTo().frame("idIframe");
        wait.until(ExpectedConditions.elementToBeClickable(addGPUsBox)).click();
            //addGPUsBox.click();
            //new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='checkbox'][@aria-label='Add GPUs']"))).click();
            driver.switchTo().defaultContent();
    }

    public void setVmClass(String vmClass) {
        driver.switchTo().frame("idIframe");
        vmClassLabel.click();
            wait.until(ExpectedConditions.visibilityOf(vmClassLabel));
            String selectElementXPath = "//*[@id='select_container_63']/md-select-menu/md-content/md-option";
            List<WebElement> operationSystemList = driver.findElements(By.xpath(selectElementXPath));
            wait.until(ExpectedConditions.visibilityOfAllElements(operationSystemList));
            for (WebElement operationSystem : operationSystemList) {
                if (operationSystem.getText().equals(vmClass)) {
                    operationSystem.click();
                }
            }
            driver.switchTo().defaultContent();

    }

    private String getVmClass() {
        return vmClassLabel.getText();
    }

    public void setNumberOfGPU(String numberOfGPU) {

        /*driver.switchTo().frame("idIframe");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_327']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_327']")));

            String selectElementXPath = "//*[@id='select_container_347']/md-select-menu/md-content/md-option";
            List<WebElement> gpuNumberList = driver.findElements(By.xpath(selectElementXPath));
            for (WebElement gpuNumber : gpuNumberList) {
                if (gpuNumber.getText().equals(numberOfGPU)) {
                    gpuNumber.click();
                }
            }

            driver.switchTo().defaultContent();*/

        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='select_value_label_327']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_option_334']"))).click();
        //driver.findElement(By.xpath("//*[@id='select_option_334']")).click();
        driver.switchTo().defaultContent();

    }

    private String getNumberOfGPU() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_327']")).getText();

    }

    public void setGPUType(String gpuType) {
        /*driver.switchTo().frame("idIframe");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_328']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_328']")));
        String selectElementXPath = "//*[@id='select_container_349']/md-select-menu/md-content/md-option";
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectElementXPath)));
        List<WebElement> gpuTypeList = driver.findElements(By.xpath(selectElementXPath));

        for (WebElement gpuTypeItem : gpuTypeList) {
            if (gpuTypeItem.getText().equals(gpuType)) {
                gpuTypeItem.click();
            }
        }

        driver.switchTo().defaultContent();

*/
        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='select_value_label_328']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select_option_341\"]"))).click();
        //driver.findElement(By.xpath("//*[@id='select_option_358']")).click();
        driver.switchTo().defaultContent();


    }

    private String getGPUType() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_328']")).getText();
    }

    public void setSSD(String localSSD) {
        driver.switchTo().frame("idIframe");
        localSSDLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_182']")).click();
        driver.switchTo().defaultContent();

        /*driver.switchTo().frame("idIframe");
        localSSDLabel.click();
        wait.until(ExpectedConditions.visibilityOf(localSSDLabel));
        String selectElementXPath = "//*[@id='select_container_96']/md-select-menu/md-content/md-option";
        List<WebElement> localSSDList = driver.findElements(By.xpath(selectElementXPath));
        for (WebElement localSsdItem : localSSDList) {
            if (localSsdItem.getText().equals(localSSD)) {
                localSsdItem.click();
            }
        }
        driver.switchTo().defaultContent();*/
    }

    private String getSSD() {
        return driver.findElement(By.xpath("//*[@id='select_95']")).getText();
    }

    public void setLocation(String datacenterLocation) {
        driver.switchTo().frame("idIframe");
        dataCenterLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_196']")).click();
        driver.switchTo().defaultContent();


        /*driver.switchTo().frame("idIframe");
        dataCenterLabel.click();
        wait.until(ExpectedConditions.visibilityOf(dataCenterLabel));
        String selectElementXPath = "//*[@id='select_container_98']/md-select-menu/md-content/md-option";
        List<WebElement> datacenterLocationList = driver.findElements(By.xpath(selectElementXPath));
        for (WebElement datacenterLocationItem : datacenterLocationList) {
            if (datacenterLocationItem.getText().equals(datacenterLocation)) {
                datacenterLocationItem.click();
            }
        }
        driver.switchTo().defaultContent();*/
    }

    private String getLocation() {
        return driver.findElement(By.xpath("//*[@id='select_97']")).getText();
    }

    public void setCommitUsage(String commitUsage) {
        driver.switchTo().frame("idIframe");
        //driver.findElement(By.xpath("//*[@id='select_102']")).click();
        commitedUsageLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_100']")).click();
        driver.switchTo().defaultContent();

        /*driver.switchTo().frame("idIframe");
        commitedUsageLabel.click();
        wait.until(ExpectedConditions.visibilityOf(commitedUsageLabel));
        String selectElementXPath = "//*[@id='select_container_103']/md-select-menu/md-content/md-option";
        List<WebElement> commitUsageList = driver.findElements(By.xpath(selectElementXPath));
        for (WebElement commitUsageItem : commitUsageList) {
            if (commitUsageItem.getText().equals(commitUsage)) {
                commitUsageItem.click();
            }
        }
        driver.switchTo().defaultContent();*/
    }

    private String getCommitUsage() {
        return driver.findElement(By.xpath("//*[@id='select_102']")).getText();
    }

    public void addToEstimate() {
        fillForm();
        driver.switchTo().frame("idIframe");
        //*[@type='button'][@aria-label= driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[11]/button")).click();
        driver.findElement(By.xpath("//*[@type='button'][@aria-label='Add to Estimate']")).click();
        driver.switchTo().defaultContent();

    }

    private void fillForm() {
        driver.switchTo().frame("idIframe");
        form.setCommittedUsage(getCommitUsage());
        form.setDatacenterLocation(getLocation());
        form.setGpuType(getGPUType());
        form.setInstanceType(getInstanceType());
        form.setLocalSSD(getSSD());
        form.setNumberOfGPUs(getNumberOfGPU());
        form.setNumberOfInstances(getInstance());
        form.setOperationSystem(getOperationSystem());
        form.setVmClass(getVmClass());
        driver.switchTo().defaultContent();

    }


//////////

    public Form getFilledForm()
    {
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
        driver.switchTo().frame("idIframe");
        String costPerMonth = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[7]")).getText();
        driver.switchTo().defaultContent();
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

    private void selectElementFromList(List<WebElement> listOfSelectElements, String elementToBeSelected) {

        for (WebElement webElement : listOfSelectElements) {
            if (webElement.getText().equals(elementToBeSelected)) {
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
