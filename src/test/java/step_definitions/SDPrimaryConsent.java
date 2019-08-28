package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CommonPageElements;
import pages.ConsentPage;
import pages.DashboardPage;

import static utility.CommonUtility.*;

public class SDPrimaryConsent {

    @When("^I submit primary consent$")
    public void i_submit_primary_consent() {
        ConsentPage obj = new ConsentPage();

        System.out.println("in SDPC, Value of DriverUtility=>" + DriverUtilityObject);
        obj.fillPrimaryConsent(DriverUtilityObject);
    }

    @Then("^I am on dashboard$")
    public void i_am_able_to_see_my_dashboard() {
        DashboardPage obj = new DashboardPage();
        obj.checkIfOnDashboard();
    }

    @And("^I logout from my account before submitting consent$")
    public void iLogoutFromMyAccountBeforeSubmittingConsent() {
        CommonPageElements obj = new CommonPageElements();
        obj.buttonClose.click();
        obj.popUpAnswerLogout.click();
    }

}
