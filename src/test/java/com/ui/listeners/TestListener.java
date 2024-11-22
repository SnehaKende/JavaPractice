package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtil;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener{

	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	//Job is to decide the look, style and layout of the extent report
	ExtentSparkReporter extentSparkReporter;
	//Job is to to do the heavy-lifting; dumping all the data to the reports
	ExtentReports extentReports;
	//Job is to provide the status of each all the tests; basically, details about each test.
	ExtentTest extentTest;
	
	
	 public void onTestStart(ITestResult result) {
		    logger.info(result.getMethod().getMethodName());
		    logger.info(result.getMethod().getDescription());
		    logger.info(Arrays.toString(result.getMethod().getGroups()));
		    ExtentReportUtility.createExtentReport(result.getMethod().getMethodName());
	}
	 
	 public void onTestSuccess(ITestResult result) {
		    logger.info(result.getMethod().getMethodName()+" "+"PASSED");
		    ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");
	  }
	 
	 public void onTestFailure(ITestResult result) {
		    logger.error(result.getMethod().getMethodName());
		    logger.error(result.getThrowable().getMessage());
		    ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED");
		    
		    Object testClass = result.getInstance();
		    BrowserUtil browserUtil = ((TestBase)testClass).getInstance();
		    logger.info("Capturing Screenshot to the failed test");
		    String screenshotPath = browserUtil.takeScreenshot(result.getMethod().getMethodName());
		    logger.info("Attaching the screenshot to the report");
		    ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}
	 public void onTestSkipped(ITestResult result) {
		 logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
		 ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED");
	  }
	 public void onStart(ITestContext context) {
		   logger.info("Test Suite Started!!");
		   ExtentReportUtility.generateExtentSparkReporter("reports.html");
	  }
	 public void onFinish(ITestContext context) {
		 logger.info("Test Suite Completed!!"); 
		 ExtentReportUtility.flushTest();
	  }
}
