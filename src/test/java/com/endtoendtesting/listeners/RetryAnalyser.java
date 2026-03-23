package com.endtoendtesting.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	private int maxCount=3;
	private int currentCount=0;
	

	@Override
	public boolean retry(ITestResult result) {
		if(currentCount<maxCount) {
			currentCount++;
			return true;
			
		}
		return false;
	}

}
