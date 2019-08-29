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

    public void completePage1(DriverUtility driverMakerUtility) {

        //page 1 - watch video
        pageTitle = "Welcome";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            explicitWait(buttonNext);
            buttonNext.click();
            System.out.println("Page 1 completed.");
        }
    }

    public void completePage2(DriverUtility driverMakerUtility) {
        //page 2 - press next
        pageTitle = "Are you ready?";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 2 completed.");
        }
    }

    public void completePage3(DriverUtility driverMakerUtility) {
        //page 3 - press next
        pageTitle = "Just so you know...";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
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

    public void completePage5(DriverUtility driverMakerUtility) {
        //page 5 - where you live? select state and press next
        pageTitle = "Where You Live";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.selectState();
            buttonNext.click();
            System.out.println("Page 5 completed.");
        }
    }

    public void completePage6(DriverUtility driverMakerUtility) {
        //page 6 = Before you begin, Age confirmation, press yes
        pageTitle = "Before We Begin";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonRadioYes.click();
            buttonNext.click();
            System.out.println("Page 6 completed.");
        }
    }

    public void completePage7(DriverUtility driverMakerUtility) {
        //page 7 - where you get healthcare, select healthcare place and press next
        pageTitle = "Where You Get Healthcare";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.selectState();
            buttonNext.click();
            System.out.println("Page 7 completed.");
        }
    }

    public void completePage8(DriverUtility driverMakerUtility) {
        //page 8 - Check understanding, press next
        pageTitle = "Check Your Understanding";
        sleep();
        buttonNext.click();
        System.out.println("Page 8 completed.");
    }

    public void completePage9(DriverUtility driverMakerUtility) {
        //page 9 - What will I do, press next
        pageTitle = "What will I do?";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 9 completed.");
        }
    }

    public void completePage10(DriverUtility driverMakerUtility) {
        //page 10 - Keeping in touch - watch video and next
        pageTitle = "Keeping in Touch";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 10 completed.");
        }
    }

    public void completePage11(DriverUtility driverMakerUtility) {
        //page 11 - Health data - watch video and next
        pageTitle = "Health Data";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 11 completed.");
        }
    }

    public void completePage12(DriverUtility driverMakerUtility) {
        //page 12 - Health Record - watch video and next
        pageTitle = "Health Record";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 12 completed.");
        }
    }

    public void completePage13(DriverUtility driverMakerUtility) {
        //page 13 - Physical Measurement - watch video and next
        pageTitle = "Physical Measurements";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 13 completed.");
        }
    }

    public void completePage14(DriverUtility driverMakerUtility) {
        //page 14 - Samples - watch video and next
        pageTitle = "Samples";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 14 completed.");
        }
    }

    public void completePage15(DriverUtility driverMakerUtility) {
        //page 15 - DNA Analysis - watch video and next
        pageTitle = "DNA Analysis";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 15 completed.");
        }
    }

    public void completePage16(DriverUtility driverMakerUtility) {
        //page 16 - Fitness Tracker - watch video and next
        pageTitle = "Fitness Tracker";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 16 completed.");
        }
    }

    public void completePage17(DriverUtility driverMakerUtility) {
        //page 17 - Other Health data - watch video and next
        pageTitle = "Other Health Data";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 17 completed.");
        }
    }

    public void completePage18(DriverUtility driverMakerUtility) {
        //page 18 - What will we do? , press next
        pageTitle = "What will we do?";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 18 completed.");
        }
    }

    public void completePage19(DriverUtility driverMakerUtility) {
        //page 19 - Data Sharing - watch video and next
        pageTitle = "Data Sharing";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 19 completed.");
        }
    }

    public void completePage20(DriverUtility driverMakerUtility) {
        //page 20 - Potential benefits, press next
        pageTitle = "Potential Benefits";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 20 completed.");
        }
    }

    public void completePage21(DriverUtility driverMakerUtility) {
        //page 21 - Other benefits, press next
        pageTitle = "Other Benefits";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 21 completed.");
        }
    }

    public void completePage22(DriverUtility driverMakerUtility) {
        //page 22 - Risk to privacy - watch video and next
        pageTitle = "Risk To Privacy";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            driverMakerUtility.watchVideo();
            buttonNext.click();
            System.out.println("Page 22 completed.");
        }
    }

    public void completePage23(DriverUtility driverMakerUtility) {
        //page 23 - Not medical care, press next
        pageTitle = "Not Medical Care";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {
            buttonNext.click();
            System.out.println("Page 23 completed.");
        }
    }

    public void completePage24(DriverUtility driverMakerUtility) {
        //page 24 - You get to choose, press next
        pageTitle = "You Get To Choose";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {

            buttonNext.click();
            System.out.println("Page 24 completed.");
        }
    }

    public void completePage25(DriverUtility driverMakerUtility) {
        //page 25 - If you withdraw, press next
        pageTitle = "If You Withdraw";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {

            buttonNext.click();
            System.out.println("Page 25 completed.");
        }
    }

    public void completePage26(DriverUtility driverMakerUtility) {
        //page 26 - Think it over, press next
        pageTitle = "Think It Over";
        if(driverMakerUtility.isOnCorrectActivity(pageTitle)) {

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

    public void completePage34(DriverUtility driverMakerUtility) {
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

    public void completePage36(DriverUtility driverMakerUtility) {
        //page 36 - Name, date, scroll
        driverMakerUtility.fillPage36();
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

    public void completePage38(DriverUtility driverMakerUtility) {
        //page 38 - Scroll
        driverMakerUtility.fillPage38();
    }

    public void completePage39() {
        //page 39 - Thankyou!
        sleep();
        buttonSubmit.click();
        System.out.println("Page 39 completed.");
    }

    public void completePage40(DriverUtility driverMakerUtility) {
        //page 40 - Get Updates
        driverMakerUtility.fillPage40();
    }

    public void fillPrimaryConsent(DriverUtility driverMakerUtility) {
        completePage1(driverMakerUtility);
        completePage2(driverMakerUtility);
        completePage3(driverMakerUtility);
        completePage4();
        completePage5(driverMakerUtility);
        completePage6(driverMakerUtility);
        completePage7(driverMakerUtility);
        completePage8(driverMakerUtility);
        completePage9(driverMakerUtility);
        completePage10(driverMakerUtility);
        completePage11(driverMakerUtility);
        completePage12(driverMakerUtility);
        completePage13(driverMakerUtility);
        completePage14(driverMakerUtility);
        completePage15(driverMakerUtility);
        completePage16(driverMakerUtility);
        completePage16(driverMakerUtility);
        completePage17(driverMakerUtility);
        completePage18(driverMakerUtility);
        completePage19(driverMakerUtility);
        completePage20(driverMakerUtility);
        completePage21(driverMakerUtility);
        completePage22(driverMakerUtility);
        completePage23(driverMakerUtility);
        completePage24(driverMakerUtility);
        completePage25(driverMakerUtility);
        completePage26(driverMakerUtility);
        completePage27();
        completePage28();
        completePage29();
        completePage30();
        completePage31();
        completePage32();
        completePage33();
        completePage34(driverMakerUtility);
        completePage35();
        completePage36(driverMakerUtility);
        completePage37();
        completePage38(driverMakerUtility);
        completePage39();
        completePage40(driverMakerUtility);
    }



}
