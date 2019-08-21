package stepDefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtility extends DriverMaker{

    public void setUser() {
        email = "someone6@some.com";
        password = "Qwerty@123";
    }

    public static void explicitWait(MobileElement element) {

        while(true) {
            if(element.isDisplayed()) {
                break;
            } else {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }

    public static void scroll() {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        new TouchAction(driver)
                .press(PointOption.point((int)(width * 0.8), (int)(height * 0.9)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point((int)(width * 0.8), (int)(height * 0.2)))
                .release()
                .perform();
    }

    public static void scrollDate() {


        for(byte i = 0; i <= 20; i++) {
            tc.tap(PointOption.point(280, 665))
                    .perform();
        }

        tc.tap(PointOption.point(340, 570)).perform();
    }

    public static void scrollToPress() {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        new TouchAction(driver)
                .press(PointOption.point((int)(width * 0.8), (int)(height * 0.5)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point((int)(width * 0.8), (int)(height * 0.2)))
                .release()
                .perform();
    }

    public static void selectFromDropDown() {

        //select state (190, 730)
        new TouchAction(driver).tap(PointOption.point(190, 730)).perform();

        //press done (40, 570)
        new TouchAction(driver).tap(PointOption.point(40, 570)).perform();
    }


    public boolean isOnCorrectActivity(String key) {
        WebDriverWait eWait = new WebDriverWait(driver, 5);
        MobileElement element = driver.findElementByName(key);

        eWait.until(ExpectedConditions.visibilityOf(element));

        explicitWait(element);

        String actual = element.getText();
        return key.equals(actual);
    }

    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
