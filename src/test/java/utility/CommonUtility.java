package utility;

import cucumber.api.Scenario;
import driver_maker.WebDriverMaker;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonUtility {

    public static String email = null;
    public static String password = null;
    public static WebDriverMaker DriverMakerObject = new WebDriverMaker();
    public static DriverUtility DriverUtilityObject = new WebDriverUtility();
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

    public static boolean isClickable(RemoteWebElement element) {
        return element.getAttribute("value").equals("1");
    }

    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void captureScreenShots(Scenario scenario) throws IOException {
        String folder_name = "/Users/shreyas.ghuge/Documents/Assignments/Automation/target";
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Date format fot screenshot file name __hh_mm_ssaa
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy@hh:mm");

        //create dir with given folder name
        new File(folder_name).mkdir();

        //Setting file name
        String file_name = scenario.getId().split(";")[0] + "_" + df.format(new Date()) + ".png";

        //copy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
