package com.AgileCrmAutomation;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.AgileCrmAutomation1.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestListeners extends BaseClass implements ITestListener,ISuiteListener
{
	ExtentReports extentReport;
	ExtentSparkReporter sparkReport;

// On start method of ISuiteListener Interface
public void onStart(ISuite suite) 
 { 
   LocalDateTime dateTime= LocalDateTime.now();
  String timeStamp=dateTime.format(DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm"));
  String folderName="Report_"+ timeStamp;		
  System.out.println(folderName);
  String reportPath = System.getProperty("user.dir")+"//ExecutionResult//"+folderName;
  //create file class instance to take control of folder path
   File file=new File(reportPath);
  //check if the folder exist; if not present then create new 
 if(!file.exists())
{ 
	 file.mkdir(); //create new file or folder at the desired path
} 
setExtentReportDetails();
}
//On finish method of ISuitelistener Interface public void onFinish(ISuite suite)
public void onFinish(ISuite suite)
{
System.out.println("This is onFinish Method of Suite");
driver.quit();
}
public void onStart(ITestContext context) 
{
	System.out.println("This is onStart method of Test");
}

public void onFinish(ITestContext context) 
{
System.out.println("This is onFinish method of Test");
}
public void onTestStart (ITestResult result)
{
	System.out.println("This is onTestStart method");
}
public void onTestSuccess(ITestResult result) 
{
System.out.println("This is onTestSuccess method");
}
public void onTestFailure (ITestResult result)
{ 
	System.out.println("This is onTestFailure method");
TakesScreenshot takeSc=(TakesScreenshot)driver;
File screenShotfile=takeSc.getScreenshotAs(OutputType.FILE); 
String fileName=result.getName();
//get project folder path 
String outputPath=System.getProperty("user.dir")+"//ExecutionResult//Screenshots//"+ fileName +".png";
File ouputFile=new File(outputPath);

try {
FileUtils.copyFile(screenShotfile, ouputFile); 
} 
catch (IOException e) 
{ 
	e.printStackTrace();
}
Logger.fail("The test execution is failed due to:"+ result.getThrowable());
Logger.addScreenCaptureFromPath(outputPath);
}
public void onTestSkipped(ITestResult result)
{
System.out.println("This is onTestSkipped method");
}
public void onTestFailedWithTimeout(ITestResult result) 
{
	System.out.println("This is onTestFailedWithTimeout method");
     onTestFailure(result);
}
private void setExtentReportDetails()
{
	String reportPath=System.getProperty("user.dir")+"//ExecutionResult//Report//AutomationReport.html";
	sparkReport=new ExtentSparkReporter(reportPath);
	sparkReport.config().setDocumentTitle("AgileCrmAutomationReport");
	sparkReport.config().setReportName("Automation Report");
	// to add information into the html report, we need to create ExtentReports class instance
	extentReport=new ExtentReports();
	extentReport.attachReporter(sparkReport);
	extentReport.setSystemInfo("username", "cyber success");
	extentReport.setSystemInfo("environment", "test");
	extentReport.setSystemInfo("browser", "chrome");
}
}