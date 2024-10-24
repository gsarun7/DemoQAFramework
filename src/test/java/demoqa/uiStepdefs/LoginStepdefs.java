package test.java.demoqa.uiStepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.uiPages.LoginDemoqaPage;
import org.testng.annotations.BeforeMethod;
import test.java.demoqa.BaseTest;
import test.java.demoqa.Hooks;

import static test.java.demoqa.BaseTest.*;

public class LoginStepdefs  {



    private  LoginDemoqaPage loginDemoqaPage;
    @BeforeStep
    public void setup() {
        loginDemoqaPage = new LoginDemoqaPage(Hooks.driver,Hooks.wait,Hooks.seleniumContext);
    }


    @And("click login")
    public void clickLogin() {
        loginDemoqaPage.clickLoginButton();
    }

    @When("enter user name {string}")
    public void enterUserName(String userName) {
        loginDemoqaPage.enterUsername(userName);
    }

    @And("enter password {string}")
    public void enterPassword(String password) {
        loginDemoqaPage.enterPassword(password);
    }



    @Then("User navigate to profile page")
    public void userNavigateToProfilePage() {
        loginDemoqaPage.validateProfilePageDisplayed();
    }


    @Given("Open URl")
    public void openURl() {
        loginDemoqaPage.openUrl();
    }

    @Then("User gets error message stating invalid username or password")
    public void userGetsErrorMessageStatingInvalidUsernameOrPassword() {
        loginDemoqaPage.validateForInvalidUserNameAndPasswordErrorMsgDisplayed();
    }



}
