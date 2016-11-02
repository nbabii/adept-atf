package web.pageuicontrols.abstractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public abstract class PageControl implements WebElement {

	protected WebDriver driver;
	protected By locator;
	protected String screenName = "";
	
	protected PageControl (WebDriver driver, String screenName, By locator){
		this.driver = driver;
		this.locator = locator;
		this.screenName = screenName;
	}	
	
	public boolean isPresent() {
		try {
			if (isDisplayed()){
				return true;
			}
		} catch (NoSuchElementException ne) {
			throw new NoSuchElementException(screenName + " Element <" + this.getClass().getSimpleName() + "> could not be found " + locator);			
		}
		return false;
	}
	
	@Override
	public void clear() {
		driver.findElement(locator).clear();	
	}

	@Override	
	public void click() {
		driver.findElement(locator).click();
	}

	@Override
	public WebElement findElement(By arg0) {
		return driver.findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {		
		return driver.findElement(locator).findElements(arg0);
	}

	@Override
	public String getAttribute(String arg0) {		
		return driver.findElement(locator).getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		return driver.findElement(locator).getText();
	}

	@Override
	public boolean isDisplayed() {
		return driver.findElement(locator).isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return driver.findElement(locator).isEnabled();
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		driver.findElement(locator).sendKeys(arg0);		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub		
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
