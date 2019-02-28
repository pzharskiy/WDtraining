import org.testng.annotations.Test;
import steps.CloudSteps;

public class Tests {

    CloudSteps steps = new CloudSteps();

    @Test
    public void Test() {

        steps.openBrowser();
        steps.openGoogleCloud();
        steps.exploreAllProducts();
        steps.seePricing();
        steps.calculate();
        steps.fillGoogleCloudForm();
        steps.closeBrowser();
    }
}
