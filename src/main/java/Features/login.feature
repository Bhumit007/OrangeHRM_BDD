Feature: Login to orangeHRM Application
  Scenario: Check orangeHRM positive cases
    When I go to OrangeHRM Home page.
    And I enter username and password.
    Then I navigate to PIM tab and click on add employee.
    And I enter employee details and save it.
