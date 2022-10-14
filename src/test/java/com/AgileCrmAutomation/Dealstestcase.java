package com.AgileCrmAutomation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.DealPage;
import com.agilecrm.pages.LoginPage;

public class Dealstestcase extends BaseClass 
{
	//public static void main(String[] args) throws InterruptedException 
	@Test 
	public void a_login() throws InterruptedException
	{
		Dealstestcase deal = new Dealstestcase();
		deal.launchBrowser("chrome");
		driver.get("https://learnautomation.agilecrm.com");
		LoginPage loginpage = new LoginPage();
		loginpage.login("cst21@yopmail.com", "Test1234");

		
		DealPage deal1=new DealPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//li[@id='dealsmenu']/child::a"), "Click on Deals Menu");
		ArrayList<String> dealName1=new ArrayList<>();
		for(int i=1;i<=10;i++)
		{
			String name=deal1.addDeals("viru_1"+i);
		     dealName1.add(name);
		}
		
		
		//deal1.archiveDeals();
}
}
