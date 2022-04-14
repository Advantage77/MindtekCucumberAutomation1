
@regression @OMT-7925
Feature: Etsy application search and filter functionalities

    # will run repeated steps that user has in each scenario
    #@Before Method will run
   Background: Repeated first steps in each scenario
    Given user navigates to the Etsy application
    When user searches for "carpet"

  Scenario: Validating price range filter functionality for searched items
    And user applies price filter over 1000
    Then user validates the items price is equal or over 1000.00
     #@After Method will run

  @OMT-7926
    Scenario: validating search results
      Then user validates search result contain keyword "carpet" or"rug"
     #@After Method will run


