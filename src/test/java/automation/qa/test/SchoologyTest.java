package automation.qa.test;

import org.testng.annotations.Test;

import automation.framework.BaseTest;
import automation.page.objects.schoology.LandingPage;
import automation.page.objects.schoology.LoginPage;


public class SchoologyTest extends BaseTest {
	
	
	@Test
	public void studentLoginPositiveScenario() { 
	
	//How do we create a landing page?
	LandingPage landingPage = new LandingPage(driver);
	
	LoginPage loginPage = landingPage.clickLogin()
	                                 .enterUsername("saikat.785235@gmail.com")
	                                 .enterPassword("h3ll0passw0rd");
	
	// login and verify page title the user is logged in
	//this is your test
	}

}
