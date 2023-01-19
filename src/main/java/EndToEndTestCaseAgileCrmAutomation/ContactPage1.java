package EndToEndTestCaseAgileCrmAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation1.BaseClass;

public class ContactPage1 extends BaseClass
	{
		String firstname;
		String lastname;
		String company;
		String email;

		public void addcontact(String firstname, String lastname, String company, String email)throws InterruptedException
		{ 
			 waitForElementToBeClickable(By.id("contactsmenu"));
			 click(By.id("contactsmenu"), "Click on Contact Menu");
			 waitForElementToBeClickable(By.xpath("//button[contains(text(),'Add Contact')]"));
			 driver.findElement(By.xpath("//button[contains(text(),'Add Contact')]"));
			click(By.xpath("//*[@id='view-list']/div/button/i"),"select all check box selected");
			Thread.sleep(5000);
			WebElement fname = driver.findElement(By.id("fname"));
			fname.sendKeys(firstname);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement lname = driver.findElement(By.id("lname"));
			lname.sendKeys(lastname);
			WebElement comp = driver.findElement(By.id("contact_company"));
			comp.sendKeys(company);
			WebElement mail = driver.findElement(By.id("email"));
			mail.sendKeys(email);
			click(By.id("person_validate"), "Record save successfully");
		}
		public void statusChecktoActivityMenu()
		{
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			fluentWait(By.xpath("//i[@class='material-icons hourglass_full']"));
			click(By.xpath("//i[@class='material-icons hourglass_full']"),"click on activity menu");
		    click(By.xpath("//a[@class='popover_contact']"),"click on name");
			click(By.xpath("//i[contains(@class,'material-icons more_vert')]"),"click on kebab menu");
			click(By.xpath("//div[@class='dropdown ibm open']/ul/li[10]"),"click on delete button");
			click(By.id("success_callback"),"click on yes option");
			System.out.println("contacts deleted successfully...");
		}
		public void Trashmenu()
		{
			click(By.xpath("//i[@class='material-icons delete']"),"click on trash menu");
			System.out.println("Deleted record display in trash");
			click(By.id("trash-list-view-checkbox"),"click on trash checkbox");
			click(By.id("bulk-trashed-contacts-delete"),"click on Bulkdelete button");
			click(By.id("success_callback"),"click on Bulk Contact delete yes option");
			System.out.println("contacts deleted successfully...");
		}

}
