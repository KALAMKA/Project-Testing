package com.test.classes1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Acticom.pom.classes.Acti_Login_Page;
import Acticom.pom.classes.Acti_home_Page;



public class Acti_TNG extends Actitime_Pojo {
	
	private WebDriver driver;
	private  Acti_Login_Page loginpage;
	private  Acti_home_Page homepage;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
	
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html"); 
		ExtentReports extend = new ExtentReports();
		extend.attachReporter (reporter);
		System.out.println("Before Test");
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser ();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser ();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		driver.get("http://localhost/login.do");
		
		loginpage = new  Acti_Login_Page(driver);
		loginpage.sendUsername("admin");
		loginpage.sendPassword("manager");
		Thread.sleep(3000);
		loginpage.clickOnLogInButton();
	}
	
	@Test
	public void test1() throws InterruptedException
	{	Thread.sleep(3000);
		System.out.println("Verify Tasks Button");
		homepage = new Acti_home_Page (driver);
		homepage.clickOnTasks();
		String url = driver.getCurrentUrl();
		if(url.equals("http://localhost/tasks/otasklist.do"))
		{
			System.out.println("Test1 : Pass");
		}
		else
		{
			System.out.println("Test1 : Fail");
		}
		
	}
	
	@Test
	public void test2() throws InterruptedException
	{	Thread.sleep(3000);
		System.out.println("Verify ReportButton");
		homepage = new Acti_home_Page(driver);
		homepage.clickOnReports();
		String url = driver.getCurrentUrl();
		if(url.equals("http://localhost/reports/reports.do"))
		{
			System.out.println("Test2 : Pass");
		}
		else
		{
			System.out.println("Test2 : Fail");
		}
	}
	
	
	@AfterMethod
	public void aftermethod() throws InterruptedException
	{	Thread.sleep(3000);
		homepage.clickOnLogout();
	}
	
	@AfterClass
	public void afterclass() throws InterruptedException
	{	Thread.sleep(3000);
		driver.close();
	}
}
