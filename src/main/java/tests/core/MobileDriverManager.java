package tests.core;

import org.openqa.selenium.remote.RemoteWebDriver;

//Manager that should provide appropriate driver per request
public class MobileDriverManager {

	private RemoteWebDriver mobileDriver;
	
	public RemoteWebDriver getInstance(boolean isRealDevice, String platformName, String platformVersion, String deviceName, String deviceUDID, String deviceLanguage){
		
		
		
		return mobileDriver;
	}
	
}
