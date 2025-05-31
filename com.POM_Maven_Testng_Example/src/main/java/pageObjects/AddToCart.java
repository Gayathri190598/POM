package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunction.Base;

public class AddToCart extends Base{
	
	@FindBy(xpath="//input[@id='qty']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement addToCart;
 
	public AddToCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver , this);
	}
	
	public void setQuantity(String qty) {
		quantity.sendKeys(qty);
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}

}
