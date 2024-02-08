package com.cucumber_tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber_tutorialsninja.common.commonMethods;



public class loginpage {
	public WebDriver driver;
	public commonMethods cm;

	//------ approch ------ page Factory-----------------------
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		cm=new commonMethods(driver);
	}
	
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement tb_email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement tb_pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement ele_login;
	
	
	public void login(String userid,String pwd)
	{
	
		cm.enterValues(tb_email,userid,"user name entered successfully");
		//System.out.println(tb_username);
		cm.enterValues(tb_pwd,pwd,"password sucessfully entered ");
		cm.clickElement(ele_login,"login button clicked sucessfully");
	}
	
	public void logininvalidemail(String userid,String pwd)
	{
	
		cm.enterValues(tb_email,userid,"user name entered successfully");
		//System.out.println(tb_username);
		cm.enterValues(tb_pwd,pwd,"password sucessfully entered ");
		cm.clickElement(ele_login,"login button clicked sucessfully");
	}
	
}
