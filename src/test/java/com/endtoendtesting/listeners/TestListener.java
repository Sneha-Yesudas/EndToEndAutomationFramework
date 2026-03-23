package com.endtoendtesting.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.endtoendtesting.test.TestBase;
import com.endtoendtesting.utility.BrowserUtility;
import com.endtoendtesting.utility.ExtentReportUtility;
import com.endtoendtesting.utility.LoggerUtility;
import com.endtoendtesting.utility.WebDriverUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLoggerInstance(this.getClass());
	ExtentSparkReporter sparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "" + "On test Started");
//		extentTest=extentReports.createTest(result.getMethod().getMethodName(), "Test Started");
		ExtentReportUtility.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		logger.error(result.getMethod().getMethodName() + "" + "Test Failed");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+"Fail");
		Object universalObject=result.getInstance();
		BrowserUtility browsetUtility=((TestBase)universalObject).getInstance();
		String path=browsetUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(path, "FailedCase");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		logger.info(result.getMethod().getMethodName() + "" + "Test Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+"Success");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		logger.warn(result.getMethod().getMethodName() + " " + "Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");
	}

	@Override
	public void onStart(ITestContext context) {

		logger.info("Test suite Started");
//		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//report.html");
//		extentReports=new ExtentReports();
//		extentReports.attachReporter(sparkReporter);//heavy lifting
		
		///Thread safe
		ExtentReportUtility.createExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
		ExtentReportUtility.flush();

	}

}
