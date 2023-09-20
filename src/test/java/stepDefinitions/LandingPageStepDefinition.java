package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPageObject();
	}
	
	
	@Given("User is on landing page")
	public void user_is_on_landing_page() throws IOException {
		System.out.println("Title of the Page : "+testContextSetup.testBase.webDriverManager().getTitle());
	}
	
	@When("^User search the product with (.+) on landing page$")
	public void user_search_the_product_with_on_landing_page(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(1000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Landing Page Product Name : "+testContextSetup.landingPageProductName);
	
	}
	
	@When("^User add the item (.+) times$")
	public void user_add_the_item_times(String string) throws InterruptedException {
	   landingPage.incrementItem(string);
	   landingPage.addToCart();
	}
	
	@When("User search the products and add to the cart")
	public void user_search_the_products_and_add_to_the_cart(DataTable dataTable) throws InterruptedException
	{
		List<Map<String, String>> itemsWithCounts = dataTable.asMaps(String.class, String.class);
		//List<String> itemNames = dataTable.asList(String.class);
		for (Map<String, String> itemWithCount : itemsWithCounts)
        {
			String itemName = itemWithCount.get("Item");
            int itemCount = Integer.parseInt(itemWithCount.get("Count"));
        	landingPage.searchAndAddItemToCart(itemName,itemCount);
        }
    Thread.sleep(1000);
	}


}
