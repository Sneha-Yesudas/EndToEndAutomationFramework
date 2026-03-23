package com.endtoendtesting.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.endtoendtesting.enums.Env;
import com.endtoendtesting.pages.DashboardPage;
import com.endtoendtesting.pages.LoginPage;
import com.endtoendtesting.utility.ReadPropertiesFileUtility;

public class LoginEndtoEnd {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get(ReadPropertiesFileUtility.readProperty("URL",Env.QA));
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);

	    String loginVerification=   loginPage.doLogin("snehamary575@gmail.com", "Password@12").verifyLogin();
	    System.out.println(loginVerification);
	    loginPage.tearDown();

	}

}
