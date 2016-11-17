package web.pageobjects.abstractions;

import org.openqa.selenium.WebDriver;
import tests.core.ScreenshotHelper;
import web.pageobjects.pages.LoginPage;

//Main abstract pageobject
public abstract class AdeptWebPage<S extends AdeptWebPage<S>> {

	protected WebDriver driver;	
	
	public abstract S checkIfPageIsAvailable();
	
	protected AdeptWebPage (WebDriver driver){
		this.driver = driver;
	}


	public S makeScreenshot() {
		ScreenshotHelper.makeScreenshot(driver, getPageName());
		return (S) this;
	}

	protected String getPageName(){
		return this.getClass().getSimpleName();
	}
}
