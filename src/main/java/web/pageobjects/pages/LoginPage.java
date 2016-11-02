package web.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.core.ScreenshotHelper;
import web.pageobjects.abstractions.AdeptWebPage;
import web.pageuicontrols.controls.WebButton;
import web.pageuicontrols.controls.WebInput;

//Login page pageobject
public class LoginPage extends AdeptWebPage<LoginPage> {	
	
	private WebButton btnLogin = new WebButton(driver, getScreenName(), By.xpath("//*[@id='user-login-el']"));
	
	private WebInput inptUsername = new WebInput(driver, getScreenName(), By.xpath("//*[@id='username-el']"));
	private WebInput inptPassword = new WebInput(driver, getScreenName(), By.xpath("//*[@id='Password-el']"));
	
	protected LoginPage(WebDriver driver) {
		super(driver);
		checkIfPageIsAvailable();
	}

	@Override
	public LoginPage checkIfPageIsAvailable() {
		inptUsername.isPresent();
		inptPassword.isPresent();
		btnLogin.isPresent();
		return this;
	}

	@Override
	public LoginPage makeScreenshot() {
		ScreenshotHelper.makeScreenshot(driver, getScreenName());
		return this;
	}
	
	public MyAccountPage loginWithValidCredentials(String username, String password){
		inptUsername.sendKeys(username);
		inptPassword.sendKeys(password);
		btnLogin.click();
		return new MyAccountPage(driver);
	}
	
}
