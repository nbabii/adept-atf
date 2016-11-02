package web.pageuicontrols.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;
import web.pageuicontrols.abstractions.PageControl;

public class WebInput extends PageControl {

	public WebInput(WebDriver driver, String screenName, By locator) {
		super(driver, screenName, locator);		
	}
	
	@Override
	public void sendKeys(CharSequence... arg0) {
		sendKeysStep(super.getAttribute("title"), arg0);
	}
	
	@Step("Sending Keys {1} to input \"{0}\"")
	private void sendKeysStep(String inptName, CharSequence... arg0){
		super.sendKeys(arg0);
	}


}
