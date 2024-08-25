Feature: Compare the product name from landing and offers page
  
  @OffersPage
  Scenario Outline: Check if product name at landing page is same as offers page
    Given User is on landing page
    When User search the product with <name> on landing page
    Then User search the product with <name> on offers page
    And User compare the product name from offer page with landing page product name
    #Need to add new features here

    Examples:
    |     name     |
    |			Tom				 |
    |			Straw		 |