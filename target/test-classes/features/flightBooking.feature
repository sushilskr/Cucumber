Feature: Booking the flight
  
  @FlightBooking
  Scenario Outline: Check if user is able to book the flight from Bengaluru to Delhi
    Given User is on landing page
    And User goes to the flight booking
    When User search the flights
    Then User see the number of flight available

    
    
    
    
    