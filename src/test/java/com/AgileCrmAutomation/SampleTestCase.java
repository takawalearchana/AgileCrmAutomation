package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.ContactPage;
import com.agilecrm.pages.LoginPage;

public class SampleTestCase extends BaseClass 
{       
	@BeforeTest
		public void beforeTest()
		{
			System.out.println("This is beforeTest method");
		}
		
		@BeforeClass
		public void beforeclass()
		{
			System.out.println("This is beforeclass method");
		}
		@AfterClass
		public void afterclass()
		{
			System.out.println("This is afterclass method");
		}
		@BeforeMethod
		public void beforeMethod()
		{
			System.out.println("This is before method");
		}
		
		@Test
		public void a_login()
		{
			ContactTestCase contact = new ContactTestCase();
			contact.launchBrowser("chrome");
			driver.get("https://learnautomation.agilecrm.com");
			LoginPage loginpage = new LoginPage();
			loginpage.login("cst21@yopmail.com", "Test1234");
		}
		
		@ Test
		public void b_addContact() throws InterruptedException
		{
		  ContactPage contact1 = new ContactPage();
		  waitForElementToBeClickable(By.id("contactsmenu"));
		 click(By.id("contactsmenu"), "Click on Contact Menu");
		  contact1.addcontact("Virat","Kohali","cricket","virat@gmail.com");
		  contact1.searchcontact("virat");
		  contact1.updateContact("Pune1","Maharashtra");
		  contact1.deleteContact();
		 
		} 
		
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("This is after method");
		}
		@AfterTest
		public void afterTest()
		{
			System.out.println("This is afterTest method");
		}
		
	}
  
