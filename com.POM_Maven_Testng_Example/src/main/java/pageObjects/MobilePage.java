package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonFunction.Base;

public class MobilePage extends Base{
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[1]/h1")
	WebElement pageTitle;
	
	@FindBy(xpath="(//select[@title='Sort By'])[1]")
	WebElement sortByName;
	
	@FindBy(xpath="(//select[@title='Sort By']/option[2])[1]")
	WebElement sortByValue;

	public MobilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
	public String sortingOptions(String sortName) {
		Select dropDown=new Select(sortByName);
		dropDown.selectByVisibleText(sortName);
		return dropDown.getFirstSelectedOption().getText();
	}


}
