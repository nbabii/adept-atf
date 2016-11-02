package tests.core;

import org.openqa.selenium.remote.RemoteWebDriver;

//Manger that should provide appropriate driver per request
public class MobileDriverManager {

	private RemoteWebDriver mobileDriver;
	
	public RemoteWebDriver getInstance(String deviceOSName, String deviceOSversion, String deviceName, String deviceUDID ){
		
		
		
		return mobileDriver;
	}
	
}
