package com.ui.test;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.Homepage;
import com.ui.pojo.User;

public class LoginTest3 {

	Homepage homePage;
	
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup() {
		homePage = new Homepage(CHROME);
	}
	
	  @Test(description ="Verifies if the valid user loign happens", groups =
	  {"Sanity", "Regression"}, dataProviderClass =
	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	  "LoginTestDataProvider") public void LoginTest(User user) { 
		  //Test script need to be small 
		  // do not write conditional statements, loops, switch case in test methods 
		  //Reduce the use of local variables 
		  //Include at least 1 assertion
	  
	  //chaining of methods
	  assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(),
	  user.getPassword()).getUserName(), "Rebecca Varghese"); }
	  
	  @Test(description ="Verifies if the valid user loign happens", groups =
	  {"Sanity", "Regression"}, dataProviderClass =
	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	  "LoginwithCSVDataProvider") public void LoginCSVTest(User user) {
	  
	  assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(),
	  user.getPassword()).getUserName(), "Rebecca Varghese"); }
	 

	@Test(description ="Verifies if the valid user loign happens", groups = {"Sanity", "Regression"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginwithExcelDataProvider")
	public void LoginExcelTest(User user) {
		
		assertEquals(homePage.goToLoginPage().DoLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Rebecca Varghese");
}
}
