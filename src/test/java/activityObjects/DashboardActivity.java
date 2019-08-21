package activityObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by shreyas.ghuge on 8/7/2019.
 */
public class DashboardActivity {
    private IOSDriver<MobileElement> driver;

    //constructor
    public DashboardActivity(IOSDriver<MobileElement> driver) {
        this.driver = driver;

    }

    //=============================================//=============================================

    public MobileElement getTextBanner() {
        return driver.findElementByAccessibilityId("bannerTextSubviewTextLabel");
    }
}
