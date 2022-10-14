package com.AgileCrmAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class ContactTestCase extends BaseClass
{
 public static void main(String[] args) throws InterruptedException 
	//@Test
	//public void contacts() throws InterruptedException
	{
		ContactTestCase contact = new ContactTestCase();
		contact.launchBrowser("chrome");
		driver.get("https://testengineer.agilecrm.com/login");
		LoginPage loginpage = new LoginPage();
		loginpage.login("archu@yopmail.com", "Archu1234");
		
	  ContactPage contact1 = new ContactPage();
	 
	  contact1.addcontact("sharu","Kohali","cricket","virat@gmail.com");
	  contact1.searchcontact("sharu");
	  contact1.updateContact("Pune1","Maharashtra");
	  contact1.deleteContact();
	 
	} 
}