import org.testng.annotations.*;
import steps.CloudSteps;
import utils.Form;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tests {

    CloudSteps steps = new CloudSteps();
    Form filledForm;
    Form sourceForm;
    Form estimatedForm;
    String estimatedCostPerMonth;
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

    //Изменить: Лучше тесты собрать в группы, чтобы не проходить эти действия перед каждым тестом.
    //Когда добавил аннотацию BeforeGroups все равно не запускалось - разобраться
    @Test
    public void mainStepsOfScenario()
    {
        steps.openGoogleCloud();
        steps.exploreAllProducts();
        steps.seePricing();
        steps.calculate();
        steps.fillGoogleCloudForm(sourceForm);
        filledForm = steps.getFilledForm();
        estimatedForm = steps.getEstimatedFrom();
        estimatedCostPerMonth = steps.getEstimatedCostPerMonth();

    }

    @Test(groups = "Appropriateness of values", dependsOnMethods ="mainStepsOfScenario")
    public void appropriateValueTest() {
        assertEquals(filledForm.getNumberOfInstances(),sourceForm.getNumberOfInstances());
        assertEquals(filledForm.getOperationSystem(),sourceForm.getOperationSystem());
        assertEquals(filledForm.getVmClass(),sourceForm.getVmClass());
        assertEquals(filledForm.getInstanceType(),sourceForm.getInstanceType());
        assertEquals(filledForm.getNumberOfGPUs(),sourceForm.getNumberOfGPUs());
        assertEquals(filledForm.getGpuType(),sourceForm.getGpuType());
        assertEquals(filledForm.getLocalSSD(),sourceForm.getLocalSSD());
        assertEquals(filledForm.getDatacenterLocation(),sourceForm.getDatacenterLocation());
        assertEquals(filledForm.getCommittedUsage(),sourceForm.getCommittedUsage());

    }

    @Test(groups = "Appropriateness of values", dependsOnMethods = "appropriateValueTest")
    public void appropriateEstimatedValueTest() {
        assertTrue(estimatedForm.getVmClass().toLowerCase().contains(sourceForm.getVmClass().toLowerCase()));
        assertTrue(estimatedForm.getInstanceType().toLowerCase().contains(sourceForm.getInstanceType().toLowerCase().split(" ")[0]));
        assertTrue(estimatedForm.getLocalSSD().toLowerCase().contains(sourceForm.getLocalSSD().toLowerCase()));
        assertTrue(estimatedForm.getDatacenterLocation().toLowerCase().contains(sourceForm.getDatacenterLocation().toLowerCase().split(" ")[0]));
        assertTrue(estimatedForm.getCommittedUsage().toLowerCase().contains(sourceForm.getCommittedUsage().toLowerCase()));
    }

    @Test(groups = "Appropriateness of values", dependsOnMethods = "appropriateEstimatedValueTest" )
    public void mailTest() {
        steps.openLinkInNewTab(MAIL_URL);
        mail = steps.getMail();
        //steps.openTab(TITLE_GOOGLE_CLOUD);
        steps.openGTab();
        steps.emailEstimate(mail);
        steps.openMTab();
        assertTrue(estimatedCostPerMonth.contains(steps.getPriceFromMail("Google Cloud Platform Price Estimate")));
        //steps.openTab(TITLE_MAIL);

    }

    @AfterClass
    public void closeBrowser()
    {
        steps.closeBrowser();
    }

}



