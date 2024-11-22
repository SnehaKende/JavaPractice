package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.environments;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	private static final int MAX_NO_OF_ATTEMPTS = JSONUtility.readJSON(environments.QA).getMAX_NO_OF_ATTEMPTS();
	private static int currentAttempt = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		//ItestResult is giving us information about test result 
		
		if(currentAttempt<=MAX_NO_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

	
}
