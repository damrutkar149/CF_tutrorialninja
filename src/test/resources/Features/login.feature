@alltestLogin
Feature: All test cases Login page Tutorialninja
@dhanashree
Scenario: verifyLogin_TC01
Given User should be navigates to login page
Then User Perform Valid login
Then User should be nevigate to Dashboard 
@dhanashree1
Scenario: verifyLogin_TC02_login_with_invalid_Senario
Given User should be navigates to login page
Then User Enter invalid emailaddress
Then User Enter invalid Password
And User click on login button
Then User should get Warning message about creadentials mismatch
@dhanashree2
Scenario: verifyLogin_TC03_login_with_validEmail_and_invalidpasswordSenario
Given User should be navigates to login page
Then User Enter valid emailaddress
Then User Enter invalid Password
And User click on login button
Then User should get Warning message about creadentials mismatch
@dhanashree3
Scenario: verifyLogin_TC04_login_with_invalidEmail_and_validpasswordSenario
Given User should be navigates to login page
Then User Enter invalid emailaddress
Then User Enter valid Password
And User click on login button
Then User should get Warning message about   mismatch
@dhanashree4
Scenario: verifyLogin_TC05_login_without_creadential
Given User should be navigates to login page
Then User not Enter any emailaddress
Then User not Enter any Password
And User click on login button
Then User should get Warning message about creadentials mismatch