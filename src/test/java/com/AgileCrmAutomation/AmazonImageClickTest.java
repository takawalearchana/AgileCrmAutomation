package com.AgileCrmAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;

public class AmazonImageClickTest extends BaseClass {
	//public static void main(String[] args) throws AWTException
	@Test
	public void a_login()throws AWTException
	{
		launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		//
		WebElement greatIndianFestival = driver.findElement(By.id("gw-desktop-herotator"));
		Actions action = new Actions(driver);
		action.contextClick(greatIndianFestival).sendKeys(Keys.ENTER).click().build().perform();
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@data-testid='deal-card']/a[3]"));
		for (int j = 0; j < allproducts.size(); j++) {
			String name = allproducts.get(j).getText();
			System.out.println(name);
		}

	}
}
