package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.page_initializer.PageInitializer;

import java.util.List;

import static utility.CommonUtility.explicitWait;

public class SettingsPage extends PageInitializer {
    public SettingsPage() {
        super();
    }

    @AndroidFindBy(className = "android.widget.Switch")
    @iOSXCUITFindBy(className = "XCUIElementTypeSwitch")
    public List<RemoteWebElement> buttonToggles;

    public void checkIfOnSettingsPage() {
        explicitWait(buttonToggles.get(0));
    }

    public void iToggleButton(int index) {
        buttonToggles.get(0).click();
    }
}
