package com.endtoendtesting.pages;

import static com.endtoendtesting.enums.Env.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.endtoendtesting.enums.Browser;
import com.endtoendtesting.enums.Env;
import com.endtoendtesting.utility.BrowserUtility;
import com.endtoendtesting.utility.ReadPropertiesFileUtility;
import com.endtoendtesting.utility.WebDriverUtility;

public class LoginPage extends BrowserUtility {

	private static final By USEREMAILLOCATOR = By.xpath("//input[contains(@id,\"userEmail\")]");
	private static final By USERPASSWORD = By.cssSelector("#userPassword");
	private static final By SUBMITBUTTONLOCATOR = By.className("login-btn");

	public LoginPage(WebDriver driver) {
		super(driver);
		driver.get(ReadPropertiesFileUtility.readProperty("URL", QA));
		maximizewindow();

	}

	public LoginPage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
		navigatetoURL(ReadPropertiesFileUtility.readProperty("URL", QA));
		maximizewindow();

	}

	public DashboardPage doLogin(String username, String password) {

		sendKeys(username, USEREMAILLOCATOR);
		sendKeys(password, USERPASSWORD);
		waitAndClick(SUBMITBUTTONLOCATOR);
		DashboardPage dashboardPage = new DashboardPage(getDriver());
		return dashboardPage;

	}

}
