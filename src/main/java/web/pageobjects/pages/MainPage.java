package web.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;
import tests.core.ScreenshotHelper;
import web.pageobjects.abstractions.AdeptWebPage;
import web.pageuicontrols.controls.WebButton;

public class MainPage extends AdeptWebPage<MainPage> {

	private WebButton btnLogin = new WebButton(driver, getScreenName(), By.xpath("//li[3]/a"));
	
	public MainPage(WebDriver driver) {
		super(driver);		
	}

	@Override
	public MainPage checkIfPageIsAvailable() {
		btnLogin.isPresent();
		return this;
	}
	
	@Override
	public MainPage makeScreenshot() {
		ScreenshotHelper.makeScreenshot(driver, getScreenName());
		return this;
	}
	
	@Step("Loading - www.nymgo.com")
	public MainPage loadMainPage(){		
		driver.navigate().to("www.nymgo.com");	
		checkIfPageIsAvailable();
		return new MainPage(driver);
	}	 

	public LoginPage navigateToLogin(){
		btnLogin.click();		
		return new LoginPage(driver);
	}

}
