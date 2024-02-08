@Registration_Test_cases
Feature: Testcases For Registration Page
@Regi
Scenario: verifySearch_TC012_verifyregistering_Account_with_mandetoryfields
Given User open the Application
Then User click on MyAccount Tab
Then From Selectbox select Register option
Then Registation form open
And enter data in to all mandetory fields
Then click on continue button
Then Get Account Success message

Scenario: verifySearch_TC013_verifyregistering_Account_with_Allfields
Given User open the Application
Then User click on MyAccount Tab
Then From Selectbox select Register option
Then Registation form open
And enter data in to all fields
Then click on continue button
Then Get Account Success message

Scenario: verifySearch_TC014_verifyregistering_Account_withOut_Entering_Allfields
Given User open the Application
Then User click on MyAccount Tab
Then From Selectbox select Register option
Then Registation form open
And without entering details in form 
Then click on continue button
Then Display Error message <Warning: You must agree to the Privacy Policy!>

Scenario: verifySearch_TC015_verifyregistering_Account_with_exiting_emailaddress
Given User open the Application
Then User click on MyAccount Tab
Then From Selectbox select Register option
Then Registation form open
And enter data in to all fields
Then check for Emailaddress already exits or not
Then click on continue button
