package KitePOM;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawFunds {

	@FindBy (xpath = "//span[normalize-space()='Funds']") private WebElement fundtab;
	@FindBy (xpath = "//a[normalize-space()='Withdraw']") private WebElement withdrawnFundsTab;
	@FindBy (xpath = "//input[@name='eqWithdrawalValue']") private WebElement amountField;
	@FindBy (xpath = "//button[@type='button']") private WebElement continueButton;
	@FindBy (xpath = "//div[@class='modal-body']") private WebElement equityWithdrawalBlock;
	
	
			//specifying constructor
			public WithdrawFunds(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
	
	public void clickOnFundsTab()
	{
		fundtab.click();
	}
	public void clickOnWithdrawnFundTab()
	{
		withdrawnFundsTab.click();
	}
	
	
	public void windowHandle(WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String mainWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
	}
			
	public void enterWithdrawalAmount(String amount)
	{
		amountField.sendKeys(amount);
	}
	
	public void clickOnContinueButton() 
	{
		continueButton.click();
		
	}
	public boolean withdrwalBlockPresence()
	{
		boolean block = equityWithdrawalBlock.isDisplayed();
		return block;
		
	}
	
			
}
