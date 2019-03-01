package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Form;

public class CloudCalculatorPage extends CloudPage {

    private final String URL = BASE_URL + "products/calculator/";
    private Form form = new Form();
    @FindBy(id = "idIframe")
    private WebElement iFrame;
    @FindBy(xpath = "//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")
    private WebElement computeEngineButton;
    @FindBy(id = "input_46")
    private WebElement instancesLabel;

    @FindBy(id = "input_47")
    private WebElement whatAreTheseInstancesForLabel;

    @FindBy(id = "input_58")
    private WebElement operationSystemLabel;

    @FindBy(id = "select_value_label_41")
    private WebElement vmClassLabel;

    @FindBy(id = "select_93")
    private WebElement instanceTypeLabel;

    @FindBy(xpath = "//*[@role='checkbox'][@aria-label='Add GPUs']")
    private WebElement addGPUsBox;
    @FindBy(xpath = "//*[@id=\"select_338\"]")
    private WebElement numberOfGPUsLabel;

    @FindBy(xpath = "//*[@id=\"select_340\"]")
    private WebElement GPUsTypeLabel;

    @FindBy(xpath = "//*[@id=\"select_value_label_43\"]")
    private WebElement localSSDLabel;

    @FindBy(xpath = "//*[@id=\"select_97\"]")
    private WebElement dataCenterLabel;

