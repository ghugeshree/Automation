package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.page_initializer.PageInitializer;

import static utility.CommonUtility.explicitWait;

/**
 * Created by shreyas.ghuge on 8/7/2019.
 */
public class DashboardPage extends PageInitializer {

    public DashboardPage() {
        super();
    }

    @AndroidFindBy(xpath = "//*[contains(@text, \"completed the consent process.\")]")
    @iOSXCUITFindBy(accessibility = "1. Complete Your Surveys")
    public RemoteWebElement textBanner;

    @AndroidFindBy(xpath = "//*[contains(@text, \"PROFILE\")]")
    @iOSXCUITFindBy(accessibility = "PROFILE")
    private RemoteWebElement buttonProfile;
    public void clickProfileButton() {
        buttonProfile.click();
    }

    //==============================================================================
    public void checkIfOnDashboard() {
        explicitWait(textBanner);
    }

}
