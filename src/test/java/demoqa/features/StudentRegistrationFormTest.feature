Feature: Student Registration Form Test
  @RegTC
  Scenario Outline: Verify student registration form submission
    Given Open URl
    And Click on Form section
    And Click on Practice from section
    And Fill Student form registration with data "<firstName>""<lastName>""<email>""<mobilenumber>""<subject>""<currentAddress>""<state>""<city>""<attachment>"
    When Click on submit button
    Then Validate submit form

    Examples:
      |firstName|lastName|email|mobilenumber|subject|currentAddress|state|city|attachment|
      | Arun       | G       |abc@gmail.com|1234567890|Hindi|No 123 MG Road|Haryana|Karnal|C:\\Users\\Log ON\\IdeaProjects\\TestAutomationParker\\src\\main\\resources\\images\\pnga-stack-books-isolated-white-background.jpg|