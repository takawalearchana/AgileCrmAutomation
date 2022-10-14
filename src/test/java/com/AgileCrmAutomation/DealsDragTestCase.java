package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.DealDragDroppage;
import com.agilecrm.pages.LoginPage;


public class DealsDragTestCase extends BaseClass {
	//public static void main(String[] args) throws Exception
	
	@Test(groups= {"Regression","Sanity"})
	@Parameters({"browser","username","password"})
	
	public void a_login(String browser,String username,String password) throws Exception
	{
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage loginpage = new LoginPage();
		loginpage.login("cst21@yopmail.com","Test1234");
		click(By.id("dealsmenu"), "Click on Deals menu");
		DealDragDroppage dealspage = new DealDragDroppage();
		dealspage.changeDealsStatus("New", "Won");

	}
}
