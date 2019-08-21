package activityObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by shreyas.ghuge on 7/26/2019.
 */
public class SignUpActivity2 {
    private IOSDriver<MobileElement> driver;


    //constructor
    public SignUpActivity2(IOSDriver<MobileElement> driver) {
        this.driver = driver;

    }
    //=============================================//=============================================

    public MobileElement getLabelInfo() {
        return driver.findElementByAccessibilityId("securityQuestions.header.secondary");
    }

    public String getCheckText() {
        return "Please answer the following security questions. Your answers must have a minimum of 5 characters. No two answers can be the same.";
    }

    public MobileElement getAnswer1() {
        return driver.findElementByAccessibilityId("AnswerOneField");
    }

    public MobileElement getAnswer2() {
        return driver.findElementByAccessibilityId("AnswerTwoField");
    }

    public MobileElement getAnswer3() {
        return driver.findElementByAccessibilityId("AnswerThreeField");
    }

    public MobileElement getButtonSignUp() {
        return driver.findElementByAccessibilityId("securityQuestions.button.next");
    }
}
