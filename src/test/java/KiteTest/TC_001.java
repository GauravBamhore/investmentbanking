package KiteTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseANDUtility.Base;
import BaseANDUtility.Utility;
import KitePOM.HomePage;
import KitePOM.PinPage;
import KitePOM.loginPage;

@Listeners(BaseANDUtility.Listener.class)
public class TC_001 extends Base{
	loginPage login;
	PinPage pin;
	Actions act;
	HomePage home;
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
	  act = new Actions(driver);
	  soft = new SoftAssert();
  }
  @BeforeMethod
  public void LoginIntoTheKite() throws IOException, InterruptedException {
	  Utility.impWait(2);
	  login.enterUsername(act, Utility.fetchDFMypropertyFile("UN"));
	  login.enterPassword(act, Utility.fetchDFMypropertyFile("PW"));
	  login.clickOnLoginButton(act);
	  Utility.impWait(2);
	  pin.enterMPin(act, Utility.fetchDFMypropertyFile("PIN"));
	  pin.clickOnContinueBtn(act);
	  Utility.impWait(2);
	
  }
  
  @Test(enabled=true)
  public void validateOrderStatus() throws InterruptedException, IOException {
	
	  
	  home.moveToTCSStock(act);
	  home.clickOnBuyIcon(act);// skipped clicking>> for failing TC
	  home.enterStockPrice(act, Utility.fetchDFMypropertyFile("PRICE"));
	  home.clickOnBuyButton(act);
	  home.clickOnOrderButton(act);
	  Utility.impWait(2);
	  
	   
	  Assert.assertEquals(home.getStatus(),"COMPLETED", "Order status is not Rejected");
	  Reporter.log("Order status is Rejected>>TC Passed",true);
	  
	  
  }
  @Test(enabled=false)
  public void quantityFiledStatus() throws InterruptedException
  {
	
	  home.moveToTCSStock(act);
	  home.clickOnBuyIcon(act);
	  Assert.assertEquals(home.getStatusQtyField(),"1", "The By default Value in Quantity Field is Not 1");
      Reporter.log("By Default Value in Qty Field is 1 ",true);
  }
  @Test(enabled=false)
  public void validateTradingOptionsPresence() throws InterruptedException
  {
	  home.moveToTCSStock(act);
	  soft.assertTrue(home.buyOption(),"Buy Icon is Not Present on Home Page");
	  soft.assertTrue(home.sellOption(),"Sell Icon is Not Present on Home Page");
	  soft.assertTrue(home.marketDepthOption(),"Market Depth Icon is Not Present on Home Page");
	  soft.assertTrue(home.chart(),"Chart is Not Present on Home Page");
	  soft.assertTrue(home.delete(),"Delete Icon is Not Present on Home Page");
	  soft.assertTrue(home.more(),"More Icon is Not Present on Home Page");
	  soft.assertAll();
	  
  }
  @Test(enabled=false)
  public void validateAdditionOfStockInWishlist() throws IOException, InterruptedException
  {
	  home.stockAdd(act);
	  soft.assertEquals(home.stockPresence(),"INFO", "The Stock has Not Added");
	  soft.assertAll();
  }
  
  
  @AfterMethod
  public void logoutKiteApp() throws InterruptedException
  {
	  home.logout(act);
	  
  }
  
  @AfterClass
	public void browserClosing()
	{
		driver.close();
	}
}
