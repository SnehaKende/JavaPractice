package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtil;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();   //Loose coupling
		//whenever chromedriver object is created and executed, it launches the chrome browser.
		
		BrowserUtil browser = new BrowserUtil(wd);
		
		//give URL to launch
		browser.launchURL("https://www.automationpractice.pl/index.php");
		wd.manage().window().maximize();
		
		By signInLocator = By.xpath(".//a[@class='login']");
		browser.clickOn(signInLocator);
		
		By emailField = By.id("email");
		browser.enterText(emailField, "tofiveg296@operades.com");
		
		By password = By.id("passwd");
		browser.enterText(password, "RebVar#3456");
		
		By submitLoginBtn = By.id("SubmitLogin");
		browser.clickOn(submitLoginBtn);
}

}
