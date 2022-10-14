package EndToEndTestCaseAgileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation1.BaseClass;

public class ComapnyPage1 extends BaseClass
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
		driver.findElement(By.id("company_name")).sendKeys("Enzigma");
		driver.findElement(By.id("company_url")).sendKeys("https://www.enzigma.in");
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

}
