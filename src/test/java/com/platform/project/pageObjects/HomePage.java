package com.platform.project.pageObjects;





import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.platform.project.commons.CommonMethods;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class HomePage {
	
	@FindBy(id=("com.androidsample.generalstore:id/spinnerCountry"))
	WebElement countryList;
	//@FindBy(linkText=("France"))
	//@FindBy(how=How.LINK_TEXT,using="France")
	@FindBy(xpath=("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]"))
	WebElement clickFrance;
	
	@FindBy(id=("com.androidsample.generalstore:id/nameField"))
	WebElement name;

	@FindBy(id=("com.androidsample.generalstore:id/btnLetsShop"))
	WebElement submit;
	
	@FindBy(id=("com.androidsample.generalstore:id/radioFemale"))
	WebElement genderFemale;

	

	private AppiumDriver<MobileElement> driver;
	private Logger logger=Logger.getLogger(HomePage.class);
	

	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickCountryList() {
		CommonMethods.clickElement(driver, countryList, 5);
		
	}
	
	public void selectFrance() throws InterruptedException {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"));"));
	
		Thread.sleep(5000);
		CommonMethods.clickElement(driver, clickFrance,5);
		
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

}