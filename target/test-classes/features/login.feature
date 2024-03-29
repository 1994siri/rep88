Feature: free CRM login feature
  @login
  Scenario: free CRM login test scenario
    Given i am on the home page
    When i enter "n.sireesha477@gmail.com" and "sireesha1993"
    When i click on login button
    Then i redirected to home page

