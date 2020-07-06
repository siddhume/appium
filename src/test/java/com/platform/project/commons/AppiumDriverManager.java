package com.platform.project.commons;



import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverManager {
	
	private AppiumDriver<MobileElement> driver;
	//AppiumDriver is parent to bot android and IOS driver
	private Logger logger=Logger.getLogger(AppiumDriverManager.class);

	
	private AppiumDriver<MobileElement> createDriver(){
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "JassEmulator");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Sehaj Singh\\Desktop\\MobileApps\\ecommerce.apk");
		//ecommerce app
		
		try {
			URL url=new URL("http://0.0.0.0:4723/wd/hub");
			driver=new AndroidDriver<>(url,caps);
			return driver;
		}
		catch(MalformedURLException mue) {
			mue.printStackTrace();
			logger.info("unable to connect to the Appium Server");
			return null;
		}
	}
	
	public AppiumDriver<MobileElement> getDriver() {

		if (driver == null) {
			try {
				driver = createDriver();
				logger.info("Driver initialization sucessful");
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Couldnt initialize the driver");
			}
		}

		else {
			logger.info("Driver is already initialized");
		}
		return driver;
	}
	
	public AppiumDriver<MobileElement> setRemoteDriver() throws MalformedURLException{
		
		
		String kobitonServerUrl = "https://siddhume90:a2399183-7fa2-495b-9970-21d7e0bee049@api.kobiton.com/wd/hub";
		URL url=new URL("https://siddhume90:a2399183-7fa2-495b-9970-21d7e0bee049@api.kobiton.com/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// The generated session will be visible to you only. 
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		// The maximum size of application is 500MB
		// By default, HTTP requests from testing library are expired
		// in 2 minutes while the app copying and installation may
		// take up-to 30 minutes. Therefore, you need to extend the HTTP
		// request timeout duration in your testing library so that
		// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "kobiton-store:68736");

		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "Xperia 10 Plus");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
		driver=new AndroidDriver<>(url,capabilities);
		return driver;
	}
	
}


