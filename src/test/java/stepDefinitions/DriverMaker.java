package stepDefinitions;

import activityObjects.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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

    static String email = null;
    static String password = null;

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


}
