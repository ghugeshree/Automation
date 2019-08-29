package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import static utility.CommonUtility.*;

public class WebDriverUtility extends DriverUtility {

    @Override
    public void watchVideo() {

    }

    @Override
    public void selectState() {

    }

    @Override
    public boolean isOnCorrectActivity(String key) {
        return false;
    }

    @Override
    public void fillPage38() {

    }

    @Override
    public void scrollDate() {

    }

    @Override
    public void fillPage36() {

    }

    @Override
    public void fillPage40() {

    }

    @Override
    public void scrollToPress(RemoteWebElement... elements) {
        RemoteWebElement element = elements[0];
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
