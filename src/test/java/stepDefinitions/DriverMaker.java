package stepDefinitions;

import activityObjects.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by shreyas.ghuge on 7/31/2019.
 */
public class DriverMaker {
    static IOSDriver<MobileElement> driver = null;
    LogInActivity logInActivityObject = null;
    SignUpActivity1 signUpActivity1 = null;
    SignUpActivity2 signUpActivity2 = null;
    PrimaryConsentActivity primaryConsentObject = null;
    DashboardActivity dashboardActivityObject = null;

    DriverMaker() {
        driver = getDriver();
        logInActivityObject = new LogInActivity(driver);
        signUpActivity1 = new SignUpActivity1(driver);
        signUpActivity2 = new SignUpActivity2(driver);
        primaryConsentObject = new PrimaryConsentActivity(driver);
        dashboardActivityObject = new DashboardActivity(driver);
    }


    public IOSDriver getDriver() {

        if(driver == null) {
            setDriver();
        }
        return driver;
    }

    public void setDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();

        //simulator
        caps.setCapability("deviceName", "IPhone Xs");
        caps.setCapability("udid", "E91F912E-213C-49AE-A2D0-27AB3132ACC7");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "12.4");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "/Users/shreyas.ghuge/Documents/Assignments/AllOfUsStaging.zip");


        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            System.out.println(e.getStackTrace());
        }

        driver = new IOSDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public static void explicitWait(MobileElement element) {
        byte i = 1;
        WebDriverWait wait = new WebDriverWait(driver, 2);

        while(true) {
            System.out.println("Try " + (i++));
            if(element.isDisplayed()) {
                System.out.println("Found element => " + element);
                break;
            } else {
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

        TouchAction tc = new TouchAction(driver);

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
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
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

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
