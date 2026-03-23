package com.endtoendtesting.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.endtoendtesting.enums.Browser;

public class LambdaUtility {

	public static String hubURL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> desiredCapabilities = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver setupCloud(Browser browser,String name) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap();
		ltOptions.put("user", "snehamary575");
		ltOptions.put("accessKey", "LT_0wyK2Yun8crQYJcvxTHUovfKVv1KrISz62BZ1PVaFvBcXZK");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", name);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		desiredCapabilities.set(capabilities);

		try {
			WebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driverLocal.set(driver);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverLocal.get();
	}
	
	public static void tearDown() {
		if(driverLocal.get()!=null) {
		driverLocal.get().quit();
		}
	}

}
