Feature: User Login

  Scenario Outline: Login with data driven without excel
    Given the user navigates to loginpage
    When the user enter '<email>' and '<password>'
    And user clicks on the login button
    Then user should get error message
      | errorMessage                                          |
      | Warning: No match for E-Mail Address and/or Password. |

    Examples: 
      |email                  | password |
      | eMpjk2581450876@gmail.com | tyu@123  |
      | eMpjk2581450875@gmail.com | test@123 |
      | eMpjk2581450875@gmail.com | tyu@123  |
