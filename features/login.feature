Feature: User Login

  Scenario: Successfull Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "eMpjk2581450876@gmail.com" and pwd as "test@123"
    And user clicks on the Loggin button
    Then the user should be redirected to the My Account Page
