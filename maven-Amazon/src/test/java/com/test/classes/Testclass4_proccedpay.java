package com.test.classes;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AMZcom.pom.classes.AM_FaceWashPage;
import AMZcom.pom.classes.AM_Login;

public class Testclass4_proccedpay {
	
	private WebDriver driver;
	private AM_Login loginpage;
	private AM_FaceWashPage facewashpage;

	
	@BeforeSuite
	public void launchBrowser()
	{
		System.out.println("BeforeClass");
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	 
	@BeforeMethod
	     public void beforeMethod() throws InterruptedException
	     {
	    	 
		 loginpage=new AM_Login(driver);
    	 Thread.sleep(2000);
    	 loginpage.verifysearchBox();
    	 loginpage.verifysearchBtn();
    	 
    	 loginpage.verifyfashwash();
    	 facewashpage.verifyAddtoCart();
    	 facewashpage.verifyShoppingCart();
    	 
    	 ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(1));	
		String a= driver.getCurrentUrl();
		 System.out.println(a);
		// driver.switchTo().window(addr.get(2));
	 }

	 
    @Test
    public void verifyProceedtoPay() throws InterruptedException
    {
   	Thread.sleep(3000);
       facewashpage =new AM_FaceWashPage(driver);
       Thread.sleep(3000);
       facewashpage.verifyproceedPay();
       
       
      
   	
       
    }
	
	
	
	
	
	
	
	
	
	

}
