package com.AgileCrmAutomation;

import org.testng.annotations.Test;

import com.AgileCrmAutomation1.BaseClass;
import com.agilecrm.pages.AFimageverificationPage;

public class IMGverificationTestcase extends BaseClass 
{
	//public static void main(String[] args)
	@Test 
	public void a_imgVerification()
	{
		AFimageverificationPage image=new AFimageverificationPage ();
		image.Amazon();
		//image.Flipkart();
	}
}
