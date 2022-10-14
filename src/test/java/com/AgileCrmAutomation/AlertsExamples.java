package com.AgileCrmAutomation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;

public class AlertsExamples extends BaseClass {
	//public static void main(String[] args) throws NumberFormatException 
	@Test(groups= {"Regression"})
	@Parameters({"browser"})
	public  void main(String browser)
	{
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//To display msg on the screen
		js.executeScript("alert('This is sample alerts!');");
		//To switch the alert
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.switchTo().alert().accept();

	}
}
