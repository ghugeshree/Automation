package utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPageElements;
import pages.ConsentPage;

import java.time.Duration;

import static utility.CommonUtility.*;

public class IOSDriverUtility extends DriverUtility {

    @Override
    public void watchVideo() {
        ConsentPage obj = new ConsentPage();
        explicitWait(obj.buttonPlay);
        obj.buttonPlay.click();

        while(true) {
            if(isClickable(obj.buttonNext)) {
                break;
            } else {
                tapOnSkip15();
            }
        }
    }

    @Override
    public void selectState() {
        ConsentPage obj = new ConsentPage();

        obj.inputFieldState.click();

        //select state (190, 730)
        new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(190, 730)).perform();

        //press done (40, 570)
        new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(40, 570)).perform();
    }

    public void tapOnSkip15() {
        (new TouchAction((PerformsTouchActions) driver)).tap(PointOption.point(240, 750)).perform();
    }

    public boolean isOnCorrectActivity(String key) {
        WebDriverWait eWait = new WebDriverWait(driver, 5);
        RemoteWebElement element = (RemoteWebElement) driver.findElementByName(key);

        eWait.until(ExpectedConditions.visibilityOf(element));

        explicitWait(element);

        String actual = element.getText();
        return key.equals(actual);
    }
    public void fillPage38() {
        ConsentPage obj = new ConsentPage();

        obj.inputFieldFirstName.sendKeys("John");

        obj.inputFieldMiddleName.sendKeys("T");

        obj.inputFieldLastName.sendKeys("Doe");

        obj.inputFieldAddress1.sendKeys("Wadi");

        obj.inputFieldAddress2.sendKeys("Wadi");

        obj.inputFieldCity.sendKeys("Pune");

        selectState();

        obj.inputFieldZipCode.sendKeys("12345");

        obj.inputFieldPhoneNo.sendKeys("9999999999");

        obj.inputFieldDate.click();
        scrollDate();

        obj.buttonNext.click();
        System.out.println("Page 38 completed.");
    }

    @Override
    public void scrollDate() {
        for(byte i = 0; i <= 20; i++) {
            new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(280, 665))
                    .perform();
        }

        new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(340, 570)).perform();
    }

    @Override
    public void fillPage36() {
        ConsentPage obj = new ConsentPage();
        obj.inputFieldFullName.sendKeys("John Doe");

        scrollToPress();
        obj.inputFieldDate.click();
    }

    @Override
    public void fillPage40() {
        CommonPageElements obj = new CommonPageElements();
        ConsentPage objConsent = new ConsentPage();

        sleep();
        objConsent.buttonYes.click();

        if(obj.popUpAnswerAllow.isDisplayed())
            obj.popUpAnswerAllow.click();

        System.out.println("Page 40 completed.");
    }

    @Override
    public void scrollToPress(RemoteWebElement... elements) {

        sleep();

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point((int)(width * 0.8), (int)(height * 0.5)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point((int)(width * 0.8), (int)(height * 0.2)))
                .release()
                .perform();

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point((int)(width * 0.8), (int)(height * 0.2)))
                .release()
                .perform();
    }

}


