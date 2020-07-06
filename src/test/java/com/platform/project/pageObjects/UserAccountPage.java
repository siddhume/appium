package com.platform.project.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.platform.project.commons.CommonMethods;

public class UserAccountPage {
	private Logger logger = Logger.getLogger(UserAccountPage.class);

	@FindBy(xpath = (("//h1[contains(text(),'Welcome to iBusiness')]")))
	WebElement welcomeText;

	@FindBy(xpath = (("//span[contains(text(),'Log Off')]")))
	WebElement logout;
	WebDriver driver;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getWelcomemsg() {
		return CommonMethods.getElementText(driver, welcomeText, 3);
	}

	public void logout() {
		
		CommonMethods.clickElement(driver, logout, 3);
		//logout.click();
		logger.info("logged out");
	}

}
