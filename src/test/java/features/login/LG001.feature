Feature: Login to application

  Scenario: Enter tu application and login using an existing teacher user
    Given application is open in the browser
    When user enters username and password
    Then user logs in successfully
