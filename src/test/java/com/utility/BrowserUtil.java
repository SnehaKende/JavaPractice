package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.w3c.dom.Text;

import com.constants.Browser;

public abstract class BrowserUtil {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public BrowserUtil(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtil(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.err.print(false);
		}
	}
	public BrowserUtil(Browser browser) {
		if(browser==Browser.CHROME) {
			driver = new ChromeDriver();
		}else if(browser==Browser.EDGE) {
			driver = new EdgeDriver();
		}else if(browser==Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
		else {
			System.err.print(false);
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void launchURL(String url) {
		driver.get(url);
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void clickOn(By element) {
		WebElement SignInElement = driver.findElement(element);
		SignInElement.click();
	}
	
	public void enterText(By TextBoxLocator, String valueToEnter) {
		WebElement TextBoxElement = driver.findElement(TextBoxLocator);
		TextBoxElement.sendKeys(valueToEnter);
	}
	public String getVisibleText(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element.getText();
	}
}
