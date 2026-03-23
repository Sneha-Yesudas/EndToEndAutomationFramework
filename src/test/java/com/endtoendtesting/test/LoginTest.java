package com.endtoendtesting.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.endtoendtesting.utility.WebDriverUtility;

public class LoginTest extends WebDriverUtility {

	public LoginTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("This is test");
		WebDriver driver = new ChromeDriver();

		LoginTest utility = new LoginTest(driver);
		utility.navigatetoURL("https://rahulshettyacademy.com/client/#/auth/login");
		utility.maximizewindow();

		By userEmailLocator = By.xpath("//input[contains(@id,\"userEmail\")]");
		utility.sendKeys("snehamary575@gmail.com", userEmailLocator);

		By userPassword = By.cssSelector("#userPassword");
		utility.sendKeys("Password@12", userPassword);

		By submitButtonLocator = By.className("login-btn");
		utility.click(submitButtonLocator);

		By productsNameLocator = By.xpath("//div[contains(@class,\"card-body\")]//h5");

		utility.waitforVisiblityofElements(productsNameLocator);

		By AddtoCartLocator = By
				.xpath("//div[contains(@class,\"card-body\")]//button[contains(text(),\"Add To Cart\")]");
		utility.waitforVisiblityofElements(AddtoCartLocator);

		utility.iterateThroughElementsandClick(AddtoCartLocator, productsNameLocator, "ZARA COAT 3");

		System.out.println("Done.");

		By cartLocator = By.xpath("//button[contains(@routerlink,\"cart\")]");

		utility.waitAndClick(cartLocator);

		By listOfProductsAdded = By.xpath("//div[@class=\"cartSection\"]//h3");

		String productFindinCart = utility.getTextFromListOfElements(listOfProductsAdded, "ZARA COAT 3");
		System.out.println(productFindinCart);

		utility.tearDown();
	}

}
