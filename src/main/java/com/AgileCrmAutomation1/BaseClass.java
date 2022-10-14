package com.AgileCrmAutomation1;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
	public static ExtentTest Logger;
	public static WebDriver driver = null;

	public static void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Tool\\chromedriver_win32 (2)\\chromedriver.exe");
			//WebDriverManager.Chromedriver().setup();
			//driver = new ChromeDriver(option);
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Tool\\edgedriver_win64\\msedgedriver.exe");
			//WebDriverManager.EdgeDriver().setup();
			//driver = new EdgeDriver(option);
			driver = new EdgeDriver();
			break;

		case "mozila":
			System.setProperty("webdriver.mozila.driver", "C:\\Tool\\geckodriver-v0.31.0-win32\\geckodriver.exe`");
			//WebDriverManager.FirefoxDriver().setup();
			//driver = new FirefoxDriver(option);
			driver = new FirefoxDriver();
			break;
			
		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Tool\\chromedriver_win64\\msedgedriver.exe");
			//WebDriverManager.Chromedriver().setup();
			//driver = new ChromeDriver(option);
			driver = new ChromeDriver();
		}
	}
	//Click method
	public static void click(By by, String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		System.out.println(msg);
	}
//Visibility of element method
	public static void waitforVisibilityofElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	//Wait for element to be clickable method
	public static void waitForElementToBeClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	//Wait for element to be present method
	public static void waitForElementToBePresent(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}
	//Wait for element to be clickable webelement method
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
    //Fluentwait method
	public static void fluentWait(final By by) 
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("waiting for element to be available....");
				return driver.findElement(by);
			}
		});
	}
	//selectDropdownValByInde method
	public static void selectDropdownValByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	//selectDropdownValByText method
	public static void selectDropdownValByText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	//SelectDropdownValByValue method
	public static void SelectDropdownValByValue(WebElement element,String val)
	{
		Select select=new Select(element);
		select.selectByValue(val);		
		}
	//for updated version of chrome
	private static ChromeOptions setChromeCapabilities()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		Map<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
	return option;
	}
	//for updated version of Edge
		private static EdgeOptions setEdgeCapabilities()
		{
			EdgeOptions option=new EdgeOptions();
			option.addArguments("start-maximized");
			Map<String, Object> prefs=new HashMap<String, Object>();
			prefs.put("download.default_directory", "/directory/path");
			option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;
		}

		//for updated version of mozila
		private static FirefoxOptions setFirefoxCapabilities()
		{
			FirefoxOptions option=new FirefoxOptions();
			option.addArguments("start-maximized");
			Map<String, Object> prefs=new HashMap<String, Object>();
			prefs.put("download.default_directory", "/directory/path");
			//option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			return option;
		}		
}




	