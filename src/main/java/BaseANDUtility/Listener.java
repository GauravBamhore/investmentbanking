package BaseANDUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class Listener extends Base implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		try {
			Utility.captureScreenShot(result.getName());
			Reporter.log(result.getName()+" Has Failed>> Please Troubleshot",true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
 	
}

