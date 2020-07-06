package com.platform.project.steps;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.platform.project.commons.AppiumDriverManager;
import com.platform.project.commons.CommonMethods;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.MyAccount;
import com.platform.project.pageObjects.UserAccountPage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePageTest {

	private Logger logger = Logger.getLogger(HomePageTest.class);
	AppiumDriverManager adm;
	
	AppiumDriver<MobileElement> driver;
	HomePage hp;
	MyAccount ma;
	UserAccountPage ua;

	

	@Before
	public void beforeMethod() throws IOException {
		logger.info("running before method");
		adm=new AppiumDriverManager();
		//driver=adm.getDriver();
		driver=adm.setRemoteDriver();
		
		hp = new HomePage(driver);
		
		logger.info("before method done");
			
	}
	@After
	public void afterMethod() {
		driver.quit();
	}
	

	
	@And ("^I click on country France$")
	public void selectCountry() throws InterruptedException {
		hp.clickCountryList();
		hp.selectFrance();
		}
	
	@And ("^I enter my name sid$")
	public void enterName() {
		hp.enterName("sid");
	}
	
	@And ("^I enter gender female$")
	public void enterGender() {
		hp.tapGenderFemale();
	}
	
	@And ("^I click lets Shop button$")
	public void enterLetsShop() {
		hp.submit();
	}
    
   
	
}
