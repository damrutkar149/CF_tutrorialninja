@SearchTestcases
Feature: Testcases For Search Page
@tanvi
Scenario: verifySearch_TC07_Search_with_valid_product
Given User open the Application
Then User provide valid product "HP" on Search box"
And User click on Search Button
Then User should get valid product display on Search Result
@tanvi1
Scenario: verifySearch_TC08_Search_with_invalid_product
Given User open the Application
Then User provide valid product "Honda" on Search box"
And User click on Search Button
Then User should get Warning message No product matches
@tanvi2
Scenario: verifySearch_TC09_Search_without_product
Given User open the Application
Then User not enter_anything_on Search box"
And User click on Search Button
Then User should get Warning message No product matches

@tanvi3
Scenario: verifySearch_TC10_Search_Products_meeting_the_search_criteria_listview
Given User open the Application
Then User provide valid product "HP" on Search box"
And User click on Search Button
Then User should get valid product display on Search Result
Then user click on List view button,It changes result in the list formate

@tanvi4
Scenario: verifySearch_TC11_Search_Products_meeting_the_search_criteria_gridview
Given User open the Application
Then User provide valid product "HP" on Search box"
And User click on Search Button
Then User should get valid product display on Search Result
Then user click on Grid view button,It changes result in the grid formate