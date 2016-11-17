package tests.ie;

import org.testng.annotations.Test;

import tests.core.BaseTest;
import utils.PropertyLoader;
import web.pageobjects.pages.LoginPage;


public class IETest extends BaseTest {

	@Test (groups = {"all"})
	public void loginPageTest(){
		new LoginPage(webDriver)
				.loadLoginPage()
				.checkIfPageIsAvailable()
				.loginWithValidCredentials(PropertyLoader.loadFrameworkProperty("default.testAccount.username")
						, PropertyLoader.loadFrameworkProperty("default.testAccount.password"));
		}


}
