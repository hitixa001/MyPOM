package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage{
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By createContacts = By.xpath("//div//span[contains(text(),'Create contact')]");
	By createContactsFormButton = By.xpath("//li//div[text()='Create contact']");
	By email = By.xpath("//input[ @data-field='email']");
	By firstname = By.xpath("//input[@data-field='firstname']");
	By lastname = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getcontcatsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 15);
	}
	
	public void createNewContact(String mail, String FN, String LN, String jobtitle) throws InterruptedException {
		
		Thread.sleep(5000);
		elementUtil.waitForElementPresent(createContacts, 15);
		elementUtil.doClick(createContacts);
		
		elementUtil.waitForElementPresent(email, 10);
		elementUtil.doSendKeys(email, mail);
		
		elementUtil.waitForElementPresent(firstname, 5);
		elementUtil.doSendKeys(firstname, FN);
		
		elementUtil.waitForElementPresent(lastname, 5);
		elementUtil.doSendKeys(lastname, LN);
		
		elementUtil.waitForElementPresent(jobTitle, 10);
		elementUtil.doActionsSendKeys(jobTitle, jobtitle);
//		elementUtil.doSendKeys(jobtitle, JT);
		
		elementUtil.waitForElementPresent(createContactsFormButton, 5);
		//elementUtil.doClick(createContactsFormButton);
		elementUtil.doActionsClick(createContactsFormButton);
		
		
		
		
		
		
		
		
		
		
		
	}

}
