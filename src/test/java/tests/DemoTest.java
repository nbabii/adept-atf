package tests;

import io.appium.java_client.MobileBy;
import ipad.elements.IOSInput;
import org.testng.Reporter;
import org.testng.annotations.Test;

import tests.core.BaseTest;
import utils.PropertyLoader;
import web.pageobjects.pages.LoginPage;


public class DemoTest extends BaseTest {

	/*@Test (groups = {"demo"})
	public void loginPageTest(){
		new LoginPage(webDriver)
				.loadLoginPage()
				.checkIfPageIsAvailable()
				.loginWithValidCredentials(PropertyLoader.loadFrameworkProperty("default.testAccount.username")
						, PropertyLoader.loadFrameworkProperty("default.testAccount.password"));
		}*/

	@Test (groups = {"demo"})
	public void iPadTest(){

		//Use System.out.println(IOSDriver.getPageSource()) to get page source amd find locators

		Reporter.log("Entering ID", true);
		new IOSInput(IOSDriver, MobileBy.xpath("//XCUIElementTypeTextField"))
				.sendKeys(PropertyLoader.loadFrameworkProperty("default.test.AdministrationKey"));
		Reporter.log("Click Submit", true);
		IOSDriver.findElement(MobileBy.xpath("//XCUIElementTypeButton[@name='Submit']")).click();


	}

}
