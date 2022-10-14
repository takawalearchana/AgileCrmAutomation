package com.AgileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;

public class AmazonApplianceSearch extends BaseClass {
	//public static void main(String[]args)
	@Test(groups= {"Regression","Sanity"})
	@Parameters({"browser"})
	
	public void main( String browser)
	{
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
		selectDropdownValByText(driver.findElement(By.id("searchDropdownBox")),"Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.id("nav-search-submit-button"),"Click on search button");
		List<WebElement> appliancenames=driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> applianceprices=driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		
		for (int i = 0;i<appliancenames.size();i++)
		{
			String name= appliancenames.get(i).getText();
		    String price=applianceprices.get(i).getText();
			System.out.println(name +" :"+ price);
		}
		
	}

}
