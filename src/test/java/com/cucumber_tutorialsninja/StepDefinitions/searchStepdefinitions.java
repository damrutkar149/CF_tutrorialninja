package com.cucumber_tutorialsninja.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;

import com.cucumber_tutorialsninja.pages.searchpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class searchStepdefinitions extends BaseTest {
	public searchpage sp;
	@Given("User open the Application")
	public void user_open_the_application() throws IOException, FilloException {
		initiation();
	}

	@Then("User provide valid product {string} on Search box\"")
	public void user_provide_valid_product_on_search_box(String validproducttext)  {
		 sp=new searchpage(driver);
		sp.EntervalidproductintoSearchbox(validproducttext);
	}

	@Then("User click on Search Button")
	public void user_click_on_search_button() {
		 sp=new searchpage(driver);
		sp.clickSearchButton();
	}

	@Then("User should get valid product display on Search Result")
	public void user_should_get_valid_product_display_on_search_result() {
		 sp=new searchpage(driver);
		Assert.assertTrue(sp.displaystatus_of_valid_productname());
	}

	@Then("User should get Warning message No product matches")
	public void user_should_get_warning_message_no_product_matches() {
		 sp=new searchpage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",sp.Actualsearchmessage_text());
	}

	@Then("User not enter_anything_on Search box\"")
	public void user_not_enter_anything_on_search_box() {
		 sp=new searchpage(driver);
	}
	
	@Then("user click on List view button,It changes result in the list formate")
	public void user_click_on_list_view_button_it_changes_result_in_the_list_formate() {
		 sp=new searchpage(driver);
		 sp.ListViewButton();
	}
	 
	@Then("user click on Grid view button,It changes result in the grid formate")
	public void user_click_on_grid_view_button_it_changes_result_in_the_grid_formate() {
		 sp=new searchpage(driver);
		 sp.GrideViewButton();
	}
}
