Feature: Browser Windows Test
  @RegTC
  Scenario: Browser navigation scenario
    Given Open URl
    And Click new window button
    When User Navigate to new window
    Then Verify text in new window
    And User navigate to original window



