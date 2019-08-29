package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LogInPage;
import static utility.CommonUtility.*;

/**
 * Created by shreyas.ghuge on 8/1/2019.
 */
public class SDLogin {


    @Given("^I am a registered user$")
    public void i_am_a_registered_user() {
        setUser();
    }

    @When("^I enter my credentials$")
    public void iEnterMyCredentials() {
        LogInPage obj = new LogInPage();
        obj.loginWith(email, password);
    }

    @And("^I am on Log in page$")
    public void iAmOnLogInPage() {
        LogInPage obj = new LogInPage();
        obj.checkIfOnLoginPage();
    }

    @Then("^Error message is displayed$")
    public void errorMessageIsDisplayed() {
        LogInPage obj = new LogInPage();
        obj.checkIfErrorMsg();
    }

    @When("^I enter invalid \"([^\"]*)\" or \"([^\"]*)\"$")
    public void iEnterInvalidCreds(String email, String password) {
        LogInPage obj = new LogInPage();
        obj.loginWithInvalidCred(email, password);
    }

}
