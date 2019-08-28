package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DashboardPage;
import pages.ProfilePage;
import pages.SettingsPage;
import static utility.CommonUtility.*;

public class SDToggleSettings {


    @Then("^I close application$")
    public void iCloseApplication() {
        //driver.closeApp();
    }

    @When("^I click on Profile tab$")
    public void iClickOnProfileTab() {
        (new DashboardPage()).clickProfileButton();
    }

    @And("^I am on setting page$")
    public void iAmOnSettingPage() {
        (new ProfilePage()).goToSettings();
    }

    @When("^I click on toggle button$")
    public void iClickOnToggleButton() {
        SettingsPage obj = new SettingsPage();

        obj.checkIfOnSettingsPage();
        obj.iToggleButton(0);
    }
}
