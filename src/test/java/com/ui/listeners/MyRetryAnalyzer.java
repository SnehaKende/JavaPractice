package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		//ItestResult is giving us information about test result 
		return false;
	}

	
}
