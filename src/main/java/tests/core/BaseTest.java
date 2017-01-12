package tests.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropertyLoader;

public class BaseTest {

	protected MobileDriverManager mobileDriverManager;
	protected WebDriverManager webDriverManager;

	protected IOSDriver<MobileElement> IOSDriver;
	protected WebDriver webDriver;

	
	@BeforeTest(alwaysRun = true)	
	public void beforeTest(){
		//webDriverManager = new WebDriverManager();
		//webDriver = webDriverManager.getInstance("internet explorer", "11.0");

		mobileDriverManager = new MobileDriverManager();
		IOSDriver = (IOSDriver<MobileElement>) mobileDriverManager.initialiseDriver("yes", "iOS", "10.1"
				, PropertyLoader.loadFrameworkProperty("nymgo.ipad.black.name")
				, PropertyLoader.loadFrameworkProperty("nymgo.ipad.black.udid")
				, "EN");

	}
	
	@AfterTest(alwaysRun = true)	
	public void afterTest(){
		mobileDriverManager.killDriver();
	}



}
