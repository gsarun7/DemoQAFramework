package test.java.demoqa.uiTests;

import main.uiPages.BrowserWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.demoqa.BaseTest;

public class BrowserWindowsTest extends BaseTest {

    private BrowserWindowsPage browserWindowsPage;

    @BeforeMethod
    public void setup() {
        browserWindowsPage = new BrowserWindowsPage(driver,wait);
    }

    @Test
    public void verifyPageNavigation() {
        browserWindowsPage.clickOnAlertFrameWindowScetion();
        browserWindowsPage.clickOnBrowserWindowScetion();
        browserWindowsPage.clickOnNewWindowButton();
        browserWindowsPage.navigateToNewWindow();
        browserWindowsPage.validateNewWindowText();
        browserWindowsPage.navigateBackToParentWindow();
    }

}
