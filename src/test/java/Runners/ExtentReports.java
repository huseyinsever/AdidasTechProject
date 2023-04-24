package Runners;
import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
            tags = "@ParallelTest",
            features = {"src/test/java/FeatureFiles"},
            glue = {"StepDefinitions"}
)
@Listeners({ExtentITestListenerClassAdapter.class})
public class ExtentReports extends AbstractTestNGCucumberTests {

   @BeforeClass
   @Parameters("browser")
    public void beforeClass(String browser){
        GWD.threadBrowserName.set(browser);
   }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("User Name", "Hüseyin SEVER");
        ExtentService.getInstance().setSystemInfo("Application Name", "Adidas Tech Demo Store");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA Team");
        ExtentService.getInstance().setSystemInfo("Uygulamada Gereksinimlere göre tamamlanmasi gereken bölümlerin\n" +
                                                    " UI Testleri yapıldı ve bir sorun olmadığı belirlendi ", "Açıklama");
    }

}


