package com.agilecrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation1.BaseClass;

public class DealPage extends BaseClass
{       
	    String name;
		//String dealvalue;
		
		public String addDeals(String name) throws InterruptedException
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			click(By.id("dealsmenu"), "Click on Deals Menu");
			click(By.xpath("//button[@href=\"#deals-add\"]"), "Add deals");
	         Thread.sleep(3000); 
	          WebElement name1 = driver.findElement(By.xpath("id('opportunityForm')/descendant::div[2]/span/input"));
			  name1.sendKeys(name);
	          WebElement value = driver.findElement(By.xpath("//div[contains(@class,'controls value_box')]/descendant::div/input"));
			  value.sendKeys("100");
			 click(By.xpath("//div[@id=\"deals-new-footer\"]/a"),"Click on Save Button");
			 return(name);
			}
		
		public void archiveDeals()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			click(By.xpath("//div[@class='media-body']/a"),"Click on contact");
			click(By.xpath("//span[@class='caret m-l-none']"),"Click on button");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			click(By.id("dealdetail-archive"),"Click on archive menu");
			click(By.id("deal-quick-archive"), "Click on yes button");
		
		}

	}
