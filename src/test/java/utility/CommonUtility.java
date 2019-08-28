package utility;

import driver_maker.IOSDriverMaker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtility {

    public static String email = null;
    public static String password = null;
    public static IOSDriverMaker DriverMakerObject = new IOSDriverMaker();
    public static DriverUtility DriverUtilityObject = new IOSDriverUtility();
    public static RemoteWebDriver driver = DriverMakerObject.getDriver();

    public static void setUser() {
        email = "who11@somewhere.com";
        password = "Qwerty@123";
    }

    public static void explicitWait(RemoteWebElement element) {

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

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point((int)(width * 0.8), (int)(height * 0.9)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point((int)(width * 0.8), (int)(height * 0.2)))
                .release()
                .perform();
    }

    public static void scrollToPress() {

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

    public static boolean isClickable(MobileElement element) {
        return element.getAttribute("value").equals("1");
    }

    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
