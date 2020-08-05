package com.platform.project.steps;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.platform.project.commons.AppiumDriverManager;
import com.platform.project.commons.CommonMethods;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.MyAccount;
import com.platform.project.pageObjects.MyDevices;
import com.platform.project.pageObjects.UserAccountPage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

import static org.junit.Assert.*;


public class HomePageTest {

	private Logger logger = Logger.getLogger(HomePageTest.class);
	AppiumDriverManager adm;
	
	AppiumDriver<MobileElement> driver;
	HomePage hp;
	MyDevices md;
	
//adding comments from eclipse workspase 1 
	// making changes on the develop branch
	// making changes on the develop branch
	// making changes on the develop branch
	// making changes on the develop branch
	// making changes on the develop branch

	@Before
	public void beforeMethod() throws IOException {
		logger.info("running before method");
		adm=new AppiumDriverManager();
		driver=adm.getDriver();
		//driver=adm.setRemoteDriver1();
		
		hp = new HomePage(driver);
		md=new MyDevices(driver);
		
		logger.info("before method done");
			
	}
	
	@Given("^I tap the OS button$")
	public void i_tap_the_OS_button() throws Throwable {
	    hp.tapOS();
	    
	}

	@Then("^verify that there are (\\d+) elements on the page$")
	public void verify_that_there_are_elements_on_the_page(int arg1) throws Throwable {
		assertEquals(arg1,md.getDisplayCount());
		
		
	}
	    
//	@Then("^Verfiy that the \"([^\"]*)\"st element name is \"([^\"]*)\"$")
//	public void verfiy_that_the_st_element_name_is(String arg1, String arg2) throws Throwable {
//	    
//		assertEquals(arg2,md.getElement(arg1));

	
	@Then("^Verfiy that the (\\d+) element name is \"([^\"]*)\"$")
	public void verfiy_that_the_element_name_is(int arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg2,md.getElement(arg1));
	}

	@After
	public void afterMethod() {
		//driver.quit();
		
	}
	
	}
