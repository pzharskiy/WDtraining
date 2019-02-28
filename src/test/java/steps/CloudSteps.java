package steps;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CloudCalculatorPage;
import pages.CloudPricingPage;
import pages.CloudProductPage;
import pages.CloudStartPage;

public class CloudSteps {

    private WebDriver driver;

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

    public void fillGoogleCloudForm() {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        page.computeEngine();
        page.setInstance("5");
        //page.setOperationSystem();
        String operationSystem = page.getOperationSystem();
        page.setInstanceType();
        page.clickAddGPUsBox();
        page.setNumberOfGPU();
        page.setGPUType();
        page.setSSD();
        page.setLocation();
        page.setCommitUsage();
        page.addToEstimate();

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


}
