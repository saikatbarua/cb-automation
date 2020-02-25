package automation.page.objects.schoology;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import automation.framework.WebDriverWrapper;
import automation.page.objects.blazedemo.PurchasePage;

public class CoursesPage extends BasePage {
	
	protected WebDriverWrapper driver;
		
	public CoursesPage(WebDriverWrapper driver) {
			super(driver);
			this.driver = driver;
		}
		
	public CoursesPage clickTestCourse() {
			
			driver.clickElement(By.xpath("//a[@href='/course/886059580']"));
			return this;
		}
	
	public CoursesPage clickUpdates() {
		
		driver.clickElement(By.xpath("//a[@href='/course/886059580/updates']"));
		return this;
	}
	
	public CoursesPage enterUpdate(String updateText) {
		driver.clearAndSendKeys(By.xpath("//iframe[@id='edit-body_ifr']"),updateText);
		return this;
	}
	
	public CoursesPage clickPost() {
		driver.clickElement(By.xpath("//input[@type='submit']"));
		return this;
	}
	
	
	public CoursesPage clickIconForUpdatingPost() throws InterruptedException {
		//driver.clickElement(By.xpath("//span[@class='action-links-unfold-text']"));
		driver.hoverElement("//span[contains(text(),'Updating manual post')]");
		
	
		//driver.clickElement(By.xpath ("//div[@class='update-post-action-links']"));
		Thread.sleep(20000);
		return this;
	}
	public CoursesPage clickDeleteRecentPost() {
		
		// generate all list of delete 
		List<WebElement> listOfDelete = driver.findElements(By.xpath("//li/a[contains(text(),'Delete')]")); //this will generate your list of delete
		
		// if size is zero it means there isn't anything to delete, might throw exception
		if (listOfDelete.size() == 0) {
			
			System.out.println("Nothing to delete--there are no post");
		}
		else if (listOfDelete.size() >= 1) {
			
			// since 1 is the first element and thats recent we want to "delete the Recent Post"
			driver.clickElement(listOfDelete.get(1));
		}
		return this;
	}
	
	public CoursesPage clickDeletePostByText(String text) {
		
		// this one is tricky but a good challenge for you
		
		// remember xpath is the direction the page going down, so use .. to help you navigate to the gear button
		
		// this xpath is not finished, use the plugin to help you determine where the the gear to delete button is for the post
	
		// the text is the string of the comment post
		driver.findElement(By.xpath("//p[contains(text(),'"+text+"')]"));
		
		return this;
	}
	
	}


