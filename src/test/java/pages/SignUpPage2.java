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
public class SignUpPage2 extends PageInitializer {

    public SignUpPage2() {
        super();
    }

    @AndroidFindBy(id = "com.acadia.pmistaging:id/securityQuestions_header_secondary")
    @iOSXCUITFindBy(accessibility = "securityQuestions.header.secondary")
    public MobileElement labelInfo;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question1")
    @iOSXCUITFindBy(accessibility = "AnswerOneField")
    public MobileElement inputFieldAnswer1;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question2")
    @iOSXCUITFindBy(accessibility = "AnswerTwoField")
    public MobileElement inputFieldAnswer2;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/edt_question3")
    @iOSXCUITFindBy(accessibility = "AnswerThreeField")
    public MobileElement inputFieldAnswer3;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/securityQuestions_button_next")
    @iOSXCUITFindBy(accessibility = "securityQuestions.button.next")
    public MobileElement buttonSignUp;

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
        scrollToPress();

        inputFieldAnswer2.sendKeys("ajgvsdhjasvdhb");
        scrollToPress();

        inputFieldAnswer3.sendKeys("ajgvsdhjasvdhc");
        scrollToPress();

        explicitWait(buttonSignUp);
        buttonSignUp.click();
    }


}
