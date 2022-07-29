package KitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage {

	@FindBy (id = "pin") private WebElement mpin;
	@FindBy (xpath = "//button[@type='submit']") private WebElement continueBtn;
	
	
			public PinPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
	
	
	public void enterMPin(Actions act, String mPin)
	{
		act.sendKeys(mpin, mPin).perform();
	}
	
	public void clickOnContinueBtn(Actions act)
	{
		act.click(continueBtn).perform();
	}
	
	
}
