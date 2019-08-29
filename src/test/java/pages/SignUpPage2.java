package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.page_initializer.PageInitializer;

import static utility.CommonUtility.DriverUtilityObject;
import static utility.CommonUtility.explicitWait;

/**
 * Created by shreyas.ghuge on 7/26/2019.
 */
public class SignUpPage2 extends PageInitializer {

    public SignUpPage2() {
        super();
    }

    @AndroidFindBy(id = "com.acadia.pmistaging:id/securityQuestions_header_secondary")
    @iOSXCUITFindBy(accessibility = "securityQuestions.header.secondary")
    public RemoteWebElement labelInfo;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question1")
    @iOSXCUITFindBy(accessibility = "AnswerOneField")
    public RemoteWebElement inputFieldAnswer1;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question2")
    @iOSXCUITFindBy(accessibility = "AnswerTwoField")
    public RemoteWebElement inputFieldAnswer2;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question3")
    @iOSXCUITFindBy(accessibility = "AnswerThreeField")
    public RemoteWebElement inputFieldAnswer3;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/securityQuestions_button_next")
    @iOSXCUITFindBy(accessibility = "securityQuestions.button.next")
    public RemoteWebElement buttonSignUp;

    //======================================================================================

    public String getCheckText() {
        return "Please answer the following security questions. Your answers must have a minimum of 5 characters. No two answers can be the same.";
    }

    //======================================================================================

    public void checkIfOnSignUpPage2() {
        String expected = getCheckText();
        String actual = labelInfo.getText();

        Assert.assertTrue("Not on sign Up page 2.", expected.equals(actual));
    }

    public void setSecurityAnswers() {
        inputFieldAnswer1.sendKeys("ajgvsdhjasvdha");
        DriverUtilityObject.scrollToPress(inputFieldAnswer2);

        inputFieldAnswer2.sendKeys("ajgvsdhjasvdhb");
        DriverUtilityObject.scrollToPress(inputFieldAnswer3);

        inputFieldAnswer3.sendKeys("ajgvsdhjasvdhc");
        DriverUtilityObject.scrollToPress(buttonSignUp);

        explicitWait(buttonSignUp);
        buttonSignUp.click();
    }


}
