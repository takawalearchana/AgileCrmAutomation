package com.AgileCrmAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AgileCrmAutomation1.BaseClass;

public class LoginAgileCrmTestCase extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		LoginAgileCrmTestCase login = new LoginAgileCrmTestCase();
		login.launchBrowser("chrome");
		driver.get("https://realestateautomation.agilecrm.com");
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("cst21@yopmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test1234");
		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@href='#companies']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='#companies']"))));
		WebElement sendemailbutton = driver.findElement(By.xpath("//button[@id='bulk-email']"));

		// company madule

		/*WebElement selectAllCheckBox = driver.findElement(By.xpath("//span[@id=\"companies-list-view-checkbox\"]"));
		selectAllCheckBox.click();
		sendemailbutton.click();
		System.out.println("mail sent successfully..."); */
	}
}
