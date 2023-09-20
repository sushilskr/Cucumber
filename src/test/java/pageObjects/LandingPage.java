package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
							this.driver = driver;
	}
	
	By search=By.cssSelector("input[type=\"search\"]");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.xpath("//button[contains(text(),\"ADD TO CART\")]");
	
	public void searchItem(String shortName) throws InterruptedException {
		driver.findElement(search).sendKeys(shortName);
		Thread.sleep(1000);
	}
	
	public String  getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals() {
		driver.findElement(By.linkText("Top Deals")).click();
	}
	
	public void incrementItem(String count) throws InterruptedException {
		int itemCount = Integer.parseInt(count);
		
		for(int item=2;item<=itemCount;item++) {
		driver.findElement(increment).click();
		}
	}
	
	public void addToCart() throws InterruptedException {
		driver.findElement(addToCart).click();
	}
	
	public void searchAndAddItemToCart(String itemName, int count) throws InterruptedException 
	{
		driver.findElement(search).sendKeys(itemName);
		Thread.sleep(1000);
		for(int item=2;item<=count;item++) {
		driver.findElement(increment).click();
		}
		driver.findElement(addToCart).click();
		driver.findElement(search).clear();
	}
	
}













