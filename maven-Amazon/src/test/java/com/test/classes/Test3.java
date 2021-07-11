		package com.test.classes;

		import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
		import org.testng.annotations.Test;

import AMZcom.pom.classes.AM_FaceWashPage;
import AMZcom.pom.classes.AM_Login;


			
			
		public class Test3 {



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
			    	 ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
					 driver.switchTo().window(addr.get(1));	
					 
			    	 
				     }
				     
				
		     @Test
		     public void verifyAddtoCart() throws InterruptedException
		     {
		    	Thread.sleep(3000);
		    	
		    	facewashpage =new AM_FaceWashPage(driver);
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, 40);

				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
				facewashpage.verifyAddtoCart();
				Thread.sleep(3000);
				
				facewashpage.verifyShoppingCart();
				ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
				 driver.switchTo().window(addr.get(1));	
				 
				 String s=facewashpage.ShoppingCartContains();
				 System.out.println(s);
		    	 
				 if(s.contains("Himalaya Purifying Neem Face Wash, 400 ml"))
				 {
					 System.out.println("Test4 :Pass");
				 }
				 else {
					 System.out.println("Test4 :fail");
				 }
				
				 }
		    
		   
		     
		     
		     @AfterClass

			public void aftermethod() throws InterruptedException
			{	
				System.out.println("after method");
			}
			
			
//			@AfterSuite
//			public void afterclass() throws InterruptedException
//			{	Thread.sleep(3000);
//				driver.close();
//			}
		//	
			
		


	}

	
	
	
	



