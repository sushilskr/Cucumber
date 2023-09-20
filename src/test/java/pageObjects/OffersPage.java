package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OffersPage {
	public WebDriver driver;
	public int offerTotalPrice=0;
	public int offerTotalDiscount=0;
	float discountPercentage;
	
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	By search= By.cssSelector("input#search-field");
	By productName = By.xpath("//tbody/tr/td[1]");
	By pageSize = By.id("page-menu");
	By fruitVegNames = By.cssSelector("td:nth-last-child(3)");
	By allPrice = By.cssSelector("td:nth-last-child(2)");
	By allDiscounts = By.cssSelector("td:nth-last-child(1)");
	
	
	public void searchProduct(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void pagesSize() {
		Select select = new Select(driver.findElement(pageSize));
		select.selectByValue("20");
	}
	
	public void offersStats() {
		List<WebElement> itemNames = driver.findElements(fruitVegNames);
		
		List<WebElement> price = driver.findElements(allPrice);
		for(int i=0;i<price.size();i++) {
			offerTotalPrice = offerTotalPrice+Integer.parseInt(price.get(i).getText());
		}
		
		List<WebElement> discount = driver.findElements(allDiscounts);
		for(int i=0;i<price.size();i++) {
			offerTotalDiscount =offerTotalDiscount+ Integer.parseInt(discount.get(i).getText());
		}
		
		System.out.println("Total Number of products at Offers Page : "+itemNames.size());
		System.out.println("Total Price at Offers Page : "+offerTotalPrice);
		System.out.println("Total Discount at Offers Page : "+offerTotalDiscount);
		
		discountPercentage = 100*offerTotalDiscount/offerTotalPrice;
		System.out.println("Total Discount percentage : "+discountPercentage+"%");
		
	}
	
}












