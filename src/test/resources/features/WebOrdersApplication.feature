Feature: validating WebOrders application login functionality
  @smoke
  Scenario: validating login functionality with valid credentials
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"
    Then user validates application is logged in

    @UI
    Scenario: validating login functionality with invalid credentials
    Given user navigates to the weborders application
    When user provides username "invalid" and password "invalid"

