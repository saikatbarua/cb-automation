package automation.qa.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import automation.framework.BaseTest;
import automation.page.objects.ConfirmationPage;
import automation.page.objects.PurchasePage;
import automation.page.objects.SearchPage;
import automation.page.objects.SelectionFlightsPage;


public class SearchForFlightsTest extends BaseTest {
  
  @Test
  public void searchForDomesticFlights() {
	  
	  //chain
	  SearchPage searchPage = new SearchPage(driver);
	  searchPage.selectDepartCity("Boston");
	  searchPage.selectDestinationCity("New York");
	  searchPage.clickFindFlightsBtn();
	  
	  SelectionFlightsPage selectFP = new SelectionFlightsPage(driver);
	  selectFP.clickFirstFlightFromResults();

  }
  
  @Test
  public void purchaseInternationalFlights() throws InterruptedException {
	  
	  // browser launches to home page which has a search feature
	  SearchPage searchPage = new SearchPage(driver);
	  
	  // User searches for flights
	  SelectionFlightsPage selectionFlightsPage  = searchPage.selectDepartCity("Paris")
	                                                         .selectDestinationCity("New York")
	                                                         .clickFindFlightsBtn();
	  
	  // User selects first result
	  PurchasePage purchasePage = selectionFlightsPage.clickFirstFlightFromResults();
	  
	  System.out.println("before clicking flight");
	  Thread.sleep(2000);

	
	  System.out.println("after clicking flight");
	  
	  //User enters information
	  ConfirmationPage confirmPage = purchasePage.enterName("John Smith").enterAddress("145 Germany St")
								  									     .enterCity("Alexandria")
								  									     .selectState("Virginia")
								  									     .selectZipCode("22031")
								  									     .selectCardType("dinersclub")
								                                         .selectCreditCardNumber("6343-6638-4083-8756")
								                                         .selectCreditCardMonth("12")
								                                         .selectCreditCardYear("2018")
								                                         .selectNameOnCard("Mary Jones")
								                                         .clickRememberMeCheckBox()
								                                         .purchaseFlightBtn();
	  
	  //now verification ticket was purchased
	  Assert.assertEquals(confirmPage.getHeaderMessage(), "Thank you for your purchase today   !");
	  
  }
  
}
