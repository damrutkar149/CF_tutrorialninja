package com.cucumber_tutorialsninja.StepDefinitions;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.cucumber_tutorialsninja.pages.homepage;
import com.cucumber_tutorialsninja.pages.loginpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinations extends BaseTest {
		//hooks
			@Before
			public void getscenarioname(Scenario scenario)
			{
				TCname=scenario.getName();	
			}
			
			@After
			public void savereport()
			{
				//driver.quit();
				//extent.flush();	
			}
			
			//1st tc
			@Given("User should be navigates to login page")
			public void user_should_be_navigates_to_login_page() throws IOException, FilloException {
				initiation();
				homepage hp=new homepage(driver);
				hp.clickonMyAccount();
				hp.LoginOption();
				logger=extent.createTest(TCname);
				
			}
			@Then("User Perform Valid login")
			public void user_perform_valid_login() throws InterruptedException {
				loginpage  lp= new loginpage (driver);
				lp.login(dt.get(TCname).get("Userid"),dt.get(TCname).get("Password"));
				
			}
			@Then("User should be nevigate to Dashboard")
			public void user_should_be_nevigate_to_dashboard() {
			   
			}
			//Second TC
			
			@Then("User Enter invalid emailaddress")
			public void user_enter_invalid_emailaddress() {
				loginpage  lp= new loginpage (driver);
				lp.logininvalidemail(dt.get(TCname).get("Userid"),dt.get(TCname).get("Password"));
			}
			@Then("User Enter invalid Password")
			public void user_enter_invalid_password() {

			}
			@Then("User click on login button")
			public void user_click_on_login_button() {
			
			}
			@Then("User should get Warning message about creadentials mismatch")
			public void user_should_get_warning_message_about_creadentials_mismatch() {
			    
			}
			
			//3rd TC
			@Then("User Enter valid emailaddress")
			public void user_enter_valid_emailaddress() {
			    
			}
			
			//4th Tc
			@Then("User Enter valid Password")
			public void user_enter_valid_password() {
			   
			}
			@Then("User should get Warning message about   mismatch")
			public void user_should_get_warning_message_about_mismatch() {
			  
			}
			//5th TC
			@Then("User not Enter any emailaddress")
			public void user_not_enter_any_emailaddress() {
			  
			}
			@Then("User not Enter any Password")
			public void user_not_enter_any_password() {
			    
			}
			
	
	
	
}
