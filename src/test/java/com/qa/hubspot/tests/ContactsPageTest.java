package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageTitle() {
		String title = contactsPage.getcontcatsPageTitle();
		System.out.println("Contacts page title is---> "+title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getcontactsTestData() {
		//Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
	}
	
	@Test(priority = 2, dataProvider = "getcontactsTestData")
	public void createContactsTest(String email, String firstname, String lastname, String jobtitle) throws InterruptedException {
		contactsPage.createNewContact(email, firstname, lastname, jobtitle);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
