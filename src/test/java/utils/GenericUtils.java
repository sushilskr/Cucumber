package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {

    public enum Timeouts{
        NOMINAL_TIMEOUT(Duration.ofSeconds(1)),
        MINIMUM_TIMEOUT(Duration.ofSeconds(5)),
        LOADING_TIMEOUT(Duration.ofSeconds(15));

        private Duration duration;

        Timeouts(Duration duration){
            this.duration = duration;
        }
        private Duration getDuration(){ return duration;}

        @Override
        public String toString(){
            return "Timeouts [" + name() +
                    "] seconds = " + duration;
        }
    }
	
	public static WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchWindowToChild() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
	}

    public static WebElement waitForElementDisplay(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Timeouts.LOADING_TIMEOUT.getDuration());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
