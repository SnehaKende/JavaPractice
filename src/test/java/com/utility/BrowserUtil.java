package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.w3c.dom.Text;

import com.constants.Browser;

public abstract class BrowserUtil {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}
	/**
	 * @param driver
	 */
	public BrowserUtil(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtil(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}else {
			System.err.print(false);
		}
	}
	public BrowserUtil(Browser browser) {
		if(browser==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}else if(browser==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}else if(browser==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.print(false);
		}
	}

	public void launchURL(String url) {
		driver.get().get(url);
	}
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	public void clickOn(By element) {
		WebElement SignInElement = driver.get().findElement(element);
		SignInElement.click();
	}
	
	public void enterText(By TextBoxLocator, String valueToEnter) {
		WebElement TextBoxElement = driver.get().findElement(TextBoxLocator);
		TextBoxElement.sendKeys(valueToEnter);
	}
	public String getVisibleText(By locator) {
		WebElement Element = driver.get().findElement(locator);
		return Element.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		Date date = new Date();
		SimpleDateFormat  format =  new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		
		String path = System.getProperty("user.dir") + "//screenshots//" + name+"-"+timeStamp;
		
		File fileOfScrteenshot = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(fileOfScrteenshot, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
