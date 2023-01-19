package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation1.BaseClass;

public class LoginPage extends BaseClass {
	public static void login(String username, String password) {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();
	}

	public static void Forgotpassword() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("We have sent you an email");
	}

	public static void logout() {
		driver.findElement(By.xpath("//img[@class='pos-rlt pos-t-xs']")).click();
		driver.findElement(By.xpath("//a[contains(@class,\"logout\")]")).click();
	}

}
