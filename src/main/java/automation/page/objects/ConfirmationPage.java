package automation.page.objects;

import org.openqa.selenium.By;

import automation.framework.WebDriverWrapper;

public class ConfirmationPage extends BasePage {
	
	protected WebDriverWrapper driver;

	public ConfirmationPage(WebDriverWrapper driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	public String getHeaderMessage() {
		
		String value = driver.getTextFrom(By.xpath("//h1"));
		
		return value;
		
	}
	
	

}
