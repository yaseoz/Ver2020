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
import com.qa.verizon.pages.SmartPhone;
import com.qa.verizon.util.Constants;


public class SmartPhoneTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	ShopPage shopPage;
	SmartPhone smartPhone;
	
	
	@BeforeMethod
	public void setUp(){
		basePage= new BasePage();
		prop = basePage.initializeProperties();
		driver= basePage.initializeDriver(prop);
		homePage = new HomePage(driver);
		shopPage = homePage.goShopPage();
		smartPhone = shopPage.goPhone();	
	}
	
	
	@Test(priority= 1, description= "verify Selected Phone Page TITLE")
	public void verifyTitle(){
		String title = smartPhone.getSelectedPhoneTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SMART_PHONE_PAGE_TITLE);
		
	}

	@Test(priority= 4, description= "verify page Url")
	public void verifyPageUrl(){
		String url = smartPhone.getPageUrl();
		System.out.println(url);
		Assert.assertTrue(url.endsWith("https://www.verizon.com/smartphones/apple-iphone-11-pro-max/"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
