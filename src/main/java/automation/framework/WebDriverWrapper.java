package automation.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverWrapper extends BaseTest {
	
	protected WebDriver driver;
	
	public WebDriverWrapper(WebDriver driver) {
		this.driver = driver;
	}
//this is a method for maximizing the window 
	public void maximizeWindow() {
		System.out.println("Maximize Window");
		driver.manage().window().maximize();
	}
	
	public void get(String url) {
		System.out.println("----Opening page to : " +url);
		driver.get(url);
	}
	
	public void close() {
		driver.close();
	}
	
	public WebElement findElement(By by) {
		
		// fix this
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Finding WebElement..." + by);
		WebElement elem = driver.findElement(by);
		highlightWebElement(elem);
		return elem;
	}
	
	private void highlightWebElement(WebElement elem) {
		
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elem);
			
		} catch (Exception e) {
			
			// log if something goes wrong
		}
		
	}
	
	public void clearAndSendKeys(By by, String value) {
		
		findElement(by).clear();
		findElement(by).sendKeys(value);
		
	}
	
	public void selectFromDropdown(By by, String selection) {
		
		//this is from selenium
		Select select = new Select(driver.findElement(by));
		select.selectByValue(selection);
		
	}
	
	public void clickElement(By by) {
		
		driver.findElement(by).click();
	}
	
	public String getTextFrom(By by) {
		
		return driver.findElement(by).getText();
	}

}
