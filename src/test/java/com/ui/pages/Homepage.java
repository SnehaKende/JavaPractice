package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.environments.*;
import com.utility.BrowserUtil;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final class Homepage extends BrowserUtil{
//*********PAGE OBJECT DESIGN PATTERN****************
	public Homepage(Browser browser) {
		super(browser);
		launchURL(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}

	//if the variable is going to be final, it is also going to be static
	static final By SIGN_IN_LOCATOR = By.xpath(".//a[@class='login']");  //it is not instance variable; it is class variable because it is static

	public Loginpage goToLoginPage() {//Page functions------------> // cannot return void
		clickOn(SIGN_IN_LOCATOR);
		
		Loginpage login = new Loginpage(getDriver());
		return login;
	}
}
