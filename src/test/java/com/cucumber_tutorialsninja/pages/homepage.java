package com.cucumber_tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber_tutorialsninja.common.commonMethods;

public class homepage {
	public WebDriver driver;
	public commonMethods cm;

	//------ approch ------ page Factory-----------------------
	public homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		cm=new commonMethods(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement MY_Account;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement Loginoption;
	
	@FindBy(xpath="//div[@id='top-links']/descendant::a[text()='Logout']")
	WebElement Logoutoption;
	
	
	
	
	public void clickonMyAccount()
	{
		MY_Account.click();
	}
	public void LoginOption()
	{
		Loginoption.click();
	}
	public void LogoutOption()
	{
		Logoutoption.click();
	}
	
	
}
