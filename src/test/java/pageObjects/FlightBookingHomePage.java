package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingHomePage {
	
	public WebDriver driver;

	
	public FlightBookingHomePage(WebDriver driver) {
							this.driver = driver;
	}
	
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
	
	
	By flightBookingPage = By.linkText("Flight Booking");
	By selectCity = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By departureCity = By.xpath("(//a[@value='BLR'])[1]");
	By arrivalCity = By.xpath("(//a[@value='DEL'])[2]");
	
	By calendar = By.id("ctl00_mainContent_view_date1");
	By departureDate = By.xpath("//table[@class='ui-datepicker-calendar']//td//a[contains(text(),'24')]");
	
	By passangers = By.id("divpaxinfo");
	By adult = By.id("hrefIncAdt");
	By currency = By.id("ctl00_mainContent_DropDownListCurrency");
	By search = By.id("ctl00_mainContent_btn_FindFlights");
	
	By passangerType = By.id("ctl00_mainContent_chk_StudentDiscount");
	
	By pan = By.xpath("//div[@id='flightSearchContainer']");
	
//	By departureCity = By.xpath("//select[@name='ctl00$mainContent$ddl_originStation1']");
//	By arrivalCity = By.xpath("//select[@name='ctl00$mainContent$ddl_destinationStation1']");
	
	public void goToFlightBooking() throws InterruptedException {
		driver.findElement(flightBookingPage).click();
		Thread.sleep(2000);
	}
	
	public void selectDepartureCity() {
		driver.findElement(selectCity).click();
		driver.findElement(departureCity).click();
		//wait.until(ExpectedConditions.elementToBeClickable(departureCity));
//		driver.findElement(departureCity).click();
//		Select select = new Select(driver.findElement(departureCity));
//		select.selectByValue("BLR");
	}
	public void selectArrivalCity() {
		driver.findElement(arrivalCity).click();
		//wait.until(ExpectedConditions.elementToBeClickable(arrivalCity));
//		driver.findElement(arrivalCity).click();
//		Select select = new Select(driver.findElement(arrivalCity));
//		select.selectByValue("DEL");
	}
	public void selectDepartureDate() {
		driver.findElement(calendar).click();
		driver.findElement(departureDate).click();
	}
	public void selectPassangers() throws InterruptedException {
		driver.findElement(pan).click();
		driver.findElement(passangers).click();
		Thread.sleep(2000);
		driver.findElement(adult).click();
	}
	
	public void selectCurrency() {
		Select select = new Select(driver.findElement(currency));
		select.selectByValue("INR");
	}
	public void searchFlight() {
		driver.findElement(search).click();
	}
	public void selectPassangerType() {
		driver.findElement(passangerType).click();
	}
		
}













