package com.platform.project.commons;



import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static java.lang.Thread.currentThread;

public class CommonMethods {
	//utility class
private static Logger logger = Logger.getLogger(CommonMethods.class);


private static void TakeScreenShot(AppiumDriver<MobileElement> driver, String className, String methodName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
	//TakesScreenshot ts= driver;


		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String fileName=timeStamp+className+methodName;
		//String destinationFile="C:\\Users\\Sehaj Singh\\eclipse-workspace\\SeleniumIntro\\screenShots\\"+fileName+".png";
		String destinationFile="./screenShots/"+fileName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		logger.info("ScreenShot taken and stored at \\screenShots\\"+fileName+".png");
			
}
	
public static void check(boolean condition,AppiumDriver<MobileElement> driver,String failMessage) {
	if(condition) {
		logger.info("check condition is true");
		junit.framework.Assert.assertTrue(true);
		
				
	}
	else {
		logger.info(failMessage);
		try {
			TakeScreenShot(driver,currentThread().getStackTrace()[2].getClassName(), currentThread().getStackTrace()[2].getMethodName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		junit.framework.Assert.assertTrue(true);
	}
	
}

public static String getPropertyXL(String property) throws IOException {
	readExcel re=new readExcel();
	Map<String, String> map=new HashMap<String, String>();
	map=re.setMapData();
	String value=map.get(property);
	
	if(value != null) {
		return value;
		}
	else {
		logger.info("Invalid property: "+ property+ " entered");
		throw new NullPointerException();
	}
	
}

public static boolean waitForElement(AppiumDriver<MobileElement> driver,WebElement el, int seconds){
	WebDriverWait wait=new WebDriverWait(driver,seconds);
	
	try {
		wait.until(ExpectedConditions.visibilityOf(el));
		logger.info("Element " + el.getText()+ " is visible");
		return true;
	}
	catch(Exception e) {
		logger.info("Element is not visible");
		return false;
		
	}
}
	
	public static String getElementText(AppiumDriver<MobileElement> driver,WebElement el, int seconds){
		
		if(waitForElement(driver, el, seconds)) {
			logger.info(" the Text of the Element is " + el.getText());
			return el.getText();
			}
		else 
			logger.info("Couldnt find Elements text " );
			return "";
	}
	
	public static void clickElement(AppiumDriver<MobileElement> driver,WebElement el, int seconds){
		
		check(waitForElement(driver, el, seconds),driver,"Element Cannot be clicked");
		logger.info("Element has been clicked");
		el.click();
		
	}
	
	public static void sendKeys(AppiumDriver<MobileElement> driver,WebElement el,String keys, int seconds){
		
		check(waitForElement(driver, el, seconds),driver,"Element Cannot be clicked");
		
		el.sendKeys(keys);
		logger.info("entered text: " +keys);
	}
	
	
}








