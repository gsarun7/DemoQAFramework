package test.java.demoqa.uiStepdefs;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.uiPages.StudentRegistrationFormPage;
import org.testng.annotations.BeforeMethod;
import test.java.demoqa.Hooks;

public class StudentRegistrationStepdefs {

    private StudentRegistrationFormPage studentRegistrationFormPage;

    @BeforeStep
    public void setup() {
        studentRegistrationFormPage = new StudentRegistrationFormPage(Hooks.driver,Hooks.wait);
    }






    @And("Click on Form section")
    public void clickOnFormSection() {
        studentRegistrationFormPage.clickOnFormsSection();
    }

    @And("Click on Practice from section")
    public void clickOnPracticeFromSection() {
        studentRegistrationFormPage.clickOnPracticeFormScetion();
    }

    @And("Fill Student form registration with data {string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void fillStudentFormRegistrationWithData2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        studentRegistrationFormPage.fillStudentRegistrationForm(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    }

    @When("Click on submit button")
    public void clickOnSubmitButton() {
        studentRegistrationFormPage.clickOnSubmitForm();
    }

    @Then("Validate submit form")
    public void validateSubmitForm() {
        studentRegistrationFormPage.validateFormSubmission();
    }

}
