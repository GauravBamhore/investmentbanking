package BaseANDUtility;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	protected static WebDriver driver;
	
	public void chromeBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Testing Class Notes\\Project\\InvestmentBankingProjectVER.1\\Driver\\chromedriver.exe");
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notifications");
	    option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
		driver.get(Utility.fetchDFMypropertyFile("URL"));
	}
	public void fireFoxBrowser() throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Testing Class Notes\\Project\\InvestmentBankingProjectVER.1\\Driver\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get(Utility.fetchDFMypropertyFile("URL"));
		
	}
	
	

	

}
