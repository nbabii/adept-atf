package tests.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//Manger that should provide appropriate driver per request
public class WebDriverManager {

	/* Driver executable paths */
	public static final String IE_DRV_PATH = "src/main/resources/drivers/IEDriverServer.exe";
	
	/* Selenium Grid HUB address */
	public static final String GRID_HUB = "http://localhost:5556/wd/hub";
	
	/* Browsers constants */
	public static final String IE = "ie";
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	
	/* IE Browser versions constants */
	public static final String IE_7 = "7";
	public static final String IE_8 = "8";
	public static final String IE_9 = "9";
	public static final String IE_10 = "10";
	public static final String IE_11 = "11";
	
	//Remote driver
	private RemoteWebDriver webDriver;
	
	public RemoteWebDriver getInstance(String browserName, String browserVersion){		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		
		if (IE.equalsIgnoreCase(browserName)) {
			File ieDrv = new File(IE_DRV_PATH);
			System.setProperty("webdriver.ie.driver",ieDrv.getAbsolutePath());			
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			switch (browserVersion){
				case IE_7:	capabilities.setVersion(IE_7);
							break;
				case IE_8:	capabilities.setVersion(IE_8);
							break;
				case IE_9:	capabilities.setVersion(IE_9);
							break;
				case IE_10:	capabilities.setVersion(IE_10);
							break;
				case IE_11:	capabilities.setVersion(IE_11);
							break;				
				default:	throw new RuntimeException("Invalid browser version provided");										
			}
			try {
				webDriver = new RemoteWebDriver(new URL(GRID_HUB), capabilities);
			} catch (MalformedURLException e) {
				throw new RuntimeException("Got a MalformedURLException during IE 7 driver initialization.");
			}
			
		} else throw new RuntimeException("Invalid browser name provided");
		
		return webDriver;
	}
	
	public void killWebDriverInstance() {
		webDriver.quit();
		webDriver = null;
	}
	
}
