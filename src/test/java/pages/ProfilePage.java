package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.page_initializer.PageInitializer;

public class ProfilePage extends PageInitializer {
    public ProfilePage() {
        super();
    }

    @AndroidFindBy(id = "com.acadia.pmistaging:id/action_settings")
    @iOSXCUITFindBy(accessibility = "navigation.links.settings")
    public MobileElement buttonSetting;

    public void goToSettings() {
        buttonSetting.click();
    }


}
