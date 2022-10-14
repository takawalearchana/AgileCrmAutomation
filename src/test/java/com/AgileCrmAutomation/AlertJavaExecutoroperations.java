package com.AgileCrmAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import com.AgileCrmAutomation1.BaseClass;

public class AlertJavaExecutoroperations extends BaseClass {
	public static void main(String[] args) throws NumberFormatException {
		launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('This is sample alerts!');");
	    //driver.switchTo().alert().dismiss();
		
		//generate confirmation alert
	      js.executeScript("Confirm('This is sample alerts!');");
		
		//generate promot alert
	      js.executeScript("Prompt('This is sample alerts!');");
	    
		//enter the text on the alert
		  Alert alert=driver.switchTo().alert();
	      alert.sendKeys("This is sample text...");
	       alert.accept();
	    //get the msg from alert
	      String alerttext=alert.getText();
	      System.out.println(alerttext);
	    
	   //for vertical scrolling
	      //js.executeScript("window.scrollBy(0,700)");
	      //js.executeScript("window.scrollBy(0,-700)"); */
}
}
