package tests.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;
	
	
	
	@BeforeSuite(alwaysRun = true)	
	public void beforeTest(){
		File ieDrv = new File("src/main/resources/drivers/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver",ieDrv.getAbsolutePath());
		driver = new InternetExplorerDriver();		
	}
	
	@AfterSuite(alwaysRun = true)	
	public void afterTest(){
		driver.close();
		driver.quit();
	System.setProperty("allure.results.directory", "path/to/directory");
	}
	
}
