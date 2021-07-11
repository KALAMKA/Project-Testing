package AMZcom.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMZ_HomePage {
	
	
	@FindBy(xpath="//i[@aria-label='Amazon']")
	private WebElement AmazonText;
	
	@FindBy (xpath="//label[contains(text(),'Email or mobile phone number')]")
	private WebElement Sign_InText;
	
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement Enter_Mobile_Email;
	
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement Continue;
	
	
	@FindBy (xpath="//a[text()='Conditions of Use']")
	private WebElement Text;
	
	public  AMZ_HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyAMZtext ()
	{
		String s1=AmazonText.getText();
		
	}
	public void  verifySign_InText ()
	{
		String s2=Sign_InText.getText();
		
	}
	public void EnterMobilEmail ()
	{
		Enter_Mobile_Email.sendKeys("kalamkarswiti@gmail.com");
	}
	
	public void VerifyContinue ()
	{
	  Continue.click();
	}
	
	
	public void VerifyText ()
	{
		String s3 =Text.getText();
	}
	


}





