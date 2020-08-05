package com.platform.project.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MyDevices {

	
	@FindAll(@FindBy(how = How.XPATH, using = "//android.widget.ListView/android.widget.TextView"))
	List<WebElement> allElements;
	
	
	private AppiumDriver<MobileElement> driver;
	private Logger logger=Logger.getLogger(HomePage.class);
	
	public MyDevices(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public int getDisplayCount() {
		
	return allElements.size();
			
	}
	
	public String getElement(int a) {
		
		
		return allElements.get(a-1).getText();
				
		}
	



	
	
	
	
	
	
	
}
