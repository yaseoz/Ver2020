package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.util.ElementUtil;

public class ShopPage extends BasePage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By header = By.xpath("//h1[contains(text(),'All Smartphones')]");
	By phone = By.xpath("//a[@aria-label='Apple iPhone 11 Pro Max']");
	
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
		
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public String getPageHeader() {
		return driver.findElement(header).getText();
	}
	
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	

	
	public SmartPhone goPhone() {
		driver.findElement(phone).click();
		return new SmartPhone(driver);
	}
	
	

	
}
