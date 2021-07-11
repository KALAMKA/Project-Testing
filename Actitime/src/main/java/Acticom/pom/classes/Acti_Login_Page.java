package Acticom.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Acti_Login_Page {

	
	@FindBy (xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement Login;
	
	public Acti_Login_Page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsername (String data)
	{
		username.sendKeys(data);
	}
	
	public void sendPassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogInButton ()
	{
		Login.click();
	}
}
