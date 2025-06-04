Feature: This feature is to register in facebook application

  Scenario Outline: This test is to check the page title and to register in facebook.
    Given check the pagetitle "<page_title>"
    When enter first name "<fname>"
    And enter last name  "<lname>"
    And enter day is "<day>"
    And enter month is "<month>"
    And enter year is "<year>"
    And enter gender is "<gender>"
    And enter email is "<email>"
    And enter password is "<password>"
    Then click on the submit button

    Examples: 
      | page_title           | fname    | lname | day | month | year | gender | email               | password   |
      | Sign up for Facebook | Gayathri | R     |  19 |    05 | 1998 | Female | rgayu1998@gmail.com | Rgayu@1998 |
