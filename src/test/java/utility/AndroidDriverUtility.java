package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ConsentPage;

import java.time.Duration;


//important import
import static utility.CommonUtility.*;

public class AndroidDriverUtility extends DriverUtility {

    @Override
    public void watchVideo() {
        ConsentPage obj = new ConsentPage();
        CommonUtility.explicitWait(obj.buttonPlay);
        System.out.println("Found!");
        obj.buttonPlay.click();

        int toClickX = (int)(driver.manage().window().getSize().width * 0.72);
        int toClickY = (int)(driver.manage().window().getSize().height * 0.653);

        for(int i = 1; i < 5; i++) {
            new TouchAction((PerformsTouchActions) driver).press(PointOption.point(toClickX, toClickY)).release().perform();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.navigate().back();
    }

    @Override
    public void selectState() {
        ConsentPage obj = new ConsentPage();

        obj.inputFieldState.click();
        obj.inputFieldStateAnswer.click();
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scrollToPress();
        obj.inputFieldFirstName.click();
        obj.inputFieldFirstName.sendKeys("John");

        scrollToPress();
        obj.inputFieldMiddleName.click();
        obj.inputFieldMiddleName.sendKeys("T");

        scrollToPress();
        obj.inputFieldLastName.click();
        obj.inputFieldLastName.sendKeys("Doe");

        scrollToPress();
        obj.inputFieldAddress1.click();
        obj.inputFieldAddress1.sendKeys("Wadi");

        scrollToPress();
        obj.inputFieldAddress2.click();
        obj.inputFieldAddress2.sendKeys("Wadi");

        scrollToPress();
        obj.inputFieldCity.click();
        obj.inputFieldCity.sendKeys("Pune");

        selectState();

        scrollToPress();
        obj.inputFieldZipCode.click();
        obj.inputFieldZipCode.sendKeys("12345");

        obj.inputFieldPhoneNo.click();
        obj.inputFieldPhoneNo.sendKeys("9999999999");

        obj.inputFieldDate.click();
        scrollDate();

        obj.buttonNext.click();
        System.out.println("Page 38 completed.");
    }

    @Override
    public void scrollDate() {

        for (int i = 0; i <= 20; i++) {

            new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(820, 770))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(820, 1020))
                    .release()
                    .perform();
        }
    }

    @Override
    public void fillPage36() {
        ConsentPage obj = new ConsentPage();
        obj.inputFieldFullName.sendKeys("John Doe");

        scrollToPress();
    }

    public void fillPage40() {
    }

    public void scrollToPress() {

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
