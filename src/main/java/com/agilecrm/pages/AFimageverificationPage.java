package com.agilecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation1.BaseClass;


public class AFimageverificationPage extends BaseClass 
	{
	public void Amazon()
	{
		AFimageverificationPage verify=new AFimageverificationPage ();
		verify.launchBrowser("edge");
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> elements=driver.findElements(By.tagName("img"));
	
		for(WebElement e:elements)
		{
			String link=e.getAttribute("src");
			if(link!=null && link.startsWith("http"))
			{
				System.out.println(link);
			}
		}
	}
	public void Flipkart()
	{
		AFimageverificationPage verify=new AFimageverificationPage ();
	    verify.launchBrowser("chrome");
	     driver.navigate().to("https://www.flipkart.com/");
	     driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		List<WebElement> elements=driver.findElements(By.tagName("img"));
		for(WebElement e:elements)
		{
			String link=e.getAttribute("src");
			if(link!=null && link.startsWith("http"))
			{
				System.out.println(link);
			}
		}
		
	}
	
	}
	


