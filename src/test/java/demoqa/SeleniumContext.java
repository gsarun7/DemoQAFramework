package test.java.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SeleniumContext implements ISeleniumContext {


    WebDriver driver;

    private static final long DEFAULT_TIMEOUT_SECONDS = 20;
    private static final long DEFAULT_POLLING_TIMEOUT_IN_MILLISECONDS = 100;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final WebDriver driver) {
        this.driver = driver;
    }


    public void waitUntilElementClickable(final By byLocator, final long timeout, final long pollingTime) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(byLocator));
        } catch (Exception e) {
            Assert.fail("Locator is not clickale, Waited for: " + timeout + " seconds , Locator is : " + byLocator.toString());
        }
    }

    public void waitUntilElementClickable(final By byLocator) {
        this.waitUntilElementClickable(byLocator, DEFAULT_TIMEOUT_SECONDS, DEFAULT_POLLING_TIMEOUT_IN_MILLISECONDS);
    }

    public void click(By locator) {
        this.waitUntilElementClickable(locator, DEFAULT_TIMEOUT_SECONDS, DEFAULT_POLLING_TIMEOUT_IN_MILLISECONDS);
        try {
            this.getDriver().findElement(locator).click();
        } catch (Exception e) {
            System.out.println("click failed");
        }
    }

    public void scrollToElement(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
