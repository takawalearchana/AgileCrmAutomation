package com.AgileCrmAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;

public class AmazonElectronicsSearch extends BaseClass
{
	//public static void main(String[]args)throws NumberFormatException
	@Test(groups= {"Regression"})
	@Parameters({"browser"})
	
	public void a_login(String browser)
	{
    launchBrowser(browser);
	driver.navigate().to("https://www.amazon.in");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	selectDropdownValByText(driver.findElement(By.id("searchDropdownBox")),"Electronics");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
	click(By.id("nav-search-submit-button"),"Click on search button");
	List<WebElement> laptopNames=driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
	List<WebElement> laptopPrice=driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
	
	for (int j=0;j<laptopNames.size();j++)
	{
	    String price=laptopPrice.get(j).getText();
		String price1=price.replace(",","");
        String name= laptopNames.get(j).getText();
	
      int parseint=Integer.parseInt(price1);
      if( parseint>30000)
		System.out.println(name +" :"+ price);
	}
}
	
	}



