Feature: Sign In to Website Amazon
  Scenario: Negative case Sign In with wrong password
    Given User go to website amazon
    When User go to page sign in
    And User input "desy1.andriani1@gmail.com" to field "email"
    And User click button to continue
    And User input "andrianisaja" to field "password"
    And User click button sign in
    Then System display box alert error

  Scenario: Negative case Sign In with wrong password
    When User input "andriani123" to field "password"
    And User click button sign in
    Then System display link sign out
    And Close browser