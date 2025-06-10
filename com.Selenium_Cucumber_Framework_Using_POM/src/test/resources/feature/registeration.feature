Feature: This feature is to register in facebook application

  Scenario: This is to test registeration in facebook is successful
    Given the user enters the details
      | fname    | lname | day | month | year | gender | email               | password   |
      | Gayathri | R     |  19 | May   | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
    Then the user clicks on submit

  Scenario Outline: This is to test registration in facebook is failure
    Given the user enters firstname "<fname>"
    And the user enters lastname "<lname>"
    And the user enters day "<day>"
    And the user enters month "<month>"
    And the user enters year "<year>"
    And the user enters gender "<gender>"
    And the user enters email "<email>"
    And the user enters password "<password>"
    Then the user clicks on submit

    Examples: 
      | fname    | lname | day | month | year | gender | email               | password   |
      |          | R     |  19 | May   | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri |       |  19 | May   | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri | R     |     | May   | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri | R     |  19 |       | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri | R     |  19 | May   |      | Female | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri | R     |  19 | May   | 1998 |        | rgayu1998@gmail.com | Rgayu@1998 |
      | Gayathri | R     |  19 | May   | 1998 | Female |                     | Rgayu@1998 |
      | Gayathri | R     |  19 | May   | 1998 | Female | rgayu1998@gmail.com |            |
