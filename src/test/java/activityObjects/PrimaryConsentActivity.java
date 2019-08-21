package activityObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import stepDefinitions.CommonUtility;

import static stepDefinitions.DriverMaker.tc;

/**
 * Created by shreyas.ghuge on 7/29/2019.
 */
public class PrimaryConsentActivity {
    private IOSDriver<MobileElement> driver;

    //=============================================

    //constructor
    public PrimaryConsentActivity(IOSDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //=============================================

    public MobileElement getLabelWelcome() {

        return driver.findElementByXPath("//*[@name=\"Welcome\"]");
    }

    public MobileElement getButtonClose() {

        return driver.findElementByAccessibilityId("Close");
    }

    public MobileElement getButtonPlay() {
        return driver.findElementByAccessibilityId("play button");
    }

    public MobileElement getNext() {
        return driver.findElementByAccessibilityId("Next");
    }

    public MobileElement getRadioButton(String key) {
        return driver.findElementByAccessibilityId(key);
    }

    public MobileElement getButtonSubmit() {
        return driver.findElementByAccessibilityId("Submit");
    }

    public MobileElement getInputFieldFullName() {
        return driver.findElementByAccessibilityId("type your full name");
    }

    public MobileElement getInputFieldDate() { return driver.findElementByAccessibilityId("[now | dateFormat: 'MM/dd/yyyy']"); }

    public MobileElement getInputFieldFirstName() { return driver.findElementByAccessibilityId("first name"); }

    public MobileElement getInputFieldMiddleName() { return driver.findElementByAccessibilityId("middle name"); }

    public MobileElement getInputFieldLastName() { return driver.findElementByAccessibilityId("last name"); }

    public MobileElement getInputFieldAddress1() { return driver.findElementByAccessibilityId("address 1"); }

    public MobileElement getInputFieldAddress2() { return driver.findElementByAccessibilityId("address 2"); }

    public MobileElement getInputFieldCity() { return driver.findElementByAccessibilityId("city"); }

    public MobileElement getInputFieldState() { return driver.findElementByAccessibilityId("state"); }

    public MobileElement getInputFieldZipCode() { return driver.findElementByAccessibilityId("zip code"); }

    public MobileElement getInputFieldPhoneNo() { return driver.findElementByAccessibilityId("phone number"); }

    public MobileElement getButtonYes() {
        //No - .cancel
        //Yes - .ok
        return driver.findElementByAccessibilityId("notification.page.communication.action.cancel"); //or .ok
    }

    public String getLabelWelcomeExpected() {
        return "Welcome";
    }

    public void watchVideo() {

        //click on play button
        CommonUtility.explicitWait(getButtonPlay());
        CommonUtility.sleep();
        getButtonPlay().click();

        //loop for skipping the video by 15 seconds
        while(true) {
            if(isClickable(getNext())) {
                break;
            } else {
                tapOnSkip15();
            }
        }
    }

    public void tapOnSkip15() {
        tc.tap(PointOption.point(240, 750)).perform();
    }

    public boolean isClickable(MobileElement element) {
        return element.getAttribute("value").equals("1");
    }

}
