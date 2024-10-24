package test.java.demoqa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import main.utils.PropertyFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.lang.reflect.Method;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static PropertyFileReader configReader;
    public static PropertyFileReader dataReader;
    public static PropertyFileReader dataReaderApi;
    public static Logger log;
    public static SeleniumContext seleniumContext;
    protected final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();



   /* public void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.setSystemInfo("Automation Tester", "Arun");
        extent.attachReporter(htmlReporter);
        log = LogManager.getLogger(this.getClass());
        seleniumContext = new SeleniumContext();

    }*/


    @Before
    public void before_MethodMethod() {
        configReader = new PropertyFileReader("src/main/resources/config.properties");
        dataReader = new PropertyFileReader("src/main/resources/testData.properties");
        dataReaderApi = new PropertyFileReader("src/main/resources/userCredApiTestData.properties");
       // logger = extent.createTest(testMethod.getName());
        if(configReader.getProperty("testmode").contains("ui")){
            //setupDriver(configReader.getProperty("browser"));
            browserThreadLocal.set(new BrowserFactory());
            browserThreadLocal.get().start(configReader.getProperty("browser"));
            seleniumContext =(SeleniumContext) browserThreadLocal.get().getSeleniumContext();
            //seleniumContext.getDriver().navigate().to("https://demoqa.com/books");
            driver = seleniumContext.getDriver();
            //driver.navigate().to("https://demoqa.com/books");
            //driver.getTitle();
            //driver.manage().window().maximize();
            //seleniumContext.getDriver().manage().window().maximize();

            wait = new WebDriverWait(driver,30);
//            log.log(Level.INFO, "Navigating to " + configReader.getProperty("baseUrl"));

        }

    }

}
