package com.endtoendtesting.test;

import static com.endtoendtesting.enums.Browser.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.endtoendtesting.pages.LoginPage;
import com.endtoendtesting.utility.BrowserUtility;
import com.endtoendtesting.utility.LambdaUtility;

public class TestBase {
	
	LoginPage loginPage;
	boolean isLambda;
	
	
	@Parameters({"browsername","isLambda","isHeadless"})
	@BeforeMethod
	public void setup(@Optional("CHROME") String browsername,@Optional("false")boolean isLambda,@Optional("false")boolean isHeadless,ITestResult result) {
		
		if(isLambda) {
			WebDriver lambdaDriver;
			lambdaDriver=LambdaUtility.setupCloud(valueOf(browsername.toUpperCase()),result.getMethod().getMethodName());
			loginPage=new LoginPage(lambdaDriver);
			
		}
		else {
		loginPage = new LoginPage(valueOf(browsername.toUpperCase()),isHeadless);
		}
	}
	

	@AfterMethod
	public void teardown() {
		if(isLambda) {
			LambdaUtility.tearDown();
		}
		else {
		loginPage.tearDown();
		}
	}
	
	public BrowserUtility getInstance() {
		return loginPage;
	}


}
