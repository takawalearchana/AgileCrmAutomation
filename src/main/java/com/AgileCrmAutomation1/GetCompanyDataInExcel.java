package com.AgileCrmAutomation1;


import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agilecrm.pages.LoginPage;

public class GetCompanyDataInExcel extends BaseClass
{
	public void searchContact() throws FileNotFoundException
	{
      String sheetname = "GetContact12";
      GetCompanyDataInExcel get = new GetCompanyDataInExcel(); 
      launchBrowser("chrome");
		driver.navigate().to("https://testengineer.agilecrm.com/login");
		LoginPage loginpage = new LoginPage();
		LoginPage.login("archu@yopmail.com", "Archu1234");
        waitforVisibilityofElement(driver.findElement(By.xpath("//li[@id='companiesmenu']"))); 
        click(By.xpath("//li[@id='companiesmenu']"), "click on compony menu");
        waitForElementToBeClickable (By.xpath("//a[@class='text-cap '1"));
       List<WebElement> companylist = driver.findElements(By.xpath("//a[@class='text-cap']"));
       List<WebElement> Owner = driver.findElements(By.xpath("//div[@style='width:12em;']"));
        List<WebElement> date= driver.findElements(By.xpath("//div[@style='width:8em;']"));

		for (int i = 1; i < companylist.size(); i++) 
		{
	    String text = companylist.get(i).getText(); 
		String text1= Owner.get(1).getText();
        String text2=date.get(i).getText();

		System.out.println(text);
		System.out.println(text1);
		System.out.println(text2);

		ExcelUtil getExcel= new ExcelUtil();

	//	getExcel.setDataInExcel ("C:\\Users\\Admin\\LoginTestData.xlsx", sheetname, i, 0, text);
	//	getExcel.setDataInExcel ("C:\\Users\\Admin\\LoginTestData.xlsx", sheetname, i, 1, text1);
     //   getExcel.setDataInExcel("C:\\Users\\Admin\\LoginTestData.xlsx", sheetname, i, 2, text2);


		}

//public static void main(Srtring[] args)throws FileNotFoundException 
{ 
	//GetCompanyDataInExcel get=new GetCompanyDataInExcel();
    get.searchContact();

		}


	}

}
