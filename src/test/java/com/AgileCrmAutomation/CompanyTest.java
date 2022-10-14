package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.CompanyPage;
import com.agilecrm.pages.LoginPage;

public class CompanyTest extends BaseClass {
//public static void main(String[] args)  
	@Test 
	public void a_login()
	
	{
		launchBrowser("chrome");
		driver.navigate().to("https://testengineer.agilecrm.com/login");
		LoginPage loginpage = new LoginPage();
		LoginPage.login("archu@yopmail.com", "Archu1234");
	}
	@Test
    public void b_add()
    {
	
		CompanyPage company=new CompanyPage();
		company.addCompany("syntel1","https://www.nxt1.in","syntel1@gmail.com", "pune"," Maharashtra","");
		company.searchcompany("syntel1");
		company.updateCompany("Pune");
		company.deleteCompany();
		
		
	}
}
		
		
		
		
		
		
		
		
		
		//email dropdown code
		
		/* click(By.id("companiesmenu"), "Clicked on company menu");
		click(By.xpath("//button[contains(text(),'Add Company')]"), "Clicked on add company button");
		waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("Google Instagram123 ");
		click(By.id("continue-company"), "Click on continue editing button");
		waitForElementToBeClickable(By.id("company_name"));
		fluentWait(By.name("email-select"));
		Select select = new Select(driver
				.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name=\"email-select\"]")));
		List<WebElement> emailDropDownlist = select.getOptions();
		for (WebElement element : emailDropDownlist) {
			String text = element.getAttribute("value");
			if (text.equalsIgnoreCase("primary")) {
				select.selectByValue(text);
				if (!select.isMultiple()) {
					System.out.println("This is not multiselect dropdown");
				}
				break;
			}*/
			// System.out.println(text);

		
	

