Feature: Verify BI Non-BI user functionality

@sanity
Scenario: Verify Welcome Screen
Given Launch the app
And Tap on Plus Icon
Then verify Welcome Screen
Then Tap Setting and verify setting page displays
Then Tap Help and verify Help page displays
Then Fill and verify email format functionality

@home
Scenario: Verify Bi User functionality
Given Launch the app
Then verify Welcome Screen
And Enter Valid BI user Email and Start Session
Then Home page displays with Skincare consulation and Find By product Type
And Click Skincare Consultaion section and complete the quiz
Then Result page displays with products
And Add Any product and Tap on Email Routine button
Then Email To Client screen displays with product added details
And Click on Send button and tap on End Session
Then Verify Welcome screen displays

@home
Scenario: Verify Non Bi User functionality
Given Launch the app
Then verify Welcome Screen
And Enter Non BI register user Email and Start Session
Then Create Account screen displays
And Fill all mandatory fields
Then Verify Email format functionality
And Tap on Sign In button
Then Home page displays with Skincare consulation and Find By product Type
And Click Skincare Consultaion section and complete the quiz
Then Result page displays with products
And Add Any product and Tap on Email Routine button
Then Email To Client screen displays with product added details
And Click on Send button and tap on End Session
Then Verify Welcome screen displays

Scenario: Verify Anonymous User functionality
Given Launch the app
Then verify Welcome Screen
And Enter Non BI register user Email and Start Session
Then Create Account screen displays
And Click on skip link
Then Home page displays with Skincare consulation and Find By product Type
And Find By product Type and complete the quiz
Then Result page displays with products
And Add Any product and Tap on Email Routine button
Then Email To Client screen displays with product added details
And Click on Send button and tap on End Session
Then Verify Welcome screen displays

