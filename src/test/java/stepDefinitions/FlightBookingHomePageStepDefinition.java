package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FlightBookingHomePage;
import utils.TestContextSetup;

public class FlightBookingHomePageStepDefinition {

	public TestContextSetup testContextSetup;
	public FlightBookingHomePage flightBooking;
	
	
	public FlightBookingHomePageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.flightBooking = testContextSetup.pageObjectManager.getFlightBookingObject();
	}
	
	@Given("User goes to the flight booking")
	public void user_goes_to_the_flight_booking() throws InterruptedException {
		flightBooking.goToFlightBooking();
	}
	
	@When("User search the flights")
	public void user_search_the_flights() throws InterruptedException, IOException {
		testContextSetup.genericUtils.switchWindowToChild();
		Thread.sleep(2000);
		flightBooking.selectDepartureCity();
		flightBooking.selectArrivalCity();
		Thread.sleep(2000);
		//flightBooking.selectDepartureDate();
		//Thread.sleep(2000);
		
		flightBooking.selectPassangers();
		flightBooking.selectCurrency();
		flightBooking.selectPassangerType();
		flightBooking.searchFlight();
		Thread.sleep(5000);
	}
	@Then("User see the number of flight available")
	public void user_see_the_number_of_flight_available() {
	}


}
