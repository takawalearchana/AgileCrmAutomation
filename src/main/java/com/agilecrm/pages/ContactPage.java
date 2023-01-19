package com.agilecrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation1.BaseClass;

public class ContactPage extends BaseClass {
	String firstname;
	String lastname;
	String company;
	String email;

	public void addcontact(String firstname, String lastname, String company, String email)throws InterruptedException
	{ 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//click(By.id("contactsmenu"), "Click on Contact Menu");
		 waitForElementToBeClickable(By.id("contactsmenu"));
		 click(By.id("contactsmenu"), "Click on Contact Menu");
		 driver.findElement(By.xpath("//button[contains(text(),'Add Contact')]"));
		click(By.xpath("//*[@id='view-list']/div/button/i"),"select all check box selected");
		Thread.sleep(5000);
		WebElement fname = driver.findElement(By.id("fname"));
		fname.sendKeys(firstname);
		WebElement lname = driver.findElement(By.id("lname"));
		lname.sendKeys(lastname);
		WebElement comp = driver.findElement(By.id("contact_company"));
		comp.sendKeys(company);
		WebElement mail = driver.findElement(By.id("email"));
		mail.sendKeys(email);
		click(By.id("person_validate"), "Record save successfully");
		}
	public void searchcontact(String name) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		click(By.id("contactsmenu"), "Click on Contact Menu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//ul[@class='nav navbar-nav agile-menu']/descendant::button[@type='button']"), "click on search menu");
		click(By.xpath("//*[@id='advanced-search-fields-group']/li[1]/a"),"Click on all checkbox");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//*[@id='advanced-search-fields-group']/li[2]"),"click on contact menu");
		WebElement searchtext=driver.findElement(By.id("searchText"));
		searchtext.sendKeys(name);
		searchtext.click();
		click(By.id("search-results"),"click on search");
	}
	public void updateContact(String city,String state)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//click(By.xpath("//div[@class='table-resp']"),"click on company name");
		click(By.xpath("//a[@data-original-title='Edit']/i"),"click on edit option");
		driver.findElement(By.id("city")).sendKeys("Pune1");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		click(By.id("update"),"click on update button");
		System.out.println("Company update sucessfully:" + city);
	}
	public void deleteContact()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//i[@class='material-icons more_vert v-middle']"),"click on kebab menu");
		click(By.xpath("//div[@class='dropdown ibm open']/ul/li[10]"),"click on delete button");
		click(By.id("success_callback"),"click on yes option");
		System.out.println("contacts deleted successfully...");
	}
}




