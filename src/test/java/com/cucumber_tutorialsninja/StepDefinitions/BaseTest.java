package com.cucumber_tutorialsninja.StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public static Map<String,Map <String,String>> dt;
	 //for extent report
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public String TCname;
	
	public void initiation() throws IOException, FilloException
	{
		prop=readproperties();
		dt=readTestdata();
		createExtentReport();
		launchapp();
		
	}
	public void launchapp()
	{
		if(prop.getProperty("Browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);	
		}
		else if(prop.getProperty("Browser").equals("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplicitWait"))));
		driver.get(prop.getProperty("AppURL"));
	}

	
	public void closeapp()
	{
		driver.quit();	
	}
	

	public Properties readproperties() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/setting.properties");
		prop.load(fis);
		return prop;
		
	}
	
	public  Map<String,Map <String,String>> readTestdata() throws FilloException
	{
		//fillo is used for  data read form excel
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/testdata/tninja.xlsx");
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		 int rowcount=recordset.getCount();
		System.out.println(rowcount);
		 int colcount=recordset.getFieldNames().size();
		 //System.out.println(colcount);
		//Map And HashMap for fetch data from  excel sheet
		 
		 // map ke andar map banane ke liya code
		 Map<String,Map <String,String>> data= new HashMap <String,Map <String,String>>();
		while(recordset.next())
		{	
			 Map <String,String> rowdata = (Map<String, String>) new HashMap <String,String>();
			 String FTcname=recordset.getField("Tcname");
				for(int i=1;i<colcount;i++)
					{
						String colmname= recordset.getFieldNames().get(i);
						String colvalue=recordset.getField(colmname);
						rowdata.put(colmname, colvalue);
					}
				data.put(FTcname, rowdata);
		}
		recordset.close();
		connection.close();
		//used code return data ---- data type change from Void to Map<String,Map <String,String>>
		return data;
	}
	
	public void createExtentReport()
	{
		Date d = new Date();
		//Date ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = "dhanu"+d;
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/tutorialninja/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GirishLaptopTesting");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Dhanashree");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		//htmlReporter.config().setTheme(Theme.DARK); 
		
	}
	
}
