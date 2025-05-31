package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunction.Base;

public class TechpandaHomePage extends Base{
	
	@FindBy(xpath="html/body/div/div/div[2]/div/div/div/div[@class='page-title']/h2")
	WebElement pageTitle;
	 
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileMenu;

	public TechpandaHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.err.println("driver="+driver);
	}
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
	public void clickMobileMenu() {
		mobileMenu.click();
	}	

}
