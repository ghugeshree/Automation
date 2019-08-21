package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class SDPrimaryConsent extends CommonUtility{
    String email = null;
    String password = null;
    MobileElement nextElement = primaryConsentObject.getNext();

    @When("^I submit primary consent$")
    public void i_submit_primary_consent() {
        String pageTitle = null;

        //page 1 - watch video
        pageTitle = "Welcome";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            explicitWait(primaryConsentObject.getNext());
            primaryConsentObject.getNext().click();
            System.out.println("Page 1 completed.");
        }

        //page 2 - press next
        pageTitle = "Are you ready?";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 2 completed.");
        }

        //page 3 - press next
        pageTitle = "Just so you know...";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 3 completed.");
        }


        //page 4 - You're about to make history, press next
        scrollToPress();
        primaryConsentObject.getNext().click();
        System.out.println("Page 4 completed.");


        //page 5 - where you live? select state and press next
        pageTitle = "Where You Live";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getInputFieldState().click();
            selectFromDropDown();
            primaryConsentObject.getNext().click();
            System.out.println("Page 5 completed.");
        }

        //page 6 = Before you begin, Age confirmation, press yes
        pageTitle = "Before We Begin";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getRadioButton("YesRadio button").click();
            primaryConsentObject.getNext().click();
            System.out.println("Page 6 completed.");
        }


        //page 7 - where you get healthcare, select healthcare place and press next
        pageTitle = "Where You Get Healthcare";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getInputFieldState().click();
            selectFromDropDown();
            primaryConsentObject.getNext().click();
            System.out.println("Page 7 completed.");
        }

        //page 8 - Check understanding, press next
        pageTitle = "Check Your Understanding";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 8 completed.");
        }

        //page 9 - What will I do, press next
        pageTitle = "What will I do?";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 9 completed.");
        }

        //page 10 - Keeping in touch - watch video and next
        pageTitle = "Keeping in Touch";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 10 completed.");
        }

        //page 11 - Health data - watch video and next
        pageTitle = "Health Data";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 11 completed.");
        }

        //page 12 - Health Record - watch video and next
        pageTitle = "Health Record";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 12 completed.");
        }

        //page 13 - Physical Measurement - watch video and next
        pageTitle = "Physical Measurements";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 13 completed.");
        }

        //page 14 - Samples - watch video and next
        pageTitle = "Samples";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 14 completed.");
        }

        //page 15 - DNA Analysis - watch video and next
        pageTitle = "DNA Analysis";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 15 completed.");
        }

        //page 16 - Fitness Tracker - watch video and next
        pageTitle = "Fitness Tracker";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 16 completed.");
        }

        //page 17 - Other Health data - watch video and next
        pageTitle = "Other Health Data";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 17 completed.");
        }

        //page 18 - What will we do? , press next
        pageTitle = "What will we do?";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 18 completed.");
        }


        //page 19 - Data Sharing - watch video and next
        pageTitle = "Data Sharing";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 19 completed.");
        }

        //page 20 - Potential benefits, press next
        pageTitle = "Potential Benefits";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 20 completed.");
        }

        //page 21 - Other benefits, press next
        pageTitle = "Other Benefits";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 21 completed.");
        }

        //page 22 - Risk to privacy - watch video and next
        pageTitle = "Risk To Privacy";
        if(isOnCorrectActivity(pageTitle)) {

            primaryConsentObject.watchVideo();
            primaryConsentObject.getNext().click();
            System.out.println("Page 22 completed.");
        }

        //page 23 - Not medical care, press next
        pageTitle = "Not Medical Care";
        if(isOnCorrectActivity(pageTitle)) {
            primaryConsentObject.getNext().click();
            System.out.println("Page 23 completed.");
        }

        //page 24 - You get to choose, press next
        pageTitle = "You Get To Choose";
        if(isOnCorrectActivity(pageTitle)) {

            primaryConsentObject.getNext().click();
            System.out.println("Page 24 completed.");
        }

        //page 25 - If you withdraw, press next
        pageTitle = "If You Withdraw";
        if(isOnCorrectActivity(pageTitle)) {

            primaryConsentObject.getNext().click();
            System.out.println("Page 25 completed.");
        }

        //page 26 - Think it over, press next
        pageTitle = "Think It Over";
        if(isOnCorrectActivity(pageTitle)) {

            primaryConsentObject.getNext().click();
            System.out.println("Page 26 completed.");
        }

        //page 27 - press next
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 27 completed.");

        //page 28 - scroll to bottom, press next - to change i < 24 (for Galaxy note 3)
        for(byte i = 0; i < 20; i++)
            scroll();
        primaryConsentObject.getNext().click();
        System.out.println("Page 28 completed.");

        //page 29 - Are you ready? press next
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 29 completed.");

        //Quiz starts here...
        //page 30 -
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 30 completed.");

        //page 31 -
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 31 completed.");

        //page 32 -
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 32 completed.");

        //page 33 -
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 33 completed.");

        //page 34 -
        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 34 completed.");

        //page 35 - Statement
        primaryConsentObject.getRadioButton("Boolean Selector").click();
        primaryConsentObject.getNext().click();
        System.out.println("Page 35 completed.");

        //page 36 - Name, date, scroll
        primaryConsentObject.getInputFieldFullName().sendKeys("John Doe");

        scrollToPress();
        primaryConsentObject.getInputFieldDate().click();

        sleep();
        primaryConsentObject.getNext().click();
        System.out.println("Page 36 completed.");

        //page 37 - Click no, press next
        primaryConsentObject.getRadioButton("NoRadio button").click();
        primaryConsentObject.getNext().click();
        System.out.println("Page 37 completed.");

        //page 38 - Scroll
        primaryConsentObject.getInputFieldFirstName().sendKeys("John");
        primaryConsentObject.getInputFieldMiddleName().sendKeys("T");
        primaryConsentObject.getInputFieldLastName().sendKeys("Doe");
        primaryConsentObject.getInputFieldAddress1().sendKeys("Wadi");
        primaryConsentObject.getInputFieldAddress2().sendKeys("Wadi");
        primaryConsentObject.getInputFieldCity().sendKeys("Pune");

        //this is a dropdown
        primaryConsentObject.getInputFieldState().click();
        selectFromDropDown();
        primaryConsentObject.getInputFieldZipCode().sendKeys("12345");

        scrollToPress();
        primaryConsentObject.getInputFieldPhoneNo().sendKeys("9999999999");
        driver.findElementByAccessibilityId("MM/DD/YYYY").click();

        //go back 20 years
        scrollDate();
        primaryConsentObject.getNext().click();
        System.out.println("Page 38 completed.");

        //page 39 - Thankyou!
        sleep();
        primaryConsentObject.getButtonSubmit().click();
        System.out.println("Page 39 completed.");

        //page 40 - Get Updates
        sleep();
        primaryConsentObject.getButtonYes().click();
        System.out.println("Page 40 completed.");
    }

    @Then("^I am able to see my dashboard$")
    public void i_am_able_to_see_my_dashboard() {

        //check if user lands on his dashboard
        explicitWait(dashboardActivityObject.getTextBanner());
        sleep();
        if(dashboardActivityObject.getTextBanner().isDisplayed())
            System.out.println("On dashboard");
    }


}
