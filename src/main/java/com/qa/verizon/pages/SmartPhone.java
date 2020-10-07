package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.verizon.page.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;



public class SmartPhone extends BasePage{

	
	WebDriver driver;
	ShopPage shopPage;
	ElementUtil elementUtil;
	
	
	By color = By.xpath("//label[contains(text(),'Space Gray')]");
	By storage = By.xpath("//p[contains(text(),'64GB')]");
	By price = By.id("pricingOption0");
	By continueBtn = By.xpath("//button[@id='ATC-Btn']");
	By zipcode = By.xpath("//input[@id='zipcode']");
	By confirmeLocation = By.xpath("//button[contains(text(),'Confirm Location')]");
	By costumerBtn = By.xpath("//button[contains(text(),'New Customer')]");

	
	
	public SmartPhone(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	
	public String getPhoneTitle(){
		String title = elementUtil.waitForGetPageTitle(Constants.SMART_PHONE_PAGE_TITLE);
		return title;
		
	}
	
	
	public String getSelectedPhoneTitle() {
		String title = elementUtil.waitForGetPageTitle(Constants.SMART_PHONE_PAGE_TITLE);
		return title;
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	
	public CartPage gotoCart() {

		WebElement clr = driver.findElement(color);
		JavaScriptUtil.clickElementByJS(clr, driver);
		
		WebElement size = driver.findElement(storage);
		JavaScriptUtil.clickElementByJS(size, driver);
		
		WebElement prc = driver.findElement(price);
		JavaScriptUtil.clickElementByJS(prc, driver);
		
		String colors = driver.findElement(color).getText();
		System.out.println(colors);
		
		String sizes = driver.findElement(storage).getText();
		System.out.println(sizes);
		
		String prices = driver.findElement(price).getText();
		System.out.println(prices);
		
		driver.findElement(continueBtn).click();
		
		WebElement element = driver.findElement(zipcode);
		
		JavaScriptUtil.sendKeysUsingJSWithID(driver, "zipcode", "91335");
		
		WebElement confirm = driver.findElement(confirmeLocation);
		JavaScriptUtil.clickElementByJS(confirm, driver);
		
		WebElement newcostumer = driver.findElement(costumerBtn);
		newcostumer.click();
		
		return new CartPage(driver);
	}
	
	
	
	
	
}
