package com.ui.test;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.Homepage;
import com.utility.BrowserUtil;
import com.utility.LoggerUtility;

public class TestBase  {

	protected Homepage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup() {
		logger.info("Load the Homepage of the website");
		homePage = new Homepage(CHROME);
	}
	
	public BrowserUtil getInstance() {
		return homePage;
	}
}
