package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.ConsentPage;
import pages.LogInPage;
import pages.SignUpPage1;
import pages.SignUpPage2;
import static utility.CommonUtility.*;

public class SDSignUp {
    @Given("^I am on Sign Up activity$")
    public void iAmOnSignUpActivity() {
        SignUpPage1 obj = new SignUpPage1();
        LogInPage objLogin = new LogInPage();

        objLogin.checkIfOnLoginPage();
        objLogin.clickLinkToRegister();
        obj.checkIfOnSignUpPage1();
    }

    @When("^I fill all Sign up fields$")
    public void iFillAllSignUpFields() {
        SignUpPage1 objPage1 = new SignUpPage1();
        SignUpPage2 objPage2 = new SignUpPage2();
        setUser();

        //fill sign up page 1
        objPage1.signUpWith(email, password);

        //fill sign up page 2
        objPage2.setSecurityAnswers();
    }

    @Then("^I am registered$")
    public void iAmRegistered() {
        ConsentPage obj = new ConsentPage();
        obj.checkIfOnConsentPage();
    }
}
