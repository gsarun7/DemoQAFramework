package test.java.demoqa;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

import main.utils.PropertyFileReader;
import main.utils.SuiteListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {
    public static WebDriver driver;
    public static  WebDriverWait wait;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static PropertyFileReader configReader;
    public static PropertyFileReader dataReader;
    public static PropertyFileReader dataReaderApi;
    public static Logger log;
    public static SeleniumContext seleniumContext;
    protected final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();


    @BeforeTest
    public void beforeTestMethod() {
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

    }


    @BeforeMethod
    public void beforeMethodMethod(Method testMethod) {
        configReader = new PropertyFileReader("src/main/resources/config.properties");
        dataReader = new PropertyFileReader("src/main/resources/testData.properties");
        dataReaderApi = new PropertyFileReader("src/main/resources/userCredApiTestData.properties");
        logger = extent.createTest(testMethod.getName());
        if(configReader.getProperty("testmode").contains("ui")){
            //setupDriver(configReader.getProperty("browser"));
            browserThreadLocal.set(new BrowserFactory());
            browserThreadLocal.get().start(configReader.getProperty("browser"));
            seleniumContext =(SeleniumContext) browserThreadLocal.get().getSeleniumContext();
            seleniumContext.getDriver().navigate().to("https://demoqa.com/books");
            driver = seleniumContext.getDriver();
            //driver.navigate().to("https://demoqa.com/books");
            //driver.getTitle();
            //driver.manage().window().maximize();
            seleniumContext.getDriver().manage().window().maximize();

            wait = new WebDriverWait(driver,30);
            log.log(Level.INFO, "Navigating to " + configReader.getProperty("baseUrl"));

        }

    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText;
        if (result.getStatus() == ITestResult.SUCCESS) {
            logText = "Test Case: " + methodName + " PASSED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.SKIP) {
            logText = "Test Case: " + methodName + " SKIPPED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
            logger.log(Status.SKIP, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logText = "Test Case: " + methodName + " FAILED";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            SuiteListener suiteListener = new SuiteListener();
            suiteListener.onTestFailure(result);
            logger.log(Status.FAIL, m);


        }
        if(configReader.getProperty("testmode").contains("ui")) {
            driver.quit();
        }

    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    public void setupDriver(String browserName) {
        if (browserName.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("CHROME")) {
            //WebDriverManager.chromedriver().setup();
            System.out.println("Launching the chrome driver  ");
            // Set the chrome driver exe file path
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Log ON\\IdeaProjects\\TestAutomationParker\\src\\test\\java\\demoqa\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-browser-side-navigation");

            // Instantiate the chrome driver
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("SAFARI")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        log.log(Level.INFO, "Launching browser: " + browserName);
    }

    public void openURL() {
        configReader = new PropertyFileReader("src/main/resources/config.properties");
        dataReader = new PropertyFileReader("src/main/resources/testData.properties");
        dataReaderApi = new PropertyFileReader("src/main/resources/userCredApiTestData.properties");
        //logger = extent.createTest(testMethod.getName());
        if(configReader.getProperty("testmode").contains("ui")){
            //setupDriver(configReader.getProperty("browser"));
            browserThreadLocal.set(new BrowserFactory());
            browserThreadLocal.get().start(configReader.getProperty("browser"));
            seleniumContext =(SeleniumContext) browserThreadLocal.get().getSeleniumContext();
            seleniumContext.getDriver().navigate().to("https://demoqa.com/books");
            driver = seleniumContext.getDriver();
            //driver.navigate().to("https://demoqa.com/books");
            //driver.getTitle();
            //driver.manage().window().maximize();
            seleniumContext.getDriver().manage().window().maximize();

            wait = new WebDriverWait(driver,30);
            log.log(Level.INFO, "Navigating to " + configReader.getProperty("baseUrl"));

        }

    }

}