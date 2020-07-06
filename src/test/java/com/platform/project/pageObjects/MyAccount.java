package com.platform.project.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.platform.project.commons.CommonMethods;

public class MyAccount {
	
	private Logger logger = Logger.getLogger(MyAccount.class);
	
	@FindBy(name=("email_address"))
	WebElement email1;
	@FindBy(name=("password"))
	WebElement password1;
	@FindBy(xpath=(("//button[@id='tdb5']//span[@class='ui-button-text']")))
	WebElement submit;
	@FindBy(className=("messageStackError"))
	List<WebElement> error;
	
	WebDriver driver;
	
public MyAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
public void enterCredentials(String email,String password) {
	logger.info("Entering Email "+ email);
	
	email1.sendKeys(email);
	
	logger.info("Enter Password "+ password);
	password1.sendKeys(password);
//	logger.info("hit submit");
	CommonMethods.clickElement(driver, submit, 2);

}



public String getLoginErrormsg() {
	
	logger.info("got Error message");
	
	return CommonMethods.getElementText(driver, error.get(1), 3);
			//error.get(1).getText();
}





}
