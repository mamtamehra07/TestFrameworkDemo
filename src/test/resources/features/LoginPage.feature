Feature: Verify Login Page Scenarios

Background: Login Page
Given user opens login page

Scenario: Login to site with valid username and valid password
When user enters valid username and password
And user clicks on Login button
Then user extracts the title of the page
And page title should be same as home page

Scenario: Verify title of Login page 
When user extracts the title of the page
Then page title should be same as login page