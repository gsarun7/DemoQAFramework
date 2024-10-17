package main.uiPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.demoqa.BaseTest;

public class StudentRegistrationFormPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Using @FindBy to locate elements on the page
    @FindBy(xpath = "//div[contains(text(),'Forms')]")
    private WebElement formsSection;

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    private WebElement practiceFormSection;

    @FindBy(xpath = "//input[contains(@id,'firstName')]")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[contains(@id,'lastName')]")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[contains(@id,'userEmail')]")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[contains(@id,'gender-radio-1')]")
    private WebElement genderMaleRadioButton;

    @FindBy(xpath = "//input[contains(@id,'userNumber')]")
    private WebElement mobileNumberTextbox;

    @FindBy(xpath = "//input[contains(@id,'dateOfBirthInput')]")
    private WebElement dobTextbox;

    @FindBy(xpath = "//*[@id=\"subjectsInput\"]")
    private WebElement subjectDropdown;

    @FindBy(xpath = "//input[contains(@id,'hobbies-checkbox-1')]")
    private WebElement hobbiesSportsCheckbox;

    @FindBy(xpath = "//input[contains(@id,'uploadPicture')]")
    private WebElement pictureAttachmentButton;

    @FindBy(xpath = "//textarea[contains(@id,'currentAddress')]")
    private WebElement currentAddressTextArea;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[2]/div")
    private WebElement stateDropdownArrow;

    @FindBy(xpath = "//*[@id=\"react-select-3-input\"]")
    private WebElement stateDropdown;

    @FindBy(xpath = "//*[@id=\"city\"]/div/div[2]/div")
    private WebElement cityDropdownArrow;

    @FindBy(xpath = "//*[@id=\"react-select-4-input\"]")
    private WebElement cityDropdown;

    @FindBy(xpath = "//button[contains(@id,'submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Thanks for submitting the form')]")
    private WebElement ThanksForSubmittingFormText;

    private final String ExpectedTextThanksForSubmit = "Thanks for submitting the form";


    // Constructor to initialize the driver and instantiate elements using PageFactory
    public StudentRegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public StudentRegistrationFormPage() {
    }

    public void clickOnFormsSection() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Forms')]")));
        formsSection.click();
    }

    public void clickOnPracticeFormScetion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Practice Form')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Practice Form')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceFormSection);
        practiceFormSection.click();
    }

    public void fillStudentRegistrationForm() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'firstName')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameTextbox);
        firstNameTextbox.sendKeys(dataReader.getProperty("firstName"));
        lastNameTextbox.sendKeys(dataReader.getProperty("lastName"));
        emailTextbox.sendKeys(dataReader.getProperty("email"));
        if (!genderMaleRadioButton.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderMaleRadioButton);
        }
        mobileNumberTextbox.sendKeys(dataReader.getProperty("mobilenumber"));
        subjectDropdown.click();
        subjectDropdown.sendKeys(dataReader.getProperty("subject"));
        subjectDropdown.sendKeys(Keys.ENTER);
        if (!hobbiesSportsCheckbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesSportsCheckbox);
        }
        pictureAttachmentButton.sendKeys(dataReader.getProperty("attachment"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentAddressTextArea);
        currentAddressTextArea.sendKeys(dataReader.getProperty("currentAddress"));
        stateDropdownArrow.click();
        stateDropdown.sendKeys(dataReader.getProperty("state"));
        stateDropdown.sendKeys(Keys.ENTER);
        cityDropdownArrow.click();
        cityDropdown.sendKeys(dataReader.getProperty("city"));
        cityDropdown.sendKeys(Keys.ENTER);
    }

    public void clickOnSubmitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'submit')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }

    public void validateFormSubmission() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thanks for submitting the form')]")));
        Assert.assertEquals(ThanksForSubmittingFormText.getText(),ExpectedTextThanksForSubmit,"Form submission is failed");
    }


}
