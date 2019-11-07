package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//page-objects //object repository //by locators
	By emailID = By.id("username");
	By password = By.id("password");
	By loginBTN = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//create the constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 15);
	}

	//page-actions //page methods
	public String getPageTitle() {
		String title = elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 15);
		System.out.println("Login Page title is: "+ title);
		return title;
	}
	
	public boolean verifySignUpLink() {
		return elementUtil.isElementDisplayed(signUpLink);
		
	}
	public HomePage doLogin(String username, String pwd) {
		System.out.println("credentials are: "+username + " _"+ pwd);
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBTN);
		//elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 15);
		
//		driver.findElement(emailID).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBTN).click();
//		
//		
		
		return new HomePage(driver);
	}
}
