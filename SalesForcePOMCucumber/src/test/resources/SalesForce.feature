

Feature: Login into SalesForce appliaction
		# Testcase 2 
  Scenario: Login with valid username and password
    Given user open salesforce appliaction
  When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
  When  user enters value into text box password as "Dreamb0y" 
    When Click on Login button
    Then verify the home page title as "Home Page ~ Salesforce - Developer Edition"
    
     #Testcase 4B
    Scenario: Login with invalid username and password
    Given user open salesforce appliaction
  When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
  When  user enters value into text box password as "Drea" 
    When Click on Login button
    Then verify the error "Please check your username and password. If you still can't log in, contact your Salesforce administrator." 
    
    
   #  Testcase 1
    Scenario: Login with invalid username and empty password
    Given user open salesforce appliaction
  When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
 
    When Click on Login button
    Then verify the error "Please enter your password."
    
    # Testcase 4A
    Scenario: Forgot Password
    Given user open salesforce appliaction
    When click forgot password
    When Enter username and click continue button
    Then Verify Password reset message is displayed as "Check Your Email" 
    
     # Testcase 3
    Scenario: Check Remember me
    Given user open salesforce appliaction
     When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
  When  user enters value into text box password as "Dreamb0y" 
  When user clicks check remember me checkbox
  When Click on Login button
  When Click on Logout button
    Then Verify username is displayed as "veninitish@gmail.com" 
    
    
  