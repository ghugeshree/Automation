package pages.page_initializer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utility.CommonUtility;

import static utility.CommonUtility.*;

import java.time.Duration;

public class PageInitializer {

    public PageInitializer() {

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)), this);
    }
}
