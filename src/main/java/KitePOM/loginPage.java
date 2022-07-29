package KitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage

{

	@FindBy (xpath= "//input[@type='text']") private WebElement userName;
	@FindBy (xpath = "//input[@type='password']") private WebElement passWord;
	@FindBy (xpath = "//button[@type='submit']") private WebElement loginBtn;
	

			public loginPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
	
	public void enterUsername(Actions act, String UN)
	{
		act.sendKeys(userName, UN).perform();
	}
	public void enterPassword(Actions act, String PW)
	{
		act.sendKeys(passWord, PW).perform();
	}
	
	public void clickOnLoginButton(Actions act)
	{
		act.click(loginBtn).perform();
	}
}
