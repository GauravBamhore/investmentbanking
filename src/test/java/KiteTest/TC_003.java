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
import KitePOM.HomePage;
import KitePOM.PinPage;
import KitePOM.WithdrawFunds;
import KitePOM.loginPage;

public class TC_003 extends Base {
 
	
	loginPage login;
	PinPage pin;
	Actions act;
	HomePage home;
	WithdrawFunds fund;
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
		fund= new WithdrawFunds(driver);
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
      public void fundsWithdrawalValidation() throws IOException, InterruptedException {
		
		fund.clickOnFundsTab();
		fund.clickOnWithdrawnFundTab();
		Utility.impWait(4);
		fund.windowHandle(driver);
		Utility.expwait("//input[@name='eqWithdrawalValue']");
		fund.enterWithdrawalAmount(Utility.fetchDFMypropertyFile("WithdrawalAmount"));
		fund.clickOnContinueButton();
		soft.assertTrue(fund.withdrwalBlockPresence(), "The withdrwal block is not showing after clicking on continue button");
		
		soft.assertAll();	
		
		
  }
	
	
	
	
	
	
}
