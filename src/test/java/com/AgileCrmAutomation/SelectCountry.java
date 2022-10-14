package com.AgileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.LoginPage;

public class SelectCountry extends BaseClass {
	//public static void main(String[] args)
	@Test 
	public void a_selectCountry()
	{
		SelectCountry country = new SelectCountry();
		country.launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage loginpage = new LoginPage();
		loginpage.login("cst21@yopmail.com", "Test1234");
		click(By.id("companiesmenu"), "Clicked on company menu");
		click(By.xpath("//button[contains(text(),'Add Company')]"), "Clicked on add company button");
		waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("Scaler India");
		click(By.id("continue-company"), "Click on continue editing button");
		fluentWait(By.xpath("//select[@id='country']"));
		Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		List<WebElement> selectcountryDropDownlist = select.getOptions();
		for (WebElement element : selectcountryDropDownlist) {
			 String text=element.getAttribute("value");
			//String text = element.getText();
			//System.out.println(text);
			if(text.equalsIgnoreCase("IN"))
			{select.selectByValue(text);
				if(!select.isMultiple())
				{
					System.out.println("This is not multiselect dropdown");
				}
				break;
				}
		}
	}
}
