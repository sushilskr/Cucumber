Feature: Add item multiple times and checkout the shopping
  
  @PlaceOrder
  Scenario Outline: Check if user is able to add an item multiple times and going to checkout page
    Given User is on landing page
    When User search the product with <name> on landing page
    And User add the item <count> times
    Then User go to the checkout page
    And User validate the total price with quantity
    And User validate the promo code on checkout page
    And User confirms the order

    Examples:
    |     name     | count |
    |			Tom				 | 5						|
    
    @MulitpleItemOrder
  Scenario: Check if user is able to add mulitple items to the cart and place the order
    Given User is on landing page
    When User search the products and add to the cart
    |Item | Count |
    | tom |			3		|
    |Beet |			5			|
    |Straw|		4				|
    |pot|		4				|
    |bro|		4				|
    Then User go to the checkout page
    And User validate the promo code on checkout page
    And User confirms the order
    
    
    
    
    