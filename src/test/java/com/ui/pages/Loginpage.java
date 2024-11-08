package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public final class Loginpage extends BrowserUtil{

	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	//browser.enterText(emailField, "tofiveg296@operades.com");
	
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	//browser.enterText(password, "RebVar#3456");
	
	private static final By SUBMIT_BTN_LOCATOR = By.id("SubmitLogin");
	//browser.clickOn(submitLoginBtn);
	public MyAccountPage DoLoginWith(String emailAddress, String password) {
		
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);
		
		MyAccountPage myAccount = new MyAccountPage(getDriver());
		return myAccount;
	}
}
