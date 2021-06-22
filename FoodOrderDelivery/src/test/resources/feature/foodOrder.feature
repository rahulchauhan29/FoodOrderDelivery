Feature: Add food item into cart

  @addItem
  Scenario: Add food items into cart
  Given User is on home page
  #When user login with valid credentials
  When user enter the food delivery location
  And select the restaurant
  And select the food item and quantity
  And sent them into cart
  Then Food is added to cart successfully
  
  
 @clearCart
  Scenario: clear the cart values
  Given User is on home page
  When user enter the food delivery location
  And select the restaurant
  And select the food item and quantity
  And sent them into cart
  And Food is added to cart successfully
  Then Click on delete cart values
  And verifies if cart is empty
  
