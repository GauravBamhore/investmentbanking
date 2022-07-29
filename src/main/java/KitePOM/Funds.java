package KitePOM;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Funds {

	@FindBy (xpath = "//span[normalize-space()='Funds']") private WebElement fundtab;
	@FindBy (xpath = "//button[@type='button']") private WebElement addFundTab;
	@FindBy (xpath = "//button[@id='addfunds_submit']") private WebElement continueButton;
	@FindBy (xpath = "//input[@id='addfunds_amount']") private WebElement amountField;
	@FindBy (xpath = "//span[@class='error-message cj-amt-error']") private WebElement errorMessage;
	@FindBy (xpath = "//label[@for='pay_netb']") private WebElement radioButton;
	@FindBy (xpath = "//p[@class='addfunds-name']") private WebElement nameOfClient;
	@FindBy (xpath = "//p[@class='addfunds-id text-right']") private WebElement idOfClient;
	@FindBy (xpath = "//h1[@class='text-center']") private WebElement pageHeading;
	@FindBy (xpath = "//h1[@class='text-center']") private WebElement companyLogo;
	@FindBy (xpath = "(//select[@id='segment_select'])[1]") private WebElement segment;
	@FindBy (xpath = "//select[@id='account_select']") private WebElement account;
	@FindBy (xpath = "//input[@id='addfunds_vpa']") private WebElement virtualPaymentField;
	
	
	
		public Funds(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
		
	public void windowHandle(WebDriver driver)
	{
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	String mainWindow = it.next();
	String cbPopUpwindow = it.next();
	driver.switchTo().window(cbPopUpwindow);
	
	}
	//clicking on fund tab	
	public void clickOnFundsTab()
	{
		fundtab.click();
	}
	//clicking on addFund button	
	public void clickOnAddFundsTab()
	{
		addFundTab.click();
	}
	
	public String validatingPageHeading()
	{
		String name = pageHeading.getText();
		return name; 
	}
	public String validatingClientName()
	{
		String name = nameOfClient.getText();
		return name; 
	}
	
	public String validatingClientID()
	{
		String id = idOfClient.getText();
		return id; 
	}
	public String validatingCompanyLogo()
	{
		String logo = companyLogo.getText();
		return logo; 
	}
	public void enterAmount()
	{
		amountField.sendKeys("1000");
	}
	public boolean validatingSegment()
	{
		boolean seg = segment.getText().contains("Equity/Derivatives/Currency");
		System.out.println(seg);
		return seg; 
	}
	
	public boolean validatingAccount()
	{
		 boolean acct = account.getText().contains("STATE BANK OF INDIA - XXX 4299");
		
		return acct; 
	}
	public boolean validatingVirtualPaymentField()
	{
		boolean vpf = virtualPaymentField.isDisplayed();
		return vpf;
	}
	
	public void clickOnRadioButton()
	{
		radioButton.click();
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public String getTitle(WebDriver driver)
	{
		String title = driver.getTitle();
		return title;
	}
}
