package driver_maker;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverMaker {
    RemoteWebDriver driver = null;

    abstract void setDriver();

    abstract RemoteWebDriver getDriver();
}
