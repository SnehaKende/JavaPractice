package com.ui.test;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.TestListener;
import com.ui.pages.Homepage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest3 extends TestBase{

	//Test script need to be small 
	  // do not write conditional statements, loops, switch case in test methods 
	  //Reduce the use of local variables 
	  //Include at least 1 assertion
	
	  @Test(description ="Verifies if the valid user loign happens", groups =
	  {"Sanity", "Regression"}, dataProviderClass =
	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	  "LoginTestDataProvider") public void LoginTest(User user) {
	  
	  //chaining of methods
	  assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(),
	  user.getPassword()).getUserName(), "Rebecca Varghese"); }
	 
	  @Test(description ="Verifies if the valid user loign happens", 
	  groups ={"Sanity", "Regression"}, 
	  dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
	  dataProvider = "LoginwithCSVDataProvider", 
	  retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class )
	  public void LoginCSVTest(User user) {
		  
		  Logger logger = LoggerUtility.getLogger(this.getClass());
		  logger.info("Starter my login test using CSV reader");
		  
		  assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(),
		  user.getPassword()).getUserName(), "Rebecca Varghese"); 
		  logger.info("Login test using CSV reader completed successfully!!");
	  }
	 
	  @Test(description ="Verifies if the valid user loign happens", groups =
	  {"Sanity", "Regression"}, dataProviderClass =
	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	  "LoginwithExcelDataProvider") public void LoginExcelTest(User user) {
	  
	  assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(),
	  user.getPassword()).getUserName(), "Rebecca Varghese"); }
	 
}
