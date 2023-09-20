package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	public WebDriver driver;
	public String checkOutPageProductName;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	By cart= By.cssSelector("a.cart-icon");
	By proceedToCheckout = By.xpath("//button[contains(text(),\"PROCEED\")]");
	
	By checkOutPageProduct = By.xpath("//div//table//tbody//tr//td//p[@class='product-name']");
	By checkOutPageProductQuantity = By.cssSelector("p.quantity");
	By checkOutPageProductPrice = By.xpath("(//tr//td//p[@class='amount'])[1]");
	By checkOutPageProductTotal = By.xpath("(//tr//td//p[@class='amount'])[2]");
	
	By promoInput = By.cssSelector("input.promocode");
	By promoButton = By.className("promoBtn");
	By promoMessage = By.cssSelector(".promoInfo");
	By placeOrder = By.xpath("//button[contains(text(),\"Place Order\")]");
	By selectCountry = By.xpath("//select");
	By termsAndConditions = By.cssSelector("input.chkAgree");
	By confirmOrder = By.xpath("//button[contains(text(),\"Proceed\")]");
	
	public void proceedToCheckout() {
		driver.findElement(cart).click();
		driver.findElement(proceedToCheckout).click();
	}
	
	public void applyPromo() {
		driver.findElement(promoInput).sendKeys("abcd");
		driver.findElement(promoButton).click();
	}
	
	public void placeOrder() {
		driver.findElement(placeOrder).click();
	}
	
	public String promoCodeStatus() {
		return driver.findElement(promoMessage).getText();
	}
	
	public void confirmOrder() throws InterruptedException {
		Select select = new Select(driver.findElement(selectCountry));
		select.selectByValue("India");
		driver.findElement(termsAndConditions).click();
		driver.findElement(confirmOrder).click();
	}
	
	public String getCheckoutPageProductName() {
		return driver.findElement(checkOutPageProduct).getText().split("-")[0].trim();
	}
	
	public boolean isTotalPriceMatchingWithQuanityAndPrice() {
		int quantity = Integer.parseInt(driver.findElement(checkOutPageProductQuantity).getText());
		int price = Integer.parseInt(driver.findElement(checkOutPageProductPrice).getText());
		int totalPrice = Integer.parseInt(driver.findElement(checkOutPageProductTotal).getText());
		
		int caculatedTotal = quantity*price;
		System.out.println("Printed Price : "+totalPrice);
		System.out.println("Calculated Price : "+caculatedTotal);
		
		return totalPrice==caculatedTotal;
	}

}
