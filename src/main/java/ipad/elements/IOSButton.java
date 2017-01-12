package ipad.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import ipad.elements.abstractions.IOSElement;
import org.openqa.selenium.By;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by nazar.babii on 1/12/2017.
 */
public class IOSButton extends IOSElement {

    public IOSButton(IOSDriver<MobileElement> driver, By locator) {
        super(driver, locator);
    }



}
