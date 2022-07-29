package KiteTest;

import java.io.IOException;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseANDUtility.Base;
import BaseANDUtility.Utility;
import KitePOM.Funds;
import KitePOM.HomePage;
import KitePOM.PinPage;
import KitePOM.loginPage;

public class TC_002 extends Base {
 
	loginPage login;
	PinPage pin;
	Actions act;
	HomePage home;
	Funds fund;
	SoftAssert soft;
	@Parameters("browsername")
	@BeforeClass
	public void browserlaunching(String name) throws IOException
	{
		
		if(name.equals("chrome"))
		{
			chromeBrowser();
		}
		else if (name.equals("firefox"))
		{
			fireFoxBrowser();
		}
		login = new loginPage(driver);
		pin = new PinPage(driver);
		home = new HomePage(driver);
		fund = new Funds(driver);
		act = new Actions(driver);
		soft = new SoftAssert();
		
	}
	@BeforeMethod
	public void login() throws IOException
	{
		login.enterUsername(act, Utility.fetchDFMypropertyFile("UN"));
		login.enterPassword(act, Utility.fetchDFMypropertyFile("PW"));
		login.clickOnLoginButton(act);
		Utility.impWait(5);
		pin.enterMPin(act, Utility.fetchDFMypropertyFile("PIN"));
		pin.clickOnContinueBtn(act);
		Utility.impWait(2);
	}
	
	@Test
      public void fundsWindowValidation() {
		
		fund.clickOnFundsTab();
		fund.clickOnAddFundsTab();
		fund.windowHandle(driver);
		
		Utility.impWait(4);
		soft.assertEquals(fund.validatingPageHeading(), "Deposit funds", "The page heading is Not matching");
		soft.assertEquals(fund.validatingClientName(), "Gaurav Beniram Bamhore", "The client name is Not matching");
		soft.assertEquals(fund.validatingClientID(), "VLE690", "The client ID is Not matching");
		
		//Entering amount to be added
		fund.enterAmount();
		soft.assertTrue(fund.validatingSegment(), " The segment content is not matching");
		soft.assertTrue(fund.validatingAccount(), "The account name is Not matching");
		fund.clickOnRadioButton();
		soft.assertFalse(fund.validatingVirtualPaymentField(), "The virtual payment option is showing even after selecting net banking option");
		fund.clickOnContinueButton();
		
		//fetching title of bank page
		soft.assertEquals(fund.getTitle(driver), "STATE BANK OF INDIA","error message is not generating");
		soft.assertAll();
		
  }
}	
	

