package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE, "login Page title is mis-matched...");
		
	}
	
	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(),"sign up link is not displayed...");
	}
	
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
