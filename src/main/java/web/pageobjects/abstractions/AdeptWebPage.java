package web.pageobjects.abstractions;

import org.openqa.selenium.WebDriver;

//Main abstract pageobject
public abstract class AdeptWebPage<S extends AdeptWebPage<S>> {

	protected WebDriver driver;	
	
	public abstract S makeScreenshot();	
	public abstract S checkIfPageIsAvailable();
	
	protected AdeptWebPage (WebDriver driver){
		this.driver = driver;
	}
	
	protected String getScreenName(){
		return this.getClass().getSimpleName();
	}
}
