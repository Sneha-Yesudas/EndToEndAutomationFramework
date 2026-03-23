package com.endtoendtesting.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.endtoendtesting.pojo.AddProductPojo;

@Listeners({com.endtoendtesting.listeners.TestListener.class})
public class AddtoCartTest extends TestBase {
	


	@Test(testName  = "verifyProductAddedtoCartSuccessfully", description = "This is to check when user selects a product and add to cart it is displayed in page", groups = {
			"regression", "e2e","sanity" },dataProvider = "AddProductToCartDataProvider",dataProviderClass = com.endtoendtesting.dataprovider.ExcelDataProvider.class,retryAnalyzer = com.endtoendtesting.listeners.RetryAnalyser.class)
	public void verifyProductAddedtoCartSuccessfully(AddProductPojo addProduct) {
    
    
		String text = loginPage.doLogin(addProduct.getUsername(), addProduct.getPassword()).doAddtoCart(addProduct.getProduct())
				.verifyProductAddedinCart(addProduct.getProduct());	
		Assert.assertEquals(text, "ZARA COAT 3");
		

	}

}
