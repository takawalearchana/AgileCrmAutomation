package EndToEndTestCaseAgilecrmautomation;

import com.AgileCrmAutomation.ContactTestCase;
import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.ContactPage;
import com.agilecrm.pages.LoginPage;

import EndToEndTestCaseAgileCrmAutomation.ContactPage1;

public class ContactPageTestCase1 extends BaseClass{
	public static void main(String[] args) throws InterruptedException 
	{
		
	   launchBrowser("chrome");
		driver.get("https://testengineer.agilecrm.com/login");
		LoginPage loginpage = new LoginPage();
		loginpage.login("archu@yopmail.com", "Archu1234");
		
	  ContactPage1 contact = new ContactPage1();
	  contact.addcontact("siddhi","jadhav","student","siddhi@gmail.com");
	  contact.statusChecktoActivityMenu();
	  contact.Trashmenu();
	}
}
