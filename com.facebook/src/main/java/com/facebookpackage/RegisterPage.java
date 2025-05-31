package com.facebookpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook_Base.BaseClass;

public class RegisterPage extends BaseClass{
	
	
	//locators
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement surName;

	@FindBy(xpath="//select[@id='day']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//label[.='Female']//input[@value='1']")
	WebElement female;
	
	@FindBy(xpath="//label[.='Male']//input[@value='2']")
	WebElement male;
	
	@FindBy(xpath="//label[.='Custom']//input[@value='-1']")
	WebElement custom;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	WebElement password;
	
	@FindBy(xpath="//button[@name='websubmit']")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='_9bq5']")
	WebElement account;
	
	//actions
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setSurName(String lname) {
		surName.sendKeys(lname);
	}
	
	public void setDay(String bday) {
		day.sendKeys(bday);
	}
	
	public void setMonth(String bmonth) {
		month.sendKeys(bmonth);
	}
	
	public void setYear(String byear) {
		year.sendKeys(byear);
	}

	public void setGender(String sex) {
		switch(sex) {
		case "Female":{
			female.click();
			break;
		}
	    case "Male":{
		    male.click();
		    break;
	    }
        case "Custom":{
	        custom.click();
         	break;
     }
	}
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickSignUp() {
		signUp.click();
	}
	
	public void checkAccount() {
		account.click();
	}
	
}
