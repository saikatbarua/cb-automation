package automation.page.objects;

import org.openqa.selenium.By;

import automation.framework.WebDriverWrapper;

public class SelectionFlightsPage extends BasePage {
	
	protected WebDriverWrapper driver;

	public SelectionFlightsPage(WebDriverWrapper driver) {
		super(driver);
		this.driver = driver;
	}
	
	public PurchasePage clickFirstFlightFromResults() {
		
		driver.clickElement(By.xpath("//tbody/tr[1]/td/input"));
		return new PurchasePage(driver);
	}

}
