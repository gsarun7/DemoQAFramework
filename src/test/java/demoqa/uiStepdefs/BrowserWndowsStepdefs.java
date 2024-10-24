package test.java.demoqa.uiStepdefs;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.uiPages.BrowserWindowsPage;
import org.testng.annotations.BeforeMethod;
import test.java.demoqa.Hooks;

public class BrowserWndowsStepdefs {

    private BrowserWindowsPage browserWindowsPage;

    @BeforeStep
    public void setup() {
        browserWindowsPage = new BrowserWindowsPage(Hooks.driver,Hooks.wait);
    }






    @And("Click new window button")
    public void clickNewWindowButton() {
        browserWindowsPage.clickOnAlertFrameWindowScetion();
        browserWindowsPage.clickOnBrowserWindowScetion();
        browserWindowsPage.clickOnNewWindowButton();
    }

    @When("User Navigate to new window")
    public void userNavigateToNewWindow() {
        browserWindowsPage.navigateToNewWindow();
    }

    @Then("Verify text in new window")
    public void verifyTextInNewWindow() {
        browserWindowsPage.validateNewWindowText();
    }

    @And("User navigate to original window")
    public void userNavigateToOriginalWindow() {
        browserWindowsPage.navigateBackToParentWindow();
    }
}
