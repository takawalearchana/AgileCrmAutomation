package com.agilecrm.pages;

import com.AgileCrmAutomation1.BaseClass;

public class LoginAgileCrm  extends BaseClass
{
	public static void main(String[] args) {
	// Launch Browser code
	LoginAgileCrm login = new LoginAgileCrm();
	login.launchBrowser("chrome");
	driver.navigate().to("https://realestateautomation.agilecrm.com");
	LoginPage loginpage = new LoginPage();
	loginpage.login("cst8@yopmail.com", "Test1234");

}

}
