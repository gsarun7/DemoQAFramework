package test.java.demoqa.uiTests;

import main.uiPages.LoginDemoqaPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.demoqa.BaseTest;

public class LoginPageTests extends BaseTest {



    private LoginDemoqaPage loginDemoqaPage;

    @BeforeMethod
    public void setup() {
        loginDemoqaPage = new LoginDemoqaPage(driver,wait,seleniumContext);
    }

    @Test
    public void verifyValidLoginScenario() {
        loginDemoqaPage.clickLoginButton();
        loginDemoqaPage.enterUsername(dataReader.getProperty("userName"));
        loginDemoqaPage.enterPassword(dataReader.getProperty("userPassword"));
        loginDemoqaPage.clickLoginButton();
        loginDemoqaPage.validateProfilePageDisplayed();
    }

    @Test
    public void verifyInvalidLoginScenario() {
        loginDemoqaPage.clickLoginButton();
        loginDemoqaPage.enterUsername(dataReader.getProperty("userName"));
        loginDemoqaPage.enterPassword("Test@12");
        loginDemoqaPage.clickLoginButton();
        loginDemoqaPage.validateForInvalidUserNameAndPasswordErrorMsgDisplayed();
    }
}
