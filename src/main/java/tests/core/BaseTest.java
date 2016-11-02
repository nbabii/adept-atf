package tests.core;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected RemoteWebDriver webDriver; 
	protected WebDriverManager driverInstance;
	
	@BeforeSuite(alwaysRun = true)	
	public void beforeTest(){
		driverInstance = new WebDriverManager();
		webDriver = driverInstance.getInstance("ie", "11");
	}
	
	@AfterSuite(alwaysRun = true)	
	public void afterTest(){
		driverInstance.killWebDriverInstance();
	System.setProperty("allure.results.directory", "path/to/directory");
	}

}
