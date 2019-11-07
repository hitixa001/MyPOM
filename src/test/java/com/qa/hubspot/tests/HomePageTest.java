package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is---> "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void veryfyHomePageHeaderTest() {
		Assert.assertTrue(homePage.isHeaderPresent(),"HomePage Header is not Present");
		String headerValue = homePage.getHomePageHeaderValue();
		System.out.println("homePage header is----> "+headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
	}
	
//	@Test(priority = 3)
//	public void veryfyAccountName() {
//		Assert.assertTrue(homePage.isHeaderPresent());
//		String accountName = homePage.getAccountNameValue();
//		System.out.println("account name is---> "+ accountName);
//		Assert.assertEquals(accountName, prop.getProperty("accountname"));
//	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
