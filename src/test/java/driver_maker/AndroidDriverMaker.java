package driver_maker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverMaker extends DriverMaker{
    AppiumDriver<MobileElement> driver = null;

    @Override
    void setDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();

        /*caps.setCapability("avd", "Nexus_6");
        caps.setCapability("deviceName", "Nexus 6");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability(MobileCapabilityType.APP, "/Users/shreyas.ghuge/Documents/Assignments/pmistaging-release-chewy-latest.apk");
        caps.setCapability("appPackage", "com.acadia.pmistaging");
        caps.setCapability("appActivity", "com.vibrent.features.core.ui.StartActivity");*/

        caps.setCapability("deviceName", "Google Pixel_1");
        caps.setCapability("udid", "192.168.56.102:5555");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8");
        //caps.setCapability(MobileCapabilityType.APP, "/Users/shreyas.ghuge/Documents/Assignments/pmistaging-release-chewy-latest.apk");
        caps.setCapability("appPackage", "com.acadia.pmistaging");
        caps.setCapability("appActivity", "com.vibrent.features.core.ui.StartActivity");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            System.out.println(e.getStackTrace());
        }
        driver = new AppiumDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public AppiumDriver<MobileElement> getDriver() {
        if(driver == null) {
            setDriver();
        }
        return this.driver;
    }
}
