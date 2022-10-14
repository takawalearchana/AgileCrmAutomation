package com.AgileCrmAutomation;

import org.openqa.selenium.By;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.LoginPage;

public class ContactSelectcheckBoxTestCase extends BaseClass{
	public void main(String[]args)
	{
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage loginpage = new LoginPage();
		loginpage.login("cst21@yopmail.com", "Test1234");
		click(By.id("contactsmenu"), "Click on Contact Menu");
		click(By.xpath("//label[@class='i-checks i-checks-sm p-b-none v-middle']/input"),"Click on check box");
		click(By.xpath("//button[text()='Delete']"),"Click on delete button");
		click(By.id("success_callback"),"Click on yes button");
		System.out.println("Contact deleted successfully");

		
	}

}
