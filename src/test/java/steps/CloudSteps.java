package steps;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Form;

import java.util.ArrayList;
import java.util.List;

public class CloudSteps {

    private WebDriver driver;
    private Form estimatedFrom;
    private Form filledForm;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public void openGoogleCloud() {
        CloudStartPage page = new CloudStartPage(driver);
        page.open();
    }

    public void fillGoogleCloudForm(Form sourceForm) {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        page.switchToFrame("idIframe");
        page.computeEngine();
        page.setInstance(sourceForm.getNumberOfInstances());
        page.setOperationSystem(sourceForm.getOperationSystem());
        page.setVmClass(sourceForm.getVmClass());
        page.setInstanceType(sourceForm.getInstanceType());
        page.clickAddGPUsBox();
        page.setNumberOfGPU(sourceForm.getNumberOfGPUs());
        page.setGPUType(sourceForm.getGpuType());
        page.setSSD(sourceForm.getLocalSSD());
        page.setLocation(sourceForm.getDatacenterLocation());
        page.setCommitUsage(sourceForm.getCommittedUsage());
        page.addToEstimate();
        page.leaveFrame();
        filledForm = page.getFilledForm();
        estimatedFrom = page.getEstimatedValues();
    }

    public void exploreAllProducts() {
        CloudStartPage page = new CloudStartPage(driver);
        page.exploreAllProducts();
    }

    public void seePricing() {
        CloudProductPage page = new CloudProductPage(driver);
        page.seePricing();
    }

    public void calculate() {
        CloudPricingPage page = new CloudPricingPage(driver);
        page.calculate();
    }

    public Form getFilledForm() {
        return filledForm;
    }

    public Form getEstimatedFrom() {
        return estimatedFrom;
    }

    public void openLinkInNewTab(String url) {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
    }

    public String getMail()
    {
        MailPage page = new MailPage(driver);
        return page.getMail();
    }

    public void emailEstimate(String email)
    {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        page.emailEstimate();
        page.fillEmailEstimateForm(email);
        page.sendEmail();
    }

    public void openTab(String title)
    {
    }


}
