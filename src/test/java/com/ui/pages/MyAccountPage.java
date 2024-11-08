package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public final class MyAccountPage  extends BrowserUtil{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By USER_NAME_VALUE = By.xpath(".//a[@title='View my customer account']");
	
	public String getUserName() {
		return getVisibleText(USER_NAME_VALUE);
		
	}
}
