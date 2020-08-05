package com.platform.project.pageObjects;





import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.platform.project.commons.CommonMethods;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class HomePage {
	
	@FindBy(how=How.XPATH, using="//android.widget.TextView[@content-desc='OS']")
	WebElement os;
	
	
	
	//@FindBy(linkText=("France"))
	//@FindBy(how=How.LINK_TEXT,using="France")
	
	
	@FindBy(xpath=("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]"))
	WebElement clickFrance;
	
//	@FindBy(how=How.LINK_TEXT, using="Australia")
	@FindBy(id=("com.androidsample.generalstore:id/nameField"))
	WebElement name;

	@FindBy(id=("com.androidsample.generalstore:id/btnLetsShop"))
	WebElement submit;
	
	@FindBy(id=("com.androidsample.generalstore:id/radioFemale"))
	WebElement genderFemale;
	
	@FindBy(xpath=("android.widget.Toast"))
	WebElement errorMsg;
	

	private AppiumDriver<MobileElement> driver;
	private Logger logger=Logger.getLogger(HomePage.class);
	

	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void tapOS() {
//		TouchActions action = new TouchActions(driver);
//		action.singleTap(os);
//		action.perform();		
		
		os.click();
	}
	
	
	
	
	public void selectFrance() throws InterruptedException {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"));"));
	
		Thread.sleep(5000);
		CommonMethods.clickElement(driver, clickFrance,5);
		
	}
	public void selectAustralia() throws InterruptedException {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));")).click();
	
		Thread.sleep(5000);
		//CommonMethods.clickElement(driver, clickFrance,5);
		
	}
	
	public void enterName(String name1 ) {
		CommonMethods.sendKeys(driver, name, name1, 5);
	}
	
	public void tapGenderFemale() {
		CommonMethods.clickElement(driver, genderFemale, 5);
	}
	
	public void submit() {
		CommonMethods.clickElement(driver, submit, 5);
	}
	public String getToastErrorMsg() {
		return errorMsg.getAttribute("name");
				
	}

}