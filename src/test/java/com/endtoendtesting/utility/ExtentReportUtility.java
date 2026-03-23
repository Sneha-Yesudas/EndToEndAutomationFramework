package com.endtoendtesting.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	private static ExtentReports reports;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public static void createExtentReport() {
		ExtentSparkReporter sparker=new ExtentSparkReporter(System.getProperty("user.dir")+"//Extent Reports//report.html");
	    reports=new ExtentReports();
		reports.attachReporter(sparker);
	}
	
	
	public static void createTest(String testname) {
		ExtentTest test=reports.createTest(testname);
		extentTest.set(test);
		
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flush() {
		reports.flush();
	}

}
