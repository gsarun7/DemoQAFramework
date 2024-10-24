package test.java.demoqa.uiTests;

import main.uiPages.StudentRegistrationFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.demoqa.BaseTest;

public class StudentRegistrationFormTest extends BaseTest {

    private StudentRegistrationFormPage studentRegistrationFormPage;

    @BeforeMethod
    public void setup() {
        studentRegistrationFormPage = new StudentRegistrationFormPage(driver,wait);
    }

    @Test
    public void verifyFormStudentFormSubmission() {
        studentRegistrationFormPage.clickOnFormsSection();
        studentRegistrationFormPage.clickOnPracticeFormScetion();
       // studentRegistrationFormPage.fillStudentRegistrationForm();
        studentRegistrationFormPage.clickOnSubmitForm();
        studentRegistrationFormPage.validateFormSubmission();
    }
}
