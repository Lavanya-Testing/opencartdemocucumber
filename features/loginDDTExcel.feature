Feature: User Login

  Scenario Outline: Login Data Driven with excel
    Given the user navigates to login page
    Then the user should be redirected to MyAccountPage by passing email and pwd with excel  rows "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
