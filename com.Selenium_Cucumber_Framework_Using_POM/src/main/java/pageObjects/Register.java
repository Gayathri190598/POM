package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.DriverManager;

public class Register {
	
	private static Register registerInstance;
	
	private Register() {
	
	}
	
	public static Register getInstance() {
		if(registerInstance==null) {
			registerInstance=new Register();
		}
		return registerInstance;
	}
	
	
	
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement fName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lName;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy(xpath="//label//input[@value='1']")
	private WebElement Female;
	
	@FindBy(xpath="//label//input[@value='2']")
	private WebElement Male;
	
	@FindBy(xpath="//label//input[@value='-1']")
	private WebElement Custom;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	public static WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement submit;
	
	 public String getPageTitle() {
		 return DriverManager.getDriver().getTitle();
	 }

	
	public void enterFirstName(String firstName) {
		fName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lName.sendKeys(lastName);
	}

	public void enterDay(String DD) {
		day.sendKeys(DD);
	}

	public void enterMonth(String MM) {
		month.sendKeys(MM);
	}

	public void enterYear(String YYYY) {
		year.sendKeys(YYYY);
	}

	public void selectGender(String gender) {
		switch(gender) {
		case "Female":
			Female.click();
			break;
		case "Male":
			Male.click();
			break;
		default:
			Custom.click();
			break;
		}
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}

	public void clickSubmit() {
		submit.click();
	}
	 
}
