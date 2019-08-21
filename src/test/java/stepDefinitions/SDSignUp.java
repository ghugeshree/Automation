package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class SDSignUp extends CommonUtility {
    @Given("^I am on Sign Up activity$")
    public void iAmOnSignUpActivity() {

        logInActivityObject.getLinkToRegister().click();

        explicitWait(signUpActivity1.getLabelNewAccount());

        String expected = signUpActivity1.getNewAccount();
        String actual = signUpActivity1.getLabelNewAccount().getText();

        Assert.assertTrue("Not on sign Up page 1.", expected.equals(actual));

    }

    @When("^I fill all Sign up fields$")
    public void iFillAllSignUpFields() {
        setUser();
        explicitWait(signUpActivity1.getInputEmailAddress());
        signUpActivity1.getInputEmailAddress().sendKeys(email);

        signUpActivity1.getInputPassword().sendKeys(password);

        signUpActivity1.getInputEmailAddress().click();

        //to hide the keyboard
        signUpActivity1.getInputEmailAddress().sendKeys(Keys.RETURN);

        signUpActivity1.getButtonContinue().click();

        explicitWait(signUpActivity2.getLabelInfo());

        String expected = signUpActivity2.getCheckText();
        String actual = signUpActivity2.getLabelInfo().getText();

        Assert.assertTrue("Not on sign Up page 2.", expected.equals(actual));

        signUpActivity2.getAnswer1().sendKeys("ajgvsdhjasvdh");
        signUpActivity2.getAnswer1().sendKeys(Keys.RETURN);

        signUpActivity2.getAnswer2().sendKeys("ajgvsdhfjasvdh");
        signUpActivity2.getAnswer2().sendKeys(Keys.RETURN);

        signUpActivity2.getAnswer3().sendKeys("ajgvsdhjfsasvdh");

        explicitWait(signUpActivity2.getButtonSignUp());
        signUpActivity2.getButtonSignUp().click();
    }

    @Then("^I am registered$")
    public void iAmRegistered() {
        explicitWait(primaryConsentObject.getLabelWelcome());

        String expected = primaryConsentObject.getLabelWelcomeExpected();
        String actual = primaryConsentObject.getLabelWelcome().getText();

        Assert.assertTrue("Primary consent not loaded.", expected.equals(actual));

    }
}
