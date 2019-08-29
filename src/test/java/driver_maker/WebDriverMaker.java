package driver_maker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverMaker extends DriverMaker {

    @Override
    void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/shreyas.ghuge/Documents/Assignments/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://sub-automation.qak8s.vibrenthealth.com/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public RemoteWebDriver getDriver() {
        if(driver == null) {
            setDriver();
        }
        return driver;
    }
}
