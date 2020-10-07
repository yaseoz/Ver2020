package com.qa.verizon.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Yavuz 
 *
 */

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static String flash;
	
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	public WebDriver initializeDriver(Properties prop) {
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
		}
		else if(browser.equalsIgnoreCase("opera")){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else {
			System.out.println("Browser name " + browser + " is not found. Please pass the correct browser...!");
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get(prop.getProperty("url"));
		
		return driver;
			
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public Properties initializeProperties() {	
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("/Users/yso/eclipse-workspace/Sel07_TestNG_Verizon/src/main/java/config/qa/verizon/config/config.properties");
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties... Please correct your config...!");
		} catch (IOException e) {					
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
	
}
