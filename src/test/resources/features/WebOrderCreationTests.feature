@OMT-7929
Feature: validating calculate and order creation functionalities

  Scenario Outline: Validating calculate functionality
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"
    And user navigates to the Order module
    And user selects"<product>" product with <quantity>
    Then user validates total is calculated properly for quantity <quantity>

    Examples:
      | product     | quantity |
      | MyMoney     | 1        |
      | familyAlbum | 100      |
      | Screensaver | 55       |
      | MyMoney     | 20       |

  @OMT-7931
  Scenario Outline: Validating create order functionality
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"
    And user counts number of orders in table
    And user navigates to the Order module
    And user create order with data
      | product   | quantity   | name   | street   | city   | state   | zip   | cc   | expire date   |
      | <product> | <quantity> | <name> | <street> | <city> | <state> | <zip> | <cc> | <expire date> |
    Then user validates success message "New order has been successfully added."
    And user validates order added to List of Orders
    Examples:
      | product     | quantity | name        | street      | city    | state | zip   | cc               | expire date |
      | MyMoney     | 10       | John Doe    | 123 My Road | Chicago | IL    | 12345 | 1234123412341234 | 12/22       |
      | FamilyAlbum | 5        | Patel Harsh | 124 My Road | Chicago | IL    | 12345 | 7734123412341234 | 07/22        |
      | ScreenSaver | 1        | Kim Yan     | 125 My Road | Chicago | IL    | 12345 | 8834123412341234 | 03/22        |
