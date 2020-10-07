package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.ShopPage;
import com.qa.verizon.util.Constants;

public class ShopPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	ShopPage shopPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initializeProperties();
		driver = basePage.initializeDriver(prop);
		homePage = new HomePage(driver);
		shopPage = homePage.goShopPage();
	}
	
	
	@Test (priority = 1, description= "Shop Page title verified")
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		String title = shopPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SHOP_PAGE_TITLE);
	}
	
	
	@Test (priority = 2, description= "Shop Page header verified")
	public void verifyPageHeader() {
		String header = shopPage.getPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.SHOP_PAGE_HEADER);
	}
	
	
	@Test (priority = 3, description= "Shop Page URL verified")
	public void verifyURL() {
		String url = shopPage.getPageURL();
		System.out.println(url);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
