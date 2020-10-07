package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.pages.CartPage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.ShopPage;
import com.qa.verizon.pages.SmartPhone;
import com.qa.verizon.util.Constants;



public class CartPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	ShopPage shopPage;
	SmartPhone smartPhones;
	CartPage cartPage;
	
	@BeforeMethod
	public void setUp(){
		basePage= new BasePage();
		prop = basePage.initializeProperties();
		driver= basePage.initializeDriver(prop);
		homePage = new HomePage(driver);
		shopPage = homePage.goShopPage();
		smartPhones = shopPage.goPhone();
		cartPage = smartPhones.gotoCart();
		
	}
	
	@Test(priority = 1, description ="Page title verified")
	public void verifyPageTitle() {
		String title = cartPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MY_CART_PAGE_TITLE);
	}
	
	@Test(priority = 2, description ="Phone name verified")
	public void verifyPhoneName() {
		String name = cartPage.getProductName();
		System.out.println(name);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
