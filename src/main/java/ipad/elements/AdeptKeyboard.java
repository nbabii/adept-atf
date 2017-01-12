package ipad.elements;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import ipad.elements.abstractions.IOSElement;
import ipad.screenobjects.abstractions.AdeptScreen;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nazar.babii on 12/29/2016.
 */
public class AdeptKeyboard extends IOSElement {



    private IOSButton btnSwitchToNumbers = new IOSButton(driver, MobileBy.xpath("//XCUIElementTypeButton[@name='123']"));
    private IOSButton btnSwitchToChars;
    private IOSButton btnHideKeyboard = new IOSButton(driver, MobileBy.xpath("//XCUIElementTypeButton[@name='ic keyboard down']"));

    public AdeptKeyboard(IOSDriver<MobileElement> driver, By locator) {
        super(driver, locator);
    }

    public void enterSymbolsSequence (String sequence){

        LinkedList<String> symbolsList = getSymbolsList(sequence);

        for(String symbol : symbolsList){

            if(StringUtils.isNumeric(symbol)){

                btnSwitchToNumbers.click();
                if(btnSwitchToChars == null)
                    btnSwitchToChars = new IOSButton(driver, MobileBy.xpath("//XCUIElementTypeButton[@name='ABC']"));
                new IOSButton(driver, MobileBy.xpath("//XCUIElementTypeButton[@name='" + symbol.toLowerCase() + "']")).click();
                btnSwitchToChars.click();

            } else {

                new IOSButton(driver, MobileBy.xpath("//XCUIElementTypeButton[@name='" + symbol.toLowerCase() + "']")).click();

            }

        }

        btnHideKeyboard.click();

    }

    private LinkedList<String> getSymbolsList(String secuence) {

        return new LinkedList<>(Arrays.asList(secuence.split("")));

    }

    }
