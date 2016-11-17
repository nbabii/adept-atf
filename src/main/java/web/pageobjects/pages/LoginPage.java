package web.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;
import utils.PropertyLoader;
import web.pageobjects.abstractions.AdeptWebPage;
import web.pageuicontrols.controls.WebButton;
import web.pageuicontrols.controls.WebInput;

//Login page pageobject
public class LoginPage extends AdeptWebPage<LoginPage> {	

	private WebInput inptUsername = new WebInput(driver, getPageName(), By.xpath("//*[@id='username']"));
	private WebInput inptPassword = new WebInput(driver, getPageName(), By.xpath("//*[@id='inputPassword']"));

	private WebButton btnLogin = new WebButton(driver, getPageName(), By.xpath("//input[contains(@class, 'buttonSubmit')]"));

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LoginPage checkIfPageIsAvailable() {
		inptUsername.checkElementPresence();
		inptPassword.checkElementPresence();
		btnLogin.checkElementPresence();
		return this;
	}

	@Step("Opening dev-adept login local page")
	public LoginPage loadLoginPage(){
		driver.navigate().to(PropertyLoader.loadFrameworkProperty("dev.server.login_local.url"));
		return new LoginPage(driver);
	}

	public RecordsSummaryPage loginWithValidCredentials(String username, String password){
		inptUsername.sendKeys(username);
		inptPassword.sendKeys(password);
		btnLogin.click();
		return new RecordsSummaryPage(driver);
	}

}
