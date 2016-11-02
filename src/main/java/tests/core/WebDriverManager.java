package tests.core;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//Manger that should provide appropriate driver per request
public class WebDriverManager {

	private RemoteWebDriver webDriver;
	
	public RemoteWebDriver getInstance(String browserName, String browserVersion){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		
		
		return webDriver;
	}
	
}
