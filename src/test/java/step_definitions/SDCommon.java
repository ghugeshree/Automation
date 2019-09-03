package step_definitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import pages.ConsentPage;
import pages.DashboardPage;

import java.io.IOException;

import static utility.CommonUtility.captureScreenShots;

/**
 * Created by shreyas.ghuge on 8/1/2019.
 */
public class SDCommon {

    @Before public void before(Scenario scenario) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Scenario : " + scenario.getName());
        System.out.println("--------------------------------------------------------");
    }

    @After
    public void after(Scenario scenario) throws IOException {
        System.out.println("================ Ended scenario : " + scenario.getName() + "================");
        captureScreenShots(scenario);
    }

    @Then("^I am logged in to my account$")
    public void iAmLoggedInToMyAccount() {

        try{
            (new DashboardPage()).checkIfOnDashboard();
        } catch (NoSuchElementException e)  {
            (new ConsentPage()).checkIfOnConsentPage();
        }
    }
}
