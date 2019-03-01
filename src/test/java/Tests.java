import org.testng.annotations.Test;
import steps.CloudSteps;
import utils.Form;

public class Tests {

    CloudSteps steps = new CloudSteps();
    Form blankedForm;
    Form estimatedForm = new Form();
    private final String NUMBER_OF_INSTANCE = "4";
    private final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";

    @Test
    public void appropriateValueTest() {

        steps.openBrowser();
        steps.openGoogleCloud();
        steps.exploreAllProducts();
        steps.seePricing();
        steps.calculate();
        steps.fillGoogleCloudForm();
        steps.closeBrowser();
        blankedForm = steps.getBlankedForm();
        System.out.println(blankedForm.getLocalSSD());
    }


}
