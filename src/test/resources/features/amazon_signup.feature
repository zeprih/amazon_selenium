Feature: Sign Up on Website Amazon
  Scenario: Negative case create account all field fill is empty
    Given User go to website amazon
    When User go to page create account
    And User input "" to field "name"
    And User input "" to field "email"
    And User input "" to field "password"
    And User input "" to field "re enter password"
    And User click button to continue
    Then System display form error on field "name"
    And System display form error on field "email"
    And System display form error on field "password"

  Scenario: Negative case create account field Re-enter password is empty
    When User input "Zepri" to field "name"
    And User input "zepri123@yahoo.com" to field "email"
    And User input "hasi1992" to field "password"
    And User input "" to field "re enter password"
    And User click button to continue
    Then System display form error on field "re enter password"
    And Close browser
