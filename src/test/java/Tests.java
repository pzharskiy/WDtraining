import org.testng.annotations.Test;
import steps.Steps;

public class Tests {

    Steps step = new Steps();

    @Test
    public void Test() {
        step.openBrowser();
        step.createNewPaste("coding yooooo", "10", "title yoaaa");
        step.closeBrowser();
    }
}
