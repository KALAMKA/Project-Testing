package AMZcom.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AM_FaceWashPage {
	
	
 @FindBy (xpath="//input[@id='add-to-cart-button']")
	    private WebElement cart;
				
 @FindBy (xpath="//span[@id='nav-cart-count']")
 private WebElement verifyCart;
			
 @FindBy (xpath="//div[@id='sc-active-cart']")
 private WebElement sCart;
 
 @FindBy (xpath="//input[@name='proceedToRetailCheckout']")
private WebElement proceedToPay;
 
	 
public AM_FaceWashPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public void verifyAddtoCart ()
{
 cart.click();

}
public void verifyShoppingCart ()
{
	verifyCart.click();
 
}
	public String ShoppingCartContains ()
	{
		String sC=sCart.getText();
		return sC;	 
    }
	
	public String verifyproceedPay ()
	{
		proceedToPay.click();
		String PP=proceedToPay.getText();
		return PP;
		
		
		
    }
	

}
