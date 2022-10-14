package EndToEndTestCaseAgilecrmautomation;

import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.CompanyPage;
import com.agilecrm.pages.LoginPage;

public class CompanyPageTestCase1 extends BaseClass 
{
public static void main(String[] args)
	{
		launchBrowser("chrome");
		driver.navigate().to("https://testengineer.agilecrm.com/login");
		LoginPage loginpage = new LoginPage();
		LoginPage.login("archu@yopmail.com", "Archu1234");

		CompanyPage company=new CompanyPage();
		company.addCompany("Enzigma","https://www.Enzigma.in","Enzigma@gmail.com", "pune"," Maharashtra","");
		
		
		
	}
}

