Feature: User Registration Process

  Background: 
    Given the user navigate to the Cart application
    Given user clicks on  login button
    When the user clicks on the Register button

  #Scenario to test successful user registration.
  Scenario: User Should be registered Successfully
    And the user enters the First Name
    And the user enters the Last Name
    And the user enters the User Name
    And the user enters the Password
    And the user enters the Confirm Password
    And the user select the Gender
    Then the user details should be saved successfully

  Scenario: Password should contain both uppercase & lowercase Characters & Number
    And the user enters the First Name
    And the user enters the Last Name
    And the user enters the User Name
    When they enter a password with only uppercase characters
    Then Appropriate Error message should be displayed

  Scenario: Registration Error Message Validation for Mandatory fields
    When the user submits the form without entering mandatory field
    Then user should see the error message for mandatory field
