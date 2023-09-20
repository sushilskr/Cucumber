package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage =testContextSetup.pageObjectManager.getCheckoutPageObject();
	}
	
	
	@Then("User go to the checkout page")
	public void user_go_to_the_checkout_page() throws InterruptedException {
		checkoutPage.proceedToCheckout();
		Thread.sleep(1000);
	}
	
	@Then("User validate the total price with quantity")
	public void user_validate_the_total_price_with_quantity() {
		System.out.println("CheckoutProductName : "+checkoutPage.getCheckoutPageProductName());
		Assert.assertEquals(checkoutPage.getCheckoutPageProductName(),testContextSetup.landingPageProductName);
		Assert.assertTrue(checkoutPage.isTotalPriceMatchingWithQuanityAndPrice());
	}
	
	@Then("User validate the promo code on checkout page")
	public void user_validate_the_promo_code_on_checkout_page() {
	  checkoutPage.applyPromo();
	  Assert.assertEquals(checkoutPage.promoCodeStatus(), "Invalid code ..!");
	  checkoutPage.placeOrder();
	}

	@Then("User confirms the order")
	public void user_confirms_the_order() throws InterruptedException {
		checkoutPage.confirmOrder();
	}


}
