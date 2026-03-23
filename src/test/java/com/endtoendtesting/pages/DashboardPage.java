package com.endtoendtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.endtoendtesting.utility.BrowserUtility;
import com.endtoendtesting.utility.WebDriverUtility;

public class DashboardPage extends BrowserUtility {
	
	private static final By PRODUCTSNAMELOCATOR = By.xpath("//div[contains(@class,\"card-body\")]//h5");
	private static final By ADDTOCARTLOCATOR = By.xpath("//div[contains(@class,\"card-body\")]//button[contains(text(),\"Add To Cart\")]");
	private static final By CARTBUTTONLOCATOR = By.xpath("//button[contains(@routerlink,\"cart\")]");
	private static final By SIGNOUTBUTTONLOCATOR=By.xpath("//button[contains(text(),\" Sign Out \")]");
	
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String verifyLogin() {
		return getText(SIGNOUTBUTTONLOCATOR);
	}
	
	public CartPage doAddtoCart(String productNametoBeCarted) {
		waitforVisiblityofElements(PRODUCTSNAMELOCATOR);
		iterateThroughElementsandClick(ADDTOCARTLOCATOR,PRODUCTSNAMELOCATOR,productNametoBeCarted);
		waitAndClick(CARTBUTTONLOCATOR);
		CartPage cartPage=new CartPage(getDriver());
		return cartPage;
		
	}
	
	
	
	
	
	
	
}
