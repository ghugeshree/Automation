package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.page_initializer.PageInitializer;

import static utility.CommonUtility.explicitWait;
import static utility.CommonUtility.scrollToPress;

/**
 * Created by shreyas.ghuge on 7/25/2019.
 */
public class LogInPage extends PageInitializer {
    public LogInPage() {
        super();
    }

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signin_title")
    @iOSXCUITFindBy(accessibility = "signin.title")
    public MobileElement labelSignIn;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signin_action_signin")
    @iOSXCUITFindBy(accessibility = "signin.action.signin")
    public MobileElement buttonSignIn;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signin_action_signup")
    @iOSXCUITFindBy(accessibility = "signin.action.signup")
    public MobileElement linkToRegister;
    public void clickLinkToRegister() {
        linkToRegister.click();
    }

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signin_fields_login_hintText")
    @iOSXCUITFindBy(accessibility = "signin.fields.login.hintText")
    public MobileElement inputFieldEmail;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signin_fields_password")
    @iOSXCUITFindBy(accessibility = "signin.fields.password.hintText")
    public MobileElement inputFieldPassword;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/textinput_error")
    @iOSXCUITFindBy(accessibility = "signin.fields.login.errors.minlength")
    public MobileElement errorMsg;

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

    //======================================================================================
    public void loginWith(String emailAddress, String password) {

        checkIfOnLoginPage();

        inputFieldEmail.clear();
        inputFieldEmail.sendKeys(emailAddress);

        inputFieldPassword.clear();
        inputFieldPassword.sendKeys(password);

        //scroll down to press the sign in button
        scrollToPress();
        buttonSignIn.click();
    }

    public void loginWithInvalidCred(String emailAddress, String password) {

        checkIfOnLoginPage();

        inputFieldEmail.clear();
        inputFieldEmail.sendKeys(emailAddress);

        inputFieldPassword.clear();
        inputFieldPassword.sendKeys(password);
    }

    public void checkIfOnLoginPage() {

        String expected = getLabelSignInExpected();
        String actual = labelSignIn.getText();

        while(true) {
            try {
                explicitWait(labelSignIn);
                if(labelSignIn.isDisplayed())
                    break;
            } catch (NoSuchElementException e) {
                System.out.println("Resetting...");
                //reset app here - require driver object
            }
        }
        Assert.assertEquals("Page not loaded.", expected, actual);
    }

    public void checkIfErrorMsg() {

        String expected = getErrorMsgExpected();
        String actual = errorMsg.getText();

        Assert.assertEquals("Error not displayed.", expected, actual);
    }

}
