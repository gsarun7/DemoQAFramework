package test.java.demoqa;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory extends Browser{

    private WebDriver driver;



    public void setupDriverFromBrowserFactory(String browserName, SeleniumContext seleniumContext) {
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
            setSeleniumContext(seleniumContext);
            seleniumContext.setDriver(driver);

        } else if (browserName.equalsIgnoreCase("SAFARI")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
       // log.log(Level.INFO, "Launching browser: " + browserName);
    }



    @Override
    public void start(String browserName) {
        final SeleniumContext seleniumContext = new SeleniumContext();
        setupDriverFromBrowserFactory(browserName, seleniumContext);
    }
}
