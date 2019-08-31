package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.page_initializer.PageInitializer;
import utility.DriverUtility;

import static utility.CommonUtility.*;

/**
 * Created by shreyas.ghuge on 7/29/2019.
 */
public class ConsentPage extends PageInitializer {

    public ConsentPage() {
        super();
    }

    String pageTitle = null;

    @AndroidFindBy(accessibility = "Welcome")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Welcome\"]")
    public RemoteWebElement labelWelcome;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageView']/following::android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "play button")
    public RemoteWebElement buttonPlay;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/button_next")
    @iOSXCUITFindBy(accessibility = "Next")
    public RemoteWebElement buttonNext;

    @AndroidFindBy(id = "com.google.android.youtube:id/bottom_bar_container")
    public RemoteWebElement videoWindow;

    @AndroidFindBy(id = "com.google.android.youtube:id/time_bar")
    public RemoteWebElement seekBar;

    @AndroidFindBy(accessibility = "Yes Option not selected")
    @iOSXCUITFindBy(accessibility = "YesRadio button")
    public RemoteWebElement buttonRadioYes;

    @AndroidFindBy(accessibility = "No Option not selected")
    @iOSXCUITFindBy(accessibility = "NoRadio button")
    public RemoteWebElement buttonRadioNo;

    @AndroidFindBy(xpath = "//*[contains(@text, 'I have read this consent')]")
    @iOSXCUITFindBy(accessibility = "Boolean Selector")
    public RemoteWebElement buttonRadioStatement;

    @AndroidFindBy(accessibility = "Submit")
    @iOSXCUITFindBy(accessibility = "Submit")
    public RemoteWebElement buttonSubmit;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "type your full name")
    public RemoteWebElement inputFieldFullName;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/date_picker_done")
    public RemoteWebElement popUpAnswerDone;

    @AndroidFindBy(xpath = "//*[contains(@text, 'MM')]")
    @iOSXCUITFindBy(accessibility = "[now | dateFormat: 'MM/dd/yyyy']")
    public RemoteWebElement inputFieldDate;

    @AndroidFindBy(xpath = "//*[contains(@text, 'first')]")
    @iOSXCUITFindBy(accessibility = "first name")
    public RemoteWebElement inputFieldFirstName;

    @AndroidFindBy(xpath = "//*[contains(@text, 'middle')]")
    @iOSXCUITFindBy(accessibility = "middle initial")
    public RemoteWebElement inputFieldMiddleName;

    @AndroidFindBy(xpath = "//*[contains(@text, 'last')]")
    @iOSXCUITFindBy(accessibility = "last name")
    public RemoteWebElement inputFieldLastName;

    @AndroidFindBy(xpath = "//*[contains(@text, 'address')]")
    @iOSXCUITFindBy(accessibility = "address 1")
    public RemoteWebElement inputFieldAddress1;

    @AndroidFindBy(xpath = "//*[contains(@text, 'address 2')]")
    @iOSXCUITFindBy(accessibility = "address 2")
    public RemoteWebElement inputFieldAddress2;

    @AndroidFindBy(xpath = "//*[contains(@text, 'city')]")
    @iOSXCUITFindBy(accessibility = "city")
    public RemoteWebElement inputFieldCity;

    @AndroidFindBy(id = "com.acadia.pmistaging:id/spinnerText")
    @iOSXCUITFindBy(accessibility = "state")
    public RemoteWebElement inputFieldState;

    @AndroidFindBy(accessibility = "Alabama")
    public RemoteWebElement inputFieldStateAnswer;

    @AndroidFindBy(xpath = "//*[contains(@text, 'zip')]")
    @iOSXCUITFindBy(accessibility = "zip code")
    public RemoteWebElement inputFieldZipCode;

    @AndroidFindBy(xpath = "//*[contains(@text, 'phone')]")
    @iOSXCUITFindBy(accessibility = "phone number")
    public RemoteWebElement inputFieldPhoneNo;

    //No - .cancel
    //Yes - .ok
    //@AndroidFindBy(id = "com.acadia.pmistaging:id/signup_fields_password_text")
    @iOSXCUITFindBy(accessibility = "notification.page.communication.action.cancel")
    public RemoteWebElement buttonYes;

    //======================================================================================
    public String getLabelWelcomeExpected() {
        return "Welcome";
    }
   //======================================================================================

    public void checkIfOnConsentPage() {
        explicitWait(labelWelcome);

        String expected = getLabelWelcomeExpected();
        String actual = labelWelcome.getText();

        Assert.assertTrue("Primary consent not loaded.", expected.equals(actual));
    }

    public void completePage1(DriverUtility driverUtility) {

        //page 1 - watch video
        pageTitle = "Welcome";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            explicitWait(buttonNext);
            buttonNext.click();
            System.out.println("Page 1 completed.");
        }
    }

    public void completePage2(DriverUtility driverUtility) {
        //page 2 - press next
        pageTitle = "Are you ready?";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 2 completed.");
        }
    }

    public void completePage3(DriverUtility driverUtility) {
        //page 3 - press next
        pageTitle = "Just so you know...";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 3 completed.");
        }
    }

    public void completePage4() {
        //page 4 - press next
        sleep();
        DriverUtilityObject.scrollToPress();
        buttonNext.click();
        System.out.println("Page 4 completed.");
    }

    public void completePage5(DriverUtility driverUtility) {
        //page 5 - where you live? select state and press next
        pageTitle = "Where You Live";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.selectState();
            buttonNext.click();
            System.out.println("Page 5 completed.");
        }
    }

    public void completePage6(DriverUtility driverUtility) {
        //page 6 = Before you begin, Age confirmation, press yes
        pageTitle = "Before We Begin";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonRadioYes.click();
            buttonNext.click();
            System.out.println("Page 6 completed.");
        }
    }

    public void completePage7(DriverUtility driverUtility) {
        //page 7 - where you get healthcare, select healthcare place and press next
        pageTitle = "Where You Get Healthcare";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.selectState();
            buttonNext.click();
            System.out.println("Page 7 completed.");
        }
    }

    public void completePage8(DriverUtility driverUtility) {
        //page 8 - Check understanding, press next
        pageTitle = "Check Your Understanding";
        sleep();
        buttonNext.click();
        System.out.println("Page 8 completed.");
    }

    public void completePage9(DriverUtility driverUtility) {
        //page 9 - What will I do, press next
        pageTitle = "What will I do?";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 9 completed.");
        }
    }

    public void completePage10(DriverUtility driverUtility) {
        //page 10 - Keeping in touch - watch video and next
        pageTitle = "Keeping in Touch";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 10 completed.");
        }
    }

    public void completePage11(DriverUtility driverUtility) {
        //page 11 - Health data - watch video and next
        pageTitle = "Health Data";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 11 completed.");
        }
    }

    public void completePage12(DriverUtility driverUtility) {
        //page 12 - Health Record - watch video and next
        pageTitle = "Health Record";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 12 completed.");
        }
    }

    public void completePage13(DriverUtility driverUtility) {
        //page 13 - Physical Measurement - watch video and next
        pageTitle = "Physical Measurements";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 13 completed.");
        }
    }

    public void completePage14(DriverUtility driverUtility) {
        //page 14 - Samples - watch video and next
        pageTitle = "Samples";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 14 completed.");
        }
    }

    public void completePage15(DriverUtility driverUtility) {
        //page 15 - DNA Analysis - watch video and next
        pageTitle = "DNA Analysis";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 15 completed.");
        }
    }

    public void completePage16(DriverUtility driverUtility) {
        //page 16 - Fitness Tracker - watch video and next
        pageTitle = "Fitness Tracker";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 16 completed.");
        }
    }

    public void completePage17(DriverUtility driverUtility) {
        //page 17 - Other Health data - watch video and next
        pageTitle = "Other Health Data";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 17 completed.");
        }
    }

    public void completePage18(DriverUtility driverUtility) {
        //page 18 - What will we do? , press next
        pageTitle = "What will we do?";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 18 completed.");
        }
    }

    public void completePage19(DriverUtility driverUtility) {
        //page 19 - Data Sharing - watch video and next
        pageTitle = "Data Sharing";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 19 completed.");
        }
    }

    public void completePage20(DriverUtility driverUtility) {
        //page 20 - Potential benefits, press next
        pageTitle = "Potential Benefits";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 20 completed.");
        }
    }

    public void completePage21(DriverUtility driverUtility) {
        //page 21 - Other benefits, press next
        pageTitle = "Other Benefits";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 21 completed.");
        }
    }

    public void completePage22(DriverUtility driverUtility) {
        //page 22 - Risk to privacy - watch video and next
        pageTitle = "Risk To Privacy";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            driverUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 22 completed.");
        }
    }

    public void completePage23(DriverUtility driverUtility) {
        //page 23 - Not medical care, press next
        pageTitle = "Not Medical Care";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 23 completed.");
        }
    }

    public void completePage24(DriverUtility driverUtility) {
        //page 24 - You get to choose, press next
        pageTitle = "You Get To Choose";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {

            buttonNext.click();
            System.out.println("Page 24 completed.");
        }
    }

    public void completePage25(DriverUtility driverUtility) {
        //page 25 - If you withdraw, press next
        pageTitle = "If You Withdraw";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {

            buttonNext.click();
            System.out.println("Page 25 completed.");
        }
    }

    public void completePage26(DriverUtility driverUtility) {
        //page 26 - Think it over, press next
        pageTitle = "Think It Over";
        if(driverUtility.isOnCorrectActivity(pageTitle)) {

            buttonNext.click();
            System.out.println("Page 26 completed.");
        }
    }

    public void completePage27() {
        //page 27 - press next
        sleep();
        buttonNext.click();
        System.out.println("Page 27 completed.");
    }

    public void completePage28() {
        //page 28 - scroll to bottom, press next - to change i < 24 (for Galaxy note 3)
        for(byte i = 0; i < 33; i++)
            scroll();
        buttonNext.click();
        System.out.println("Page 28 completed.");
    }

    public void completePage29() {
        //page 29 - Are you ready? press next
        sleep();
        buttonNext.click();
        System.out.println("Page 29 completed.");
    }

    public void completePage30() {
        //Quiz starts here...
        //page 30 -
        sleep();
        buttonNext.click();
        System.out.println("Page 30 completed.");
    }

    public void completePage31() {
        //page 31 -
        sleep();
        buttonNext.click();
        System.out.println("Page 31 completed.");
    }

    public void completePage32() {
        //page 32 -
        sleep();
        buttonNext.click();
        System.out.println("Page 32 completed.");
    }

    public void completePage33() {
        //page 33 -
        sleep();
        buttonNext.click();
        System.out.println("Page 33 completed.");
    }

    public void completePage34(DriverUtility driverUtility) {
        //page 34 -
        sleep();
        buttonNext.click();
        System.out.println("Page 34 completed.");
    }

    public void completePage35() {
        //page 35 - Statement
        buttonRadioStatement.click();
        buttonNext.click();
        System.out.println("Page 35 completed.");
    }

    public void completePage36(DriverUtility driverUtility) {
        //page 36 - Name, date, scroll
        driverUtility.fillPage36();
        sleep();
        buttonNext.click();
        System.out.println("Page 36 completed.");
    }

    public void completePage37() {
        //page 37 - Click no, press next
        sleep();
        buttonRadioNo.click();
        buttonNext.click();
        System.out.println("Page 37 completed.");
    }

    public void completePage38(DriverUtility driverUtility) {
        //page 38 - Scroll
        driverUtility.fillPage38();
    }

    public void completePage39() {
        //page 39 - Thankyou!
        sleep();
        buttonSubmit.click();
        System.out.println("Page 39 completed.");
    }

    public void completePage40(DriverUtility driverUtility) {
        //page 40 - Get Updates
        driverUtility.fillPage40();
    }

    public void fillPrimaryConsent(DriverUtility driverUtility) {
        completePage1(driverUtility);
        completePage2(driverUtility);
        completePage3(driverUtility);
        completePage4();
        completePage5(driverUtility);
        completePage6(driverUtility);
        completePage7(driverUtility);
        completePage8(driverUtility);
        completePage9(driverUtility);
        completePage10(driverUtility);
        completePage11(driverUtility);
        completePage12(driverUtility);
        completePage13(driverUtility);
        completePage14(driverUtility);
        completePage15(driverUtility);
        completePage16(driverUtility);
        completePage16(driverUtility);
        completePage17(driverUtility);
        completePage18(driverUtility);
        completePage19(driverUtility);
        completePage20(driverUtility);
        completePage21(driverUtility);
        completePage22(driverUtility);
        completePage23(driverUtility);
        completePage24(driverUtility);
        completePage25(driverUtility);
        completePage26(driverUtility);
        completePage27();
        completePage28();
        completePage29();
        completePage30();
        completePage31();
        completePage32();
        completePage33();
        completePage34(driverUtility);
        completePage35();
        completePage36(driverUtility);
        completePage37();
        completePage38(driverUtility);
        completePage39();
        completePage40(driverUtility);
    }



}
