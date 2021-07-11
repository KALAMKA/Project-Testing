package com.test.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AMZcom.pom.classes.AMZ_HomePage;
import AMZcom.pom.classes.AM_Login;




public class Amazon_testClass {

	private WebDriver driver;
//	private Actions a;
	private AMZ_HomePage homepage;
	private AM_Login loginpage;
	@BeforeSuite
	 //@BeforeClass
	public void launchBrowser()
	{
		System.out.println("BeforeClass");
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
//	@BeforeMethod
	//@Test(priority=1)
//	public void loginPage() throws InterruptedException
//	{
//		loginpage=new AM_Login(driver);
//		loginpage.verifyMobile();
//		Thread.sleep(2000);
//		loginpage.verifyPrime();
//		Thread.sleep(2000);
//		loginpage.verifyFashion();
//		Thread.sleep(2000);
//		loginpage.verifySignIn();
//		String url = driver.getCurrentUrl();
//		
//		
//	}
	
	@Test(priority=0)
   public void AmazonHome() throws InterruptedException
	{
	homepage= new AMZ_HomePage(driver);
	
	homepage.verifyAMZtext();
	Thread.sleep(2000);
	homepage.verifySign_InText();
	Thread.sleep(2000);
	homepage.EnterMobilEmail();
	homepage.VerifyText();
	Thread.sleep(2000);
	homepage.VerifyContinue();
		
		String url = driver.getCurrentUrl();

	}
	
	@AfterMethod
	public void Logout() throws InterruptedException
	{	Thread.sleep(3000);
	    System.out.println("Log out method pending");
		//homepage.clickOnLogout();
	}
	
	@AfterSuite
	public void afterclass() throws InterruptedException
	{	Thread.sleep(3000);
		driver.close();
	}
}
	
	
	

