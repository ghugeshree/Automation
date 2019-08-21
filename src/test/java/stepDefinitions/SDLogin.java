package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by shreyas.ghuge on 8/1/2019.
 */
public class SDLogin extends CommonUtility {



    @Given("^I am a registered user$")
    public void i_am_a_registered_user() {
        setUser();
    }

    @When("^I enter my credentials$")
    public void iEnterMyCredentials() {

        explicitWait(logInActivityObject.getLabelSignIn());

        logInActivityObject.getEmailField().sendKeys(email);

        logInActivityObject.getPasswordField().sendKeys(password);

        //scroll down to press the sign in button
        scrollToPress();

        logInActivityObject.getButtonSignIn().click();
    }

    @And("^I am on Log in page$")
    public void iAmOnLogInPage() {
        String expected = logInActivityObject.getLabelSignInExpected();
        String actual = logInActivityObject.getLabelSignIn().getText();

        Assert.assertEquals("Page not loaded.", expected, actual);
    }


    @Then("^Error message is displayed$")
    public void errorMessageIsDisplayed() {

        String expected = logInActivityObject.getErrorMsgExpected();
        String actual = logInActivityObject.getErrorMsg().getText();

        Assert.assertEquals("Error not displayed.", expected, actual);


    }

    @When("^I enter invalid \"([^\"]*)\" or \"([^\"]*)\"$")
    public void iEnterInvalidCreds(String email, String password) {
        logInActivityObject.getEmailField().clear();
        logInActivityObject.getEmailField().sendKeys(email);

        logInActivityObject.getPasswordField().clear();
        logInActivityObject.getPasswordField().sendKeys(password);
    }

}
