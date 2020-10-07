package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;



public class CartPage {

	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	By productName = By.xpath("//*[@id='content']/div[3]/div[2]/div[3]/h2");

	
	
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.MY_CART_PAGE_TITLE);
	}
	
	public String getProductName() {
//		elementUtil.waitForElementPresentBy(productName);
		return elementUtil.doGetText(productName);
	}

}
