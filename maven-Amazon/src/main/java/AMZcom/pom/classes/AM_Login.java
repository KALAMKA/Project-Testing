package AMZcom.pom.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AM_Login {
	
	
	private WebDriver driver1;
	
	 /* @FindBy (xpath="//a[text()='Mobiles']")
	private WebElement mobile ;
		
	@FindBy (xpath="//a[text()='Fashion']")
	private WebElement  Fashion;
	
	@FindBy (xpath="//a[@id='nav-link-prime']")
	private WebElement  prime;
	
	
    @FindBy (xpath="//a[@id='nav-link-accountList']")
    private WebElement SignIn;
			
		*/
	
	 @FindBy (xpath="//input[@id='twotabsearchtextbox']")
	    private WebElement SearchBox;
	 
	 @FindBy (xpath="//input[@id='nav-search-submit-button']")
	    private WebElement SearchBtn;
	 
	 @FindBy (xpath="//span[contains(text(),'Himalaya Purifying Neem')]")
	    private WebElement facewash;
				
	
	 
	 
				
public AM_Login(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}




/* public void verifyMobile ()
{
  mobile.click();

}

public void verifyFashion ()
{
	Fashion.click();

}
public void verifyPrime ()
{
Actions a=new Actions(driver1);
 a.moveToElement(prime).click();
}

public void verifySignIn ()
{
	Actions a=new Actions(driver1);
	//Actions.b=new Actions(driver1);
 a.moveToElement(SignIn).click();
 
}
*/
public void verifysearchBox ()
{
 SearchBox.sendKeys("FaceWash fo womens");

}
public void verifysearchBtn ()
{
 SearchBtn.click();

}
public void verifyfashwash ()
{
 facewash.click();
 


}
}