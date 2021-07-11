package com.test.classes;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AMZcom.pom.classes.AM_Login;


	
	public class Testclass_TP {

		private WebDriver driver;
		private AM_Login loginpage;

		
		@BeforeSuite
		public void launchBrowser()
		{
			System.out.println("BeforeClass");
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
		}
		
     @Test
     public void verifySearchBox() throws InterruptedException
     {
    	 loginpage=new AM_Login(driver);
    	 Thread.sleep(2000);
    	 loginpage.verifysearchBox();
    	 loginpage.verifysearchBtn();
    	 
    	 String url = driver.getCurrentUrl();
    	 System.out.println(url);
    	 
 		if(url.equals("https://www.amazon.in/s?k=FaceWash+fo+womens&ref=nb_sb_noss"))
 		{
 			System.out.println("Test1 : Pass");
 		}
 		else
 		{
 			System.out.println("Test1 : Fail");
 		}
 		
 		loginpage.verifyfashwash();
 		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(1));	
		 String fw=driver.getTitle();
		 System.out.println(fw);
		 
		if(fw.contains("Himalaya Purifying Neem Face Wash, 400 ml"))
	 		{
	 			System.out.println("Test2 : Pass");
	 		}
	 		else
	 		{
	 			System.out.println("Test2 : Fail");
	 		}
	 		
 		}
     
     @AfterClass

	public void aftermethod() throws InterruptedException
	{	
		System.out.println("after method");
	}
	
	

}
