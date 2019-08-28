package driver_maker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMaker extends DriverMaker {
    WebDriver driver = null;

    @Override
    void setDriver() {
        String projectPath =
        System.setProperty("webdriver.chrome.driver", "/Users/shreyas.ghuge/Documents/Assignments/chromedriver");
        driver = new ChromeDriver();
    }

    WebDriver getDriver() {
        if(driver == null) {
            setDriver();
        }
        return driver;
    }
}
