package ipad.screenobjects.abstractions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by nazar.babii on 12/29/2016.
 */
public abstract class AdeptScreen {

    protected IOSDriver<MobileElement> IOSDriver;

    public AdeptScreen(io.appium.java_client.ios.IOSDriver<MobileElement> IOSDriver) {
        this.IOSDriver = IOSDriver;
    }
}
