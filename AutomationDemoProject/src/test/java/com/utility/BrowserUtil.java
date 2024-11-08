package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Text;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public BrowserUtil(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void launchURL(String url) {
		driver.get(url);
	}
	public void clickOn(By element) {
		WebElement SignInElement = driver.findElement(element);
		SignInElement.click();
	}
	
	public void enterText(By TextBoxLocator, String valueToEnter) {
		WebElement TextBoxElement = driver.findElement(TextBoxLocator);
		TextBoxElement.sendKeys(valueToEnter);
	}
}
