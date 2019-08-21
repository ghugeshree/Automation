package activityObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by shreyas.ghuge on 7/25/2019.
 */
public class LogInActivity {
    private IOSDriver<MobileElement> driver = null;

    //constructor
    public LogInActivity(IOSDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //=============================================//=============================================

    public MobileElement getLabelSignIn() {
        return driver.findElementByAccessibilityId("signin.title");
    }

    public MobileElement getLabelEmailAddress() {
        return driver.findElementByAccessibilityId("signin.fields.email.label");
    }

    public MobileElement getLabelPassword() {
        return driver.findElementById("com.acadia.pmistaging:id/signin_fields_password_label");
    }

    public MobileElement getButtonSignIn() {
        return driver.findElementByAccessibilityId("signin.action.signin");
    }

    public MobileElement getLinkToRegister() {
        return driver.findElementByAccessibilityId("signin.action.signup");
    }

    public MobileElement getTextTerms() {
        return driver.findElementById("com.acadia.pmistaging:id/signup_text_termsDataPolicy");
    }

    public MobileElement getEmailField() {
        return driver.findElementByAccessibilityId("signin.fields.login.hintText");
    }

    public MobileElement getPasswordField() {
        return driver.findElementByAccessibilityId("signin.fields.password.hintText");
    }

    public MobileElement getErrorMsg() {
        return driver.findElementByAccessibilityId("signin.fields.login.errors.minlength");
    }

    //==========================================================================================

    public String getLabelSignInExpected() {
        return "Sign in";
    }

    public String getLabelEmailAddressExpected() {
        return "Email Address";
    }

    public String getLabelPasswordExpected() {
        return "Password";
    }

    public String getErrorMsgExpected() {
        return "Please enter a valid email address";
    }

    public String getTextTermPolicy() {
        return "Your security is important to us. We use technology to encrypt, safeguard, and secure your personal information. Please view our privacy policy for more information. By clicking Sign Up, you agree to our Terms and that you have read our Data Policy.";
    }

}
