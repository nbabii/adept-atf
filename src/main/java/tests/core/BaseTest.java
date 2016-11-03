package tests.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver webDriver; 
	protected WebDriverManager driverInstance;
	
	@BeforeTest(alwaysRun = true)	
	public void beforeTest(){
		driverInstance = new WebDriverManager();
		webDriver = driverInstance.getInstance("internet explorer", "11.0");
	}
	
	@AfterTest(alwaysRun = true)	
	public void afterTest(){
	driverInstance.killWebDriverInstance();
	}

}
