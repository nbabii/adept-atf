package web.pageobjects.pages;

import org.openqa.selenium.WebDriver;

import web.pageobjects.abstractions.AdeptWebPage;

public class MyAccountPage extends AdeptWebPage<MyAccountPage> {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyAccountPage makeScreenshot() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public MyAccountPage checkIfPageIsAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

}
