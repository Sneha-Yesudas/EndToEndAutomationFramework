package com.endtoendtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.endtoendtesting.utility.BrowserUtility;
import com.endtoendtesting.utility.WebDriverUtility;

public class CartPage extends BrowserUtility {

	private static final By LISTOFPRODUCTSADDED = By.xpath("//div[@class=\"cartSection\"]//h3");
	private static final By CHECKOUTBUTTON=By.xpath("//button[text()=\"Checkout\"]");

	public CartPage(WebDriver driver) {
		super(driver);

	}
	
	public String verifyProductAddedinCart(String text) {
		return getTextFromListOfElements(LISTOFPRODUCTSADDED,text);
	}

}
