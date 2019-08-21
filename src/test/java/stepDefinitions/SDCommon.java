package stepDefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by shreyas.ghuge on 8/1/2019.
 */
public class SDCommon extends DriverMaker {

    @Before public void before(Scenario scenario) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Scenario : " + scenario.getName());
        System.out.println("--------------------------------------------------------");
    }

    @After public void after(Scenario scenario) {
        System.out.println("================ Ended scenario : " + scenario.getName() + "================");
    }

    @Then("^I am logged in to my account$")
    public void iAmLoggedInToMyAccount() {

        //wait until page is loaded
        explicitWait(primaryConsentObject.getLabelWelcome());

        String expected = primaryConsentObject.getLabelWelcomeExpected();
        String actual = primaryConsentObject.getLabelWelcome().getText();

        Assert.assertEquals("Not on primary consent", expected, actual);
    }
}
