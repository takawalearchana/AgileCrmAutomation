package com.AgileCrmAutomation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;

import junit.framework.Assert;

public class TestCase2  extends BaseClass
{ 

	@BeforeTest
      public void beforeTest() 
	{
	System.out.println("This is beforeTest method..");
 launchBrowser("chrome");
 driver.get("https://google.com");
	}
 @BeforeMethod
public void beforeMethod()
	{ 
	 System.out.println("This is beforemethod...");
	}
	
	@Test 
public void test1() 
	{
	System.out.println("This is test1 method");

	}
    @Test
public void test2()
     {
		System.out.println("This is test2 method"); 
		System.out.println(driver.getTitle());
		Assert.fail("Test2 failed");
    }

 @Test(dependsOnMethods = "test2")
 public void test3() 
 {
	 
 }
 }
