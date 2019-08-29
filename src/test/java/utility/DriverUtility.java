package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * Created by shreyas.ghuge on 7/31/2019.
 */
public abstract class DriverUtility {

    public abstract void watchVideo();

    public abstract void selectState();

    public abstract boolean isOnCorrectActivity(String key);

    public abstract void fillPage38();

    public abstract void scrollDate();

    public abstract void fillPage36();

    public abstract void fillPage40();

    public abstract void scrollToPress(RemoteWebElement... elements);
}
