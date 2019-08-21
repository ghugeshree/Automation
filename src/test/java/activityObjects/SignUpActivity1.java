package activityObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by shreyas.ghuge on 7/26/2019.
 */
public class SignUpActivity1 {
    private IOSDriver<MobileElement> driver;

    //constructor
    public SignUpActivity1(IOSDriver<MobileElement> driver) {
        this.driver = driver;

    }

    //=============================================//=============================================

    public String getNewAccount() {
        return "Create a new account";
    }

    public MobileElement getLabelNewAccount() {
        return driver.findElementByAccessibilityId("signup.title");
    }

    public MobileElement getInputEmailAddress() {
        return driver.findElementByAccessibilityId("signup.fields.email.hintText");
    }

    public MobileElement getInputPassword() {
        return driver.findElementByAccessibilityId("signup.fields.password.hintText");
    }

    public MobileElement getButtonContinue() {
        return driver.findElementByAccessibilityId("signup.action.button.next");
    }

    public MobileElement getErrorMsg() {
        return driver.findElementById("com.acadia.pmistaging:id/textinput_error");
    }

    public String getErrorMsgId() {
        return "com.acadia.pmistaging:id/textinput_error";
    }

    public String getEmailErrorMsg() {
        return "Please enter a valid email address";
    }


}
