package main.uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.demoqa.BaseTest;
import test.java.demoqa.ISeleniumContext;
import test.java.demoqa.PageObjectBase;
import test.java.demoqa.SeleniumContext;

public class LoginDemoqaPage extends PageObjectBase {

    private WebDriver driver;
    private WebDriverWait wait;
    private final SeleniumContext seleniumContext;



    private final String ExpectedErrorMsgInvalidLogin = "Invalid username or password!";

    // Using @FindBy to locate elements on the page
    @FindBy(xpath = "//input[contains(@id,'userName')]")
    private WebElement userName;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    private WebElement userPassword;

    //@FindBy(xpath = "//button[contains(@id,'login')]")
    //private WebElement loginButton;

    private final By loginButton = By.xpath("//button[contains(@id,'login')]");

    @FindBy(xpath = "//button[contains(@id,'submit')]")
    private WebElement logoutButton;


    @FindBy(xpath = "//p[contains(text(),'Invalid username or password!')]")
    private WebElement invalidUsernamePasswordErrorMsg;

    // Constructor to initialize the driver and instantiate elements using PageFactory
    public LoginDemoqaPage(WebDriver driver, WebDriverWait wait , ISeleniumContext context) {
        super(context);
        seleniumContext = (SeleniumContext) context;
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }




    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'userName')]")));

        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'login')]")));
        //seleniumContext.waitUntilElementClickable(loginButton);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        seleniumContext.scrollToElement(loginButton);
        seleniumContext.click(loginButton);
        //loginButton.click();
    }

    public void validateProfilePageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
        Assert.assertTrue(logoutButton.isDisplayed(),"Login failed");
    }

    public void validateForInvalidUserNameAndPasswordErrorMsgDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(invalidUsernamePasswordErrorMsg));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", invalidUsernamePasswordErrorMsg);
        Assert.assertEquals(invalidUsernamePasswordErrorMsg.getText(),ExpectedErrorMsgInvalidLogin,"Invalid login scenario is failed");
    }

    public void openUrl(){
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
    }
}
