package web.pageuicontrols.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;
import web.pageuicontrols.abstractions.PageControl;

public class WebButton extends PageControl {
	
	public WebButton (WebDriver driver, String screenName, By locator){
		super(driver, screenName, locator);		
	}

	@Override	
	public void click() {
		clickStep(super.getText());
	}
	
	@Step("Click on button \"{0}\"")
	private void clickStep(String btnName){
		super.click();	
	}


	
}
