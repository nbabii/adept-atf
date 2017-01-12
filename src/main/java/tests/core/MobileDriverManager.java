package tests.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

//Manager that should provide appropriate driver per request
public class MobileDriverManager {

	private AppiumDriver<MobileElement> mobileDriver;

	public AppiumDriver<MobileElement> initialiseDriver(String isRealDevice, String platformName, String platformVersion, String deviceName, String deviceUDID, String deviceLanguage){

		/*Getting framework settings and storing them*/
		Reporter.log("Preparing to create Appium driver with capabilities: <br>", true);
		Reporter.log("#isRealDevice = " + isRealDevice +  " <br>", true);
		Reporter.log("#platformName = " + platformName +  " <br>", true);
		Reporter.log("#platformVersion = " + platformVersion +  " <br>", true);
		Reporter.log("#deviceName = " + deviceName +  " <br>", true);
		Reporter.log("#deviceUDID = " + deviceUDID +  " <br>", true);
		Reporter.log("#deviceLanguage = " + deviceLanguage +  " <br>", true);


		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("fullReset", "false");


			if(PlatformName.Android.name().equalsIgnoreCase(platformName)){

				if(isRealDevice.equalsIgnoreCase("yes")){
					Reporter.log("Preparing real Android device... <br>", true);
					throw new RuntimeException("Android not supported yet!");
				} else {
					throw new RuntimeException("Emulators not supported yet!");
					//Reporter.log("Preparing emulator or simulator... <br>", true);
				}

			} else if (PlatformName.iOS.name().equalsIgnoreCase(platformName)){

				capabilities.setCapability("automationName", "xcuitest");
				capabilities.setCapability("sendKeyStrategy", "setValue");
				capabilities.setCapability("interKeyDelay", "50");
				capabilities.setCapability("newCommandTimeout", "180");
				capabilities.setCapability("autoAcceptAlerts", "true");
				capabilities.setCapability("platformName", PlatformName.iOS.name());
				capabilities.setCapability("platformVersion", platformVersion);
				capabilities.setCapability("deviceName", deviceName);


				if(isRealDevice.equalsIgnoreCase("yes")){

					Reporter.log("Preparing real iOS device... <br>", true);

					capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/deviceconsole");
					capabilities.setCapability("udid", deviceUDID.toLowerCase());
					capabilities.setCapability("app", PropertyLoader.loadFrameworkProperty("ios.ipa.path"));
					capabilities.setCapability("bundleid", PropertyLoader.loadFrameworkProperty("ios.ipa.bundleid"));

				} else {

					Reporter.log("Preparing iOS simulator... <br>", true);

					capabilities.setCapability("iosInstallPause", 30000);
					capabilities.setCapability("app", PropertyLoader.loadFrameworkProperty("ios.app.path"));

				}

				try {
					mobileDriver = new IOSDriver<MobileElement>(new URL(PropertyLoader.loadFrameworkProperty("appium.iphone.server.url")), capabilities);
				} catch (MalformedURLException e) {
					throw new RuntimeException("Got a MalformedURLException during iOS driver initialization.");
				}

			} else throw new RuntimeException("Invalid platform name provided");

		return mobileDriver;
	}

	public AppiumDriver<MobileElement> getDriver(){
		if (mobileDriver != null){
			return mobileDriver;
		} else throw new RuntimeException("Cannot get Mobile Driver, mobileDriver is null");
	}

	public void killDriver(){

		mobileDriver.quit();
		mobileDriver = null;

	}

}
