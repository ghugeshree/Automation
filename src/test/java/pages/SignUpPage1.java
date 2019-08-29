package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//div[@data-target=\"signup.title\"]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Create a new')]")
    @iOSXCUITFindBy(accessibility = "signup.title")
    public RemoteWebElement labelNewAccount;

    @FindBy(xpath = "//input[@id='signUpEmail']")
    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_fields_email_hintText")
    @iOSXCUITFindBy(accessibility = "signup.fields.email.hintText")
    public RemoteWebElement inputFieldEmailAddress;

    @FindBy(xpath = "//input[@id='signUpPassword']")
    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_fields_password_text")
    @iOSXCUITFindBy(accessibility = "signup.fields.password.hintText")
    public RemoteWebElement inputFieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    @AndroidFindBy(id = "com.acadia.pmistaging:id/signup_action_button_next")
    @iOSXCUITFindBy(accessibility = "signup.action.button.next")
    public RemoteWebElement buttonContinue;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/textinput_error")
    @iOSXCUITFindBy(id = "com.acadia.pmistaging:id/textinput_error")
    public RemoteWebElement errorMsg;

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
