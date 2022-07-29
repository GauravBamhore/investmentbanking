package KitePOM;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class HomePage {

	
	@FindBy (xpath = "//span[text()='TCS']") private WebElement tcsStock;
	@FindBy (xpath = "//button[@class='button-blue buy']") private WebElement buyicon;
	@FindBy (xpath =  "(//input[@type='number'])[2]") private WebElement priceTab;
	@FindBy (xpath = "//div[@class='four columns quantity']//input[@type='number']") private WebElement qtyField;
	@FindBy (xpath = "//button[@type='submit']") private WebElement buyBtn;
	@FindBy (xpath = "(//td[@class='order-status right'])[5]") private WebElement status;
	@FindBy (xpath = "//a[@class='orders-nav-item']") private WebElement orderBtn;
	@FindBy (xpath = "//span[@class='user-id']") private WebElement userIDIcon;
	@FindBy (xpath = "(//a[normalize-space()='Logout'])[1]") private WebElement logoutBtn;
	@FindBy (xpath = "(//a[normalize-space()='Change user'])[1]") private WebElement changeUser;
	@FindBy (xpath = "//button[normalize-space()='S']") private WebElement sellIcon;
	@FindBy (xpath = "//span[@class='icon icon-align-center']") private WebElement marketDepth;
	@FindBy (xpath = "(//span[@class='icon icon-trending-up'])[1]") private WebElement chart;
	@FindBy (xpath = "(//span[@class='icon icon-trash'])[1]") private WebElement delete;
	@FindBy (xpath = "(//button[@class='context-menu-button button-outline'])[1]") private WebElement more;
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]") private WebElement wishlistSeachFeild;
	@FindBy (xpath = "(//span[@class='tradingsymbol'][normalize-space()='INFY'])[1]") private WebElement infoSysStock;
	@FindBy (xpath = "(//span[@class='symbol'])[2]") private WebElement addedInfoSysStock;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveToTCSStock(Actions act) throws InterruptedException
	{
		act.moveToElement(tcsStock).perform();
		Thread.sleep(500);
	}
	
	public void clickOnBuyIcon(Actions act) throws InterruptedException
	{
		act.click(buyicon).perform();
		Thread.sleep(500);
	}
	public String getStatusQtyField()
	{
		String qtyFiledValue = qtyField.getAttribute("min");
		return qtyFiledValue;
		
	}
	public void enterStockPrice(Actions act, String price) throws InterruptedException
	{
		priceTab.clear();
		Thread.sleep(500);
		act.sendKeys(priceTab, price).perform();
		Thread.sleep(500);
	}
	public void clickOnBuyButton(Actions act) throws InterruptedException
	{
		act.click(buyBtn).perform();
		Thread.sleep(500);
	}
	public void clickOnOrderButton(Actions act) throws InterruptedException
	{
		act.click(orderBtn).perform();
		
	}
	public String getStatus()
	{
		String value = status.getText();
		return value;
	}
	public boolean buyOption()
	{
		return buyicon.isDisplayed();
	}
	public boolean sellOption()
	{
		return sellIcon.isDisplayed();
	}
	public boolean marketDepthOption()
	{
		return marketDepth.isDisplayed();
	}
	public boolean chart()
	{
		return chart.isDisplayed();
	}
	public boolean delete()
	{
		return delete.isDisplayed();
	}
	public boolean more()
	{
	    return more.isDisplayed();	
	}
	
	public void stockAdd(Actions act) throws IOException, InterruptedException
	{
		act.sendKeys(wishlistSeachFeild, "info").perform();
		Thread.sleep(1000);
		act.click(infoSysStock).perform();
	
	}
	public String stockPresence()
	{
		return addedInfoSysStock.getText();
	}
	public void logout(Actions act) throws InterruptedException
	{
		
		act.click(userIDIcon).perform();
		Thread.sleep(1000);
		act.click(logoutBtn).perform();
		Thread.sleep(1000);
		act.click(changeUser).perform();
	}
	
	
}
