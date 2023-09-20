package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public FlightBookingHomePage flightBooking; 
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public   LandingPage getLandingPageObject() {
	landingPage = new LandingPage(driver);
	return landingPage;
	}
	
	public OffersPage getOffersPageObject() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPageObject() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	public FlightBookingHomePage getFlightBookingObject() {
		flightBooking = new FlightBookingHomePage(driver);
		return flightBooking;
	}
}
