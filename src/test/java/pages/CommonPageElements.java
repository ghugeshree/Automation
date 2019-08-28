package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.page_initializer.PageInitializer;

public class CommonPageElements extends PageInitializer {

    public CommonPageElements() {
        super();
    }

    @iOSXCUITFindBy(xpath = "//*[@name=\"Allow\"]")
    public MobileElement popUpAnswerAllow;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Don't Allow\"]")
    public MobileElement popUpAnswerDontAllow;

    @iOSXCUITFindBy(accessibility = "Logout")
    public MobileElement popUpAnswerLogout;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "close icon white")
    public MobileElement buttonClose;
}
