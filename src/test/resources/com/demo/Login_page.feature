Feature: Login page

  Scenario: Check page display
    Given A user navigates to LoginPage
    Then UserName input is displayed
    And Password input is displayed
    And Submit button is displayed
    Then A user logins for "serhat21zor@gmail.com" "Avesta1907"
	When A user click to login button
	Then Account button is displayed