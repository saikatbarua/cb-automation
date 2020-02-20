package automation.qa.test;

import org.testng.annotations.Test;

import automation.framework.BaseTest;
import automation.page.objects.schoology.LandingPage;
import automation.page.objects.schoology.LoginPage;

public class SchoologyTest extends BaseTest{
	
	@Test
	public void studentLogInPositiveScenario() {
		LandingPage landingPage = new LandingPage(driver);
		
		LoginPage loginpage = landingPage.clickLogin()
								.enterUsername("maytesting551@gmail.com")
								.enterPassword("pwdmay3534");
		

}

	// new comment 
}