    @FindBy(xpath = "//*[@id=\"select_102\"]")
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
        //driver.findElement(By.xpath("//md-card-content[@id='mainForm']//div[@class='tab-holder compute']")).click();
        computeEngineButton.click();
        driver.switchTo().defaultContent();
    }

    public void setInstance(String instance) {
        driver.switchTo().frame("idIframe");
        //driver.findElement(By.xpath("//*[@id='input_46']")).sendKeys(instance);
        instancesLabel.sendKeys(instance);
        driver.switchTo().defaultContent();
        //instancesLabel.sendKeys(instance);
        //findElementInFrame(iFrame, By.xpath("//*[@id='input_46']")).sendKeys(instance);
    }

    public String getInstance() {
        driver.switchTo().frame("idIframe");
        String instance = driver.findElement(By.xpath("//*[@id='input_46']")).getText();
        driver.switchTo().defaultContent();
        return instance;
    }

    //TODO parametres
    public void setOperationSystem(String operationSystem) {
        //operationSystemLabel.click();

        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[text()='" + operationSystem + "']")).click();
        driver.switchTo().defaultContent();


        /*findElementInFrame(iFrame, By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        driver.findElement(By.xpath("//*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();*/

    }

    public String getOperationSystem() {
        driver.switchTo().frame("idIframe");
        String text = driver.findElement(By.xpath("//*[@id='select_value_label_40']")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void setInstanceType() {
        driver.switchTo().frame("idIframe");
        instanceTypeLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_70']")).click();
        driver.switchTo().defaultContent();
        /*findElementInFrame(iFrame, By.id("select_93")).click();
        findElementInFrame(iFrame, By.id("select_option_70")).click();*/
    }

    public String getInstanceType() {
        driver.switchTo().frame("idIframe");
        String instanceType = driver.findElement(By.xpath("//*[@id='select_93']")).getText();
        driver.switchTo().defaultContent();
        return instanceType;
    }

    public void clickAddGPUsBox() {
        driver.switchTo().frame("idIframe");
        addGPUsBox.click();
        //new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='checkbox'][@aria-label='Add GPUs']"))).click();
        driver.switchTo().defaultContent();
    }

    public void setVmClass() {
        driver.switchTo().frame("idIframe");
        vmClassLabel.click();
        driver.findElement(By.xpath("//*[@id=\"select_option_60\"]")).click();
        driver.switchTo().defaultContent();
    }

    public String getVmClass() {
        driver.switchTo().frame("idIframe");
        String vmClass = vmClassLabel.getText();
        driver.switchTo().defaultContent();
        return vmClass;
    }

    public void setNumberOfGPU() {

        //Select options = new Select(driver.findElement(By.xpath("//*[@id='select_value_label_319']")));
        //options.selectByVisibleText(numberofGPU);

        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='select_value_label_327']")).click();
        driver.findElement(By.xpath("//*[@id='select_option_334']")).click();
        driver.switchTo().defaultContent();

    }

    public String getNumberOfGPU() {
        driver.switchTo().frame("idIframe");
        String numberOfGPU = driver.findElement(By.xpath("//*[@id='select_value_label_327']")).getText();
        driver.switchTo().defaultContent();
        return numberOfGPU;
    }

    public void setGPUType() {
        driver.switchTo().frame("idIframe");
        driver.findElement(By.xpath("//*[@id='select_value_label_328']")).click();
        driver.findElement(By.xpath("//*[@id='select_option_341']")).click();
        driver.switchTo().defaultContent();
    }

    public String getGPUType() {
        driver.switchTo().frame("idIframe");
        String gpuType = driver.findElement(By.xpath("//*[@id='select_value_label_328']")).getText();
        driver.switchTo().defaultContent();
        return gpuType;
    }

    public void setSSD() {
        driver.switchTo().frame("idIframe");
        //driver.findElement(By.xpath("//*[@id='select_95']")).click();
        localSSDLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_182']")).click();
        driver.switchTo().defaultContent();
    }

    public String getSSD() {
        driver.switchTo().frame("idIframe");
        String ssd = driver.findElement(By.xpath("//*[@id='select_95']")).getText();
        driver.switchTo().defaultContent();
        return ssd;
    }

    public void setLocation() {
        driver.switchTo().frame("idIframe");
        //driver.findElement(By.xpath("//*[@id='select_97']")).click();
        dataCenterLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_196']")).click();
        driver.switchTo().defaultContent();
    }

    public String getLocation() {
        driver.switchTo().frame("idIframe");
        String location = driver.findElement(By.xpath("//*[@id='select_97']")).getText();
        driver.switchTo().defaultContent();
        return location;
    }

    public void setCommitUsage() {
        driver.switchTo().frame("idIframe");
        //driver.findElement(By.xpath("//*[@id='select_102']")).click();
        commitedUsageLabel.click();
        driver.findElement(By.xpath("//*[@id='select_option_100']")).click();
        driver.switchTo().defaultContent();
    }

    public String getCommitUsage() {
        driver.switchTo().frame("idIframe");
        String commitUsage = driver.findElement(By.xpath("//*[@id='select_102']")).getText();
        driver.switchTo().defaultContent();
        return commitUsage;
    }

    public void addToEstimate() {
        fillForm();
        driver.switchTo().frame("idIframe");
        //*[@type='button'][@aria-label= driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[11]/button")).click();
        driver.findElement(By.xpath("//*[@type='button'][@aria-label='Add to Estimate']")).click();
        driver.switchTo().defaultContent();

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

    public Form getBlankedForm() {
        return form;
    }

//////////

    public Form getEstimatedValues() {
        Form estimatedForm = new Form();
        driver.switchTo().frame("idIframe");
        estimatedForm.setCommittedUsage(getEstimatedCommitmentTerm());
        estimatedForm.setDatacenterLocation(getEstimatedRegion());
        estimatedForm.setInstanceType(getEstimatedIntanceType());
        estimatedForm.setLocalSSD(getEstimatedLocalSSD());
        estimatedForm.setNumberOfGPUs(getNumberOfGPU());
        estimatedForm.setNumberOfInstances(getInstance());
        estimatedForm.setOperationSystem(getOperationSystem());
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

/////////

    /// Не работает, не может найти фрейм, если вход в него выполнен в виде отдельной функции
    private void switchToFrame(String idFrame) {
        driver.switchTo().frame(idFrame);
    }

    private void leaveFrame() {
        driver.switchTo().defaultContent();
    }
}
