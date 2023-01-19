package com.agilecrm.pages;

import java.time.Duration;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation1.BaseClass;

public class CompanyPage extends BaseClass 
{
	String name;
	String url;
	String email;
	String city;
	String state;
	String country;
	public void addCompany(String name,String url,String email,String city,String state,String country)
	{ 
		fluentWait(By.id("companiesmenu"));
		click(By.id("companiesmenu"), "Clicked on company menu");
		WebElement addCompanyButton=driver.findElement(By.xpath("//button[contains(text(),'Add Company')]"));
		Actions action=new Actions(driver);
		action.click(addCompanyButton).build().perform();
		//click(By.xpath("//button[contains(text(),'Add Company')]"), "Clicked on add company button");
		waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("syntel1");
		driver.findElement(By.id("company_url")).sendKeys("https://www.syntel1.in");
		click(By.id("continue-company"), "Click on continue editing button");
		driver.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name=\"email-select\"]"));
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		fluentWait(By.xpath("//select[@id='country']"));
		Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		List<WebElement> selectcountryDropDownlist = select.getOptions();
		for (WebElement element : selectcountryDropDownlist) {
			 String text=element.getAttribute("value");
			if(text.equalsIgnoreCase("IN"))
			{select.selectByValue(text);
				if(!select.isMultiple())
				{
					System.out.println("This is not multiselect dropdown");
				}
				break;
				}
		}
		fluentWait(By.id("company-update"));
		click(By.id("company-update"),"click on update button");
	}
	public void searchcompany(String name)
	{	fluentWait(By.id("companiesmenu"));
		click(By.id("companiesmenu"), "Clicked on company menu");
		click(By.xpath("//ul[@class='nav navbar-nav agile-menu']/descendant::button[@type='button']"), "click on search menu");
		click(By.xpath("//*[@id='advanced-search-fields-group']/li[1]/a"),"Click on all checkbox");
		fluentWait(By.id("companiesmenu"));
		click(By.xpath("//*[@id='advanced-search-fields-group']/li[3]"),"click on companies menu");
		WebElement searchtext=driver.findElement(By.id("searchText"));
		searchtext.sendKeys(name);
		searchtext.click();
		click(By.id("search-results"),"click on search");
		
	}
	public void updateCompany(String city)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//div[@class='table-resp']"),"click on company name");
		click(By.xpath("//a[@data-original-title='Edit']/i"),"click on edit option");
		driver.findElement(By.id("city")).sendKeys("Pune");
		waitForElementToBeClickable(By.id("company-update"));
		click(By.id("company-update"),"click on update button");
		System.out.println("Company update sucessfully:" + name);
	}
	public void deleteCompany()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		click(By.xpath("//i[@class='material-icons more_vert v-middle']"),"click on kebab menu");
		click(By.xpath("//div[@class='dropdown ibm open']/ul/li[4]/a"),"click on delete button");
		click(By.id("success_callback"),"click on yes option");
		System.out.println("contacts deleted successfully...");
	}
}

	
		
	


