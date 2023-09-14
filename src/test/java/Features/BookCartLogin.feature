Feature: User Authentication test

  Background: 
    # This background section defines common steps that are executed before each scenario.
    Given when user navigates to the BookCart application

  Scenario: Login should be success
    # This scenario tests a successful login attempt.
    And User enters the username
    And User enters the password
    When user clicks on Login button
    Then Login should be successful

  Scenario: Login should be Fail(Invalid Username & password)
    # This scenario tests a failed login attempt.
    And user enters the invalid username
    And user enters the invalid password
    When user clicks on Login button
    Then Login should be Fail

  Scenario: Failed Login(Invalid Username)
    # This scenario tests a failed login attempt.
    And user enters an invalid username
    And user enters a valid password
    When user clicks on Login button
    Then Login should fail

  Scenario: Failed Login(Invalid Password)
    # This scenario tests a failed login attempt.
    And user enters a valid username
    And User enters an invalid password
    When user clicks on Login button
    Then login Should fail
