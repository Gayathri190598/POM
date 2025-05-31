package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunction.Base;

public class SonyXperia extends Base{
	
	@FindBy(xpath="//div//span[@id='product-price-1']/span")
	WebElement listPagePrice;
	
	@FindBy(xpath="//a[@title='Sony Xperia']")
	WebElement sonyXperia;
	
	@FindBy(xpath="//*[@id=\"product-price-1\"]/span")
	WebElement detailPagePrice;
	
	
	public SonyXperia(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getListPagePrice() {
		return listPagePrice.getText();
	}
	
	public void clickOnSonyXperia() {
		sonyXperia.click();
	}
	
	public String getDetailPagePrice() {
		return detailPagePrice.getText();
	}

}
