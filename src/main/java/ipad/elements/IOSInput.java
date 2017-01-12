package ipad.elements;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import ipad.elements.abstractions.IOSElement;
import org.openqa.selenium.By;

/**
 * Created by nazar.babii on 12/29/2016.
 */
public class IOSInput extends IOSElement {

    public IOSInput(IOSDriver<MobileElement> driver, By locator) {

        super(driver, locator);

    }

    public void sendKeys(String keys){

        click();
        new AdeptKeyboard(driver, MobileBy.xpath("//XCUIElementTypeOther")).enterSymbolsSequence(keys);

    }

}
