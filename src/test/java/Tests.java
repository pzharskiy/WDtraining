import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.CloudSteps;
import utils.Form;

import static org.testng.Assert.assertEquals;

public class Tests {

    CloudSteps steps = new CloudSteps();
    Form filledForm;
    Form sourceForm;
    Form estimatedForm;
    private final String NUMBER_OF_INSTANCE = "4";
    private final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final String VM_CLASS = "Regular";
    private final String INSTANCE_TYPE = "n1-standard-8    (vCPUs: 8, RAM: 30 GB)";
    private final String NUMBER_OF_GPUS = "1";
    private final String GPU_TYPE = "NVIDIA Tesla V100";
    private final String LOCAL_SSD = "2x375 GB";
    private final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private final String COMMITED_USAGE = "1 Year";
    private String mail;
    private final String TITLE_GOOGLE_CLOUD = "Google Cloud Platform Pricing Calculator  |  Google Cloud Platform  |  Google Cloud";
    private final String TITLE_MAIL = "10 Minute Mail  - Временная почта";
    private final String MAIL_URL = "https://10minutemail.com";


    @BeforeClass
    public void initBrowser()
    {
        steps.openBrowser();
    }

    @BeforeTest
    public void initSourceForm()
    {
        sourceForm=new Form();
        sourceForm.setNumberOfInstances(NUMBER_OF_INSTANCE);
        sourceForm.setOperationSystem(OPERATION_SYSTEM);
        sourceForm.setVmClass(VM_CLASS);
        sourceForm.setInstanceType(INSTANCE_TYPE);
        sourceForm.setNumberOfGPUs(NUMBER_OF_GPUS);
        sourceForm.setGpuType(GPU_TYPE);
        sourceForm.setLocalSSD(LOCAL_SSD);
        sourceForm.setDatacenterLocation(DATACENTER_LOCATION);
        sourceForm.setCommittedUsage(COMMITED_USAGE);

    }
    @Test
    public void appropriateValueTest() {
        steps.openGoogleCloud();
        steps.exploreAllProducts();
        steps.seePricing();
        steps.calculate();
        steps.fillGoogleCloudForm(sourceForm);
        filledForm = steps.getFilledForm();
        filledForm.showForm();
        steps.openLinkInNewTab(MAIL_URL);
        mail = steps.getMail();
        steps.openTab(TITLE_GOOGLE_CLOUD);
        //steps.emailEstimate(mail);
        steps.openTab(TITLE_MAIL);
    }



    @AfterClass
    public void closeBrowser()
    {
        steps.closeBrowser();
    }

}


        /* filledForm = steps.getFilledForm();
        System.out.println(filledForm.getNumberOfInstances());
        assertEquals(filledForm.getNumberOfInstances(),sourceForm.getNumberOfInstances());
        assertEquals(filledForm.getOperationSystem(),sourceForm.getOperationSystem());
        assertEquals(filledForm.getVmClass(),sourceForm.getVmClass());
        assertEquals(filledForm.getInstanceType(),sourceForm.getInstanceType());
        assertEquals(filledForm.getNumberOfGPUs(),sourceForm.getNumberOfGPUs());
        assertEquals(filledForm.getGpuType(),sourceForm.getGpuType());
        assertEquals(filledForm.getLocalSSD(),sourceForm.getLocalSSD());
        assertEquals(filledForm.getDatacenterLocation(),sourceForm.getDatacenterLocation());
        assertEquals(filledForm.getCommittedUsage(),sourceForm.getCommittedUsage());*/


