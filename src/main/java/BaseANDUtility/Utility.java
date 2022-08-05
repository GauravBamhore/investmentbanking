package BaseANDUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class Utility extends Base {

	     
		public static String fetchDFMypropertyFile(String key) throws IOException
		{
			Properties prop = new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\bamho\\eclipse-workspace\\investmentbanking\\prop.properties");
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;
		}
		
		public static void captureScreenShot( String TCID) throws IOException
		{
			 File tempMemory = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String str = RandomString.make(4);
			 File localDrive= new File("C:\\Users\\bamho\\eclipse-workspace\\investmentbanking\\ScreenShots"+TCID+""+str+".png");
			 FileHandler.copy(tempMemory, localDrive);
		}
		
		public static void impWait(int time)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}
		
		public static void expwait(String path) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			
		}
		
		public static void scrollingToEndPage()
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		public static void scrollingToFirstPage()
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,0)");
		}
		

	}


