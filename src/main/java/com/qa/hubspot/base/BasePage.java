package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;

	/**
	 * this method is use to initialise the driver on the basis of browserName.
	 * 
	 * @param browserName
	 * @return
	 */

	public WebDriver init_driver(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {

		} else {
			System.out.println(browserName + "Browser value is wrong, please pass the correct browser name....");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		return driver;
	}

	/**
	 * this method is used to read the properties from config.properties file.
	 * 
	 * @return
	 */
	public Properties init_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Bhavin\\eclipse-workspace\\SepMorningPOMsessons\\src\\main\\java"
							+ "\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			System.out.println("config file is missing, please check it....");

		} catch (IOException e) {
			System.out.println("properties could not be loaded");
			e.printStackTrace();
		}

		return prop;

	}

}
