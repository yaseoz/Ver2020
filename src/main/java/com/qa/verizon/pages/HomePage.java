package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.util.ElementUtil;



public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By shop = By.id("gnav20-Shop-L1");
	By smartphone = By.id("gnav20-Shop-L3-1");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
				
	}
	
	
	public ShopPage goShopPage() {
		WebElement shops = driver.findElement(shop);
		Actions actions = new Actions(driver);
		actions.moveToElement(shops).build().perform();
		driver.findElement(smartphone).click();
		return new ShopPage(driver);
	}
	
	
	
	
}
