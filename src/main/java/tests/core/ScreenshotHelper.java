package tests.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenshotHelper {

	public static void makeScreenshot(WebDriver driver, String screenName){		
		takeScreenAsBytes(driver, screenName, new SimpleDateFormat("yyyy_MM_dd.HH-mm-ss").format(new Date()));
	}
	
	@Attachment(value = "{1} Screenshot, done at {2}", type = "image/png")
	private static byte[] takeScreenAsBytes(WebDriver driver, String screenName, String date){		
		try {
			return Files.readAllBytes(takeScreenshot(driver).toPath());
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	private static File takeScreenshot(WebDriver driver) {		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			Reporter.log("ScreenshotHelper: Got an Interrupted Exception <br>", true);
			e1.printStackTrace();
		}
		Reporter.log("ScreenshotHelper: Capturing a screenshot <br>", true);		
		File screenFile = null;
		try {
			screenFile = ((TakesScreenshot) driver)		
				.getScreenshotAs(OutputType.FILE);
		} catch (Exception e) {
			Reporter.log("ERROR - GOT AN EXCEPRION DURING TAKING SCREENSHOT FILE: " + e.getMessage() + " <br>", true);
			return null;
		}
		Reporter.log("ScreenshotHelper: Got a screenshot file <br>", true);
		return screenFile;
	}
	
}
