package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.util.Constants;




public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initializeProperties();
		driver = basePage.initializeDriver(prop);
		homePage = new HomePage(driver);
	}
	
	
	@Test(priority=1, description="get Home page title")
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	
	@Test(priority=2, description="get Home page URL")
	public void getHomeUrl() {
		String url = homePage.getPageUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.HOME_PAGE_URL);
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
