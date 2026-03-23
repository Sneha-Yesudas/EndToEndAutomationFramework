package com.endtoendtesting.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endtoendtesting.enums.Browser;

public abstract class WebDriverUtility {

	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public WebDriverUtility(WebDriver driver) {
		super();
		this.driver .set(driver); 
	}
	
	
	public WebDriverUtility(Browser browser) {
		if(browser==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(Browser.FIREFOX==browser) {
			driver.set(new FirefoxDriver());
		}
		else if(Browser.EDGE==browser) {
			driver.set(new EdgeDriver());;
		}
		else {
			System.out.println("Enter Proper BrowserValue");
		}
	}

	public void navigatetoURL(String url) {
		driver.get().get(url);
	}

	public void maximizewindow() {
		driver.get().manage().window().maximize();
	}

	public void sendKeys(String text, By locator) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);

	}

	public void click(By locator) {

		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void waitforVisiblityofElements(By locator) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void iterateThroughElementsandClick(By elementToBeClickedLocator, By productTextToBeMatched, String text) {
		List<WebElement> elementToBeClicked = driver.get().findElements(elementToBeClickedLocator);
		List<WebElement> productsText = driver.get().findElements(productTextToBeMatched);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int index = 0;
		for (WebElement element : productsText) {
			if (element.getText().equals(text)) {
				js.executeScript("arguments[0].click()", elementToBeClicked.get(index));
				break;
			}
			index++;
		}

	}

	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();

	}

	public String getTextFromListOfElements(By locator, String text) {

		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : elements) {

			if (element.getText().equals(text)) {
				return element.getText();

			}
		}

		return "No products added to cart";
	}

	public void waitAndClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].click()", element);

	}

	public void tearDown() {

		driver.get().quit();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot ts=(TakesScreenshot)driver.get();
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//screenshot//"+name;	
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
