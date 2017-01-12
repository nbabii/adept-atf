package tests.ie;

import io.appium.java_client.MobileBy;
import ipad.elements.IOSInput;
import org.testng.Reporter;
import org.testng.annotations.Test;

import tests.core.BaseTest;
import utils.PropertyLoader;
import web.pageobjects.pages.LoginPage;


public class IETest extends BaseTest {

	/*@Test (groups = {"all"})
	public void loginPageTest(){
		new LoginPage(webDriver)
				.loadLoginPage()
				.checkIfPageIsAvailable()
				.loginWithValidCredentials(PropertyLoader.loadFrameworkProperty("default.testAccount.username")
						, PropertyLoader.loadFrameworkProperty("default.testAccount.password"));
		}*/

	@Test (groups = {"all"})
	public void iPadTest(){

		//System.out.println(IOSDriver.getPageSource());

		Reporter.log("Entering ID", true);
		new IOSInput(IOSDriver, MobileBy.xpath("//XCUIElementTypeTextField"))
				.sendKeys(PropertyLoader.loadFrameworkProperty("default.test.AdministrationKey"));
		Reporter.log("Click Submit", true);
		IOSDriver.findElement(MobileBy.xpath("//XCUIElementTypeButton[@name='Submit']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}

}
