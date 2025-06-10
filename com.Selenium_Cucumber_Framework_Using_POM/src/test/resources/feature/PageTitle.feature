Feature: To verify the page title of facebook registration page

  Scenario Outline: Verification of registration pagetitle
    Given the user gets the actual and expected title
    Then the user verifies the "<title>"

    Examples: valid title
      | title               |
      | Sign up for Facebook |

    Examples: invalid title
      | title              |
      | Sign Up For Facebook |

 