package tests.ie;

import org.testng.annotations.Test;

import tests.core.BaseTest;
import web.pageobjects.pages.MainPage;


public class IETest extends BaseTest {

	@Test (groups = {"all"})
	public void loadingMainPageTest(){
		new MainPage(webDriver)
		.loadMainPage()
		.navigateToLogin();
		}
	
	@Test (groups = {"all1"})
	public void loadingMainSecondPageTest(){
		new MainPage(webDriver)
		.loadMainPage()
		.navigateToLogin()
		.loginWithValidCredentials("pack1test", "123456789");
		}
	
}
