Feature: Contact Customer Care for Product Inquiry
Background: Login Page
Given user opens login page
When user enters valid username and password
And user clicks on Login button
Then user clicks on contact us

Scenario Outline: Contact Customer Care for Product Inquiry
When user enters <SubjectHeading>,<OrderRef>,<Message> and send message
Then message should be sent to customer care

Examples:
|SubjectHeading|OrderRef|Message|
|"Customer service"|"435837"|"for testing purpose"|