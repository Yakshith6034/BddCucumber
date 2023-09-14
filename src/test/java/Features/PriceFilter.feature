Feature: Price Filter

  Scenario: User selects a product from the selected price filter
    Given the user opens the BookCart Application
    Given User clicks on the login button
    Given User enters username
    Given User enters password
    Given User clicks on Login button
    Then User should be able to Adjust the Pricing and add the items
