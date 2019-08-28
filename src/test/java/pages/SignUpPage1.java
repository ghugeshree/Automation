package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import pages.page_initializer.PageInitializer;

import static utility.CommonUtility.explicitWait;
import static utility.CommonUtility.scrollToPress;

/**
 * Created by shreyas.ghuge on 7/26/2019.
 */
public class SignUpPage1 extends PageInitializer {

    public String getNewAccount() {
        return "Create a new account";
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'Create a new')]")
    @iOSXCUITFindBy(accessibility = "signup.title")
    public MobileElement labelNewAccount;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_fields_email_hintText")
    @iOSXCUITFindBy(accessibility = "signup.fields.email.hintText")
    public MobileElement inputFieldEmailAddress;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_fields_password_text")
    @iOSXCUITFindBy(accessibility = "signup.fields.password.hintText")
    public MobileElement inputFieldPassword;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_action_button_next")
    @iOSXCUITFindBy(accessibility = "signup.action.button.next")
    public MobileElement buttonContinue;


    @AndroidFindBy(id = "com.acadia.pmistaging:id/textinput_error")
    @iOSXCUITFindBy(id = "com.acadia.pmistaging:id/textinput_error")
    public MobileElement errorMsg;

    //======================================================================================
    public String getEmailErrorMsg() {
        return "Please enter a valid email address";
    }
    //======================================================================================

    public void checkIfOnSignUpPage1() {
        explicitWait(labelNewAccount);

        String expected = getNewAccount();
        String actual = labelNewAccount.getText();

        Assert.assertTrue("Not on sign Up page 1.", expected.equals(actual));
    }

    public void signUpWith(String emailAddress, String password) {

        inputFieldEmailAddress.clear();
        inputFieldEmailAddress.sendKeys(emailAddress);

        inputFieldPassword.clear();
        inputFieldPassword.sendKeys(password);

        //scroll down to press the sign in button
        scrollToPress();
        buttonContinue.click();
    }

}
