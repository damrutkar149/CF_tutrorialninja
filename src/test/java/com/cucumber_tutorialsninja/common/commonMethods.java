package com.cucumber_tutorialsninja.common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber_tutorialsninja.StepDefinitions.BaseTest;

public class commonMethods {
	
	private WebDriver driver;
	
	WebDriverWait wait;
	
	public commonMethods(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void enterValues(WebElement elm,String value,String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
			BaseTest.logger.pass(msg+"<span class=\"label start-time\"><a href='"+getScreenshot()+"'>Screenshot<a></span>");		
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Value did not enter into filed due to exception "+e.getMessage());
		}	
	}
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			BaseTest.logger.pass(msg+"<span class=\"label start-time\"><a href='"+getScreenshot()+"'>Screenshot<a></span>");		
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Element did not clicked due to exception "+e.getMessage());
		}	
	}
	public void SelectDropdownText(WebElement elm,String text,String msg)
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeSelected(elm));
			Select sel= new Select(elm);
			sel.selectByVisibleText(text);
			//System.out.println(msg);
			BaseTest.logger.pass(msg+"<span class=\"label start-time\"><a href='"+getScreenshot()+"'>Screenshot<a></span>");		
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Value did not select due to exception "+e.getMessage());
		}	
	}
	public void Elementexits(WebElement elm,String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			BaseTest.logger.pass(msg+"<span class=\"label start-time\"><a href='"+getScreenshot()+"'>Screenshot<a></span>");		
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Element did not visible due to exception "+e.getMessage());
		}	
	}
	public void Elementexits(String elm,String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
			driver.findElement(By.xpath(elm)).isDisplayed();
			BaseTest.logger.pass(msg+"<span class=\"label start-time\"><a href='"+getScreenshot()+"'>Screenshot<a></span>");		
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Element did not visible due to exception "+e.getMessage());
		}	
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		//DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = "tanu"+d;
		String path = System.getProperty("user.dir") + "/src/test/java/com/tutorialninja/reports/screenshot/"+fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	

}


