package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.page_initializer.PageInitializer;

public class CommonPageElements extends PageInitializer {

    public CommonPageElements() {
        super();
    }

    @iOSXCUITFindBy(xpath = "//*[@name=\"Allow\"]")
    public RemoteWebElement popUpAnswerAllow;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Don't Allow\"]")
    public RemoteWebElement popUpAnswerDontAllow;

    @iOSXCUITFindBy(accessibility = "Logout")
    public RemoteWebElement popUpAnswerLogout;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "close icon white")
    public RemoteWebElement buttonClose;
}
