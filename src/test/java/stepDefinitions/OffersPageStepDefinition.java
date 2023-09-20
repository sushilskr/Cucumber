package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
	
public TestContextSetup testContextSetup;
public OffersPage offersPage;

	public String offersPageProductName;
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offersPage = testContextSetup.pageObjectManager.getOffersPageObject();
	}
	
	
	@Then("^User search the product with (.+) on offers page$")
	public void user_search_the_product_with_on_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		offersPage.pagesSize();
		offersPage.offersStats();
		offersPage.searchProduct(shortName);
		offersPageProductName = offersPage.getProductName();
		System.out.println("Offers Page Product Name : "+offersPageProductName);
		
	}
	public void switchToOffersPage() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPageObject();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.switchWindowToChild();
	}
	
	@Then("User compare the product name from offer page with landing page product name")
	public void user_compare_the_product_name_from_offer_page_with_landing_page_product_name() {
		
		Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
	}
	

}
