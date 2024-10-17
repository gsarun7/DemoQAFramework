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

import java.util.Set;

public class BrowserWindowsPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Using @FindBy to locate elements on the page
    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement alertsFrameWindowsSection;

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement browserWindowsSection;

    @FindBy(xpath = "(//button[contains(text(),'New Window')])[1]")
    private WebElement newWindowButton;

    @FindBy(xpath = "//h1[contains(text(),'This is a sample page')]")
    private WebElement newWindowPageText;

    String parent = "";

    // Constructor to initialize the driver and instantiate elements using PageFactory
    public BrowserWindowsPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public BrowserWindowsPage() {

    }

    public void clickOnAlertFrameWindowScetion() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]")));
        alertsFrameWindowsSection.click();
    }

    public void clickOnBrowserWindowScetion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Browser Windows')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Browser Windows')]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", browserWindowsSection);
        browserWindowsSection.click();
    }

    public void clickOnNewWindowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'New Window')])[1]")));
        newWindowButton.click();
    }

    public void navigateToNewWindow() {
        // It will return the parent window name as a String
        parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        // Now iterate using Iterator
        for (String child_window : s) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }

    public void validateNewWindowText() {
        wait.until(ExpectedConditions.visibilityOf(newWindowPageText));
        Assert.assertEquals(newWindowPageText.getText(), "This is a sample page");
    }

    public void navigateBackToParentWindow() {
        driver.switchTo().window(parent);
    }
}
