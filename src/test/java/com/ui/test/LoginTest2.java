package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Browser;
import com.ui.pages.Homepage;
import com.ui.pages.Loginpage;

public class LoginTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();   //Loose coupling
		//whenever chromedriver object is created and executed, it launches the chrome browser.
		
		Homepage homePage = new Homepage(Browser.CHROME);
		Loginpage loginPage = homePage.goToLoginPage();
		
		loginPage.DoLoginWith("tofiveg296@operades.com", "RebVar#3456");
}

}
