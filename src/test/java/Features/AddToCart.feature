Feature: Products Test

  Background: 
    # Setting up the common steps that need to be performed before each scenario
    Given the user navigates to the BookCart application1
    And user navigates to the BookCart
    
   

  Scenario: Add a item to Cart
    #User adds a book to their cart and verifies the cart badge updates
    And user searches for a book
    When user add the book to the cart
    Then the cart badge should get updated
    
    
   #Scenario: Increase the quantity of a product using the plus button
   #When the user clicks the plus button for the product quantity
   # Then the product quantity should increase by 1

  #Scenario: Decrease the quantity of a product using the minus button
    #When the user clicks the minus button for the product quantity
    #Then the product quantity should decrease by 1

 Scenario: Remove an item from the cart
  And the cart contains the selected item
  Then the user removes the item from the cart

 
