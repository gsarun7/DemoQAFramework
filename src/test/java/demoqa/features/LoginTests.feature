Feature: Login Test

  Scenario Outline: Valid Login scenario
    Given Open URl
    And click login
    When enter user name "<Username>"
    And enter password "<Password>"
    And click login
    Then User navigate to profile page

    Examples:
    |Username|Password|
    | ArunUN       | Test@123       |

  Scenario Outline: Invalid Login scenario
    Given Open URl
    And click login
    When enter user name "<Username>"
    And enter password "<Password>"
    And click login
    Then User gets error message stating invalid username or password

    Examples:
      |Username|Password|
      | ArunUN       | Test@12       |
