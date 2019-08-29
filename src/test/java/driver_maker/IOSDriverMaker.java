package driver_maker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class IOSDriverMaker extends DriverMaker {

    @Override
    void setDriver() {
        {
            DesiredCapabilities caps = new DesiredCapabilities();

            //simulator
            caps.setCapability("deviceName", "IPhone Xs");
            caps.setCapability("udid", "E91F912E-213C-49AE-A2D0-27AB3132ACC7");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("platformVersion", "12.4");
            caps.setCapability("automationName", "XCUITest");
            //caps.setCapability("app", "/Users/shreyas.ghuge/Documents/Assignments/AllOfUsStaging.zip");
            caps.setCapability("bundleId", "com.vibrent.PMIEnterprise");

            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (MalformedURLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }

            driver = new IOSDriver(url, caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public RemoteWebDriver getDriver() {
        if(driver == null) {
            System.out.println("Setting new driver...");
            setDriver();
        }
        return this.driver;
    }
}
