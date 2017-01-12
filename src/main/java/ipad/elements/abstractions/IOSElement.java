package ipad.elements.abstractions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by nazar.babii on 12/29/2016.
 */
public abstract class IOSElement {

    protected By locator;
    protected MobileElement element;

    protected IOSDriver<MobileElement> driver;

    public IOSElement(IOSDriver<MobileElement> driver, By locator) {

        this.driver = driver;
        this.locator = locator;
        this.element =  driver.findElement(locator);

    }

    public void click(){

        clickStep(element.getAttribute("label"));

    }

    @Step("Click on \"{0}\"")
    private void clickStep(String btnName){

        Reporter.log("Clicking on " + btnName + " <br>", true);
        element.click();
        Reporter.log("Clicked on " + btnName + " <br>", true);

    }
}
