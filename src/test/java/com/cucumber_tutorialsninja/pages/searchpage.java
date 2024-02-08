package com.cucumber_tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber_tutorialsninja.common.commonMethods;

public class searchpage {
    
    public WebDriver driver;
	public commonMethods cm;

	//------ approch ------ page Factory-----------------------
	public searchpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		cm=new commonMethods(driver);
	}
	@FindBy(name="search")
	WebElement SearchOption;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	WebElement SearchButton;
	
	@FindBy(linkText="HP LP3065")
	WebElement Productname;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	WebElement Actualsearchmessage;
	
	
	@FindBy(xpath="//button[@id='list-view']")
	WebElement listviewbutton;
	
	@FindBy(xpath="//button[@id='grid-view']")
	WebElement gridviewbutton;
	
	public void EntervalidproductintoSearchbox(String validproducttext)
	{
		SearchOption.sendKeys(validproducttext);
	}
	public void clickSearchButton()
	{
		SearchButton.click();
	}
	
	public boolean displaystatus_of_valid_productname() {
		return Productname.isDisplayed();
	}
	public String  Actualsearchmessage_text()
	{
		 return Actualsearchmessage.getText();
	}
	
	public void ListViewButton()
	{
		listviewbutton.click();
	}
	public void GrideViewButton()
	{
		gridviewbutton.click();
	}
}
