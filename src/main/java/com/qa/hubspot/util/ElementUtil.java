package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementUtil {

	
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void getURL(String url) {
		driver.get(url);

		// Thread.sleep(5000); this is not a good practice to provide static wait in the
		// form of thread.sleep(thread.sleep is a java function)

		// by default it will be applied on all the element which available on the page
		// its also known as global wait/dynamic wait
		// its only and only for all the webElements not for the URL/page.
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); to nullify
		// the implicitlyWait apply 0sec.
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/**
	 * 
	 * @param locator
	 */

	public void waitForElementPresent(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	
	/**
	 * 
	 * @param title
	 * @param timeOut
	 * @return
	 */
	public String waitForTitlePresent(String title, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));		
		return driver.getTitle();

	}

	/**
	 * this method is used to create the WebElement on the basis of By locator.
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}

		return element;
	}

	/**
	 * this method is used to click on webElement.
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking on the webelement");
			System.out.println(e.getMessage());
		}

	}
	
	public void doActionsClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking on the webelement");
			System.out.println(e.getMessage());
		}

	}
	
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking getting the text of the webelement");
			System.out.println(e.getMessage());
			return null;
		}

	}


	/**
	 * this method is use to pass the values in as webeEement.
	 * 
	 * @param locator
	 * @param value
	 */

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while passing values to the webelement");
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionsSendKeys(By locator, String value) {
	
		try {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception occured while passing values to the webelement");
			System.out.println(e.getMessage());
		}
	}
	
	public boolean isElementDisplayed(By locator) {
		try {
		getElement(locator).isDisplayed();
		return true;
	}catch(Exception e) {
		System.out.println("some exception occured while checking the element is displayed");
		return false;
		}
		
	}
	

	public void doQuit() {
		driver.quit();
	}

}
