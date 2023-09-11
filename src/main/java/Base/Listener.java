package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

public class Listener implements ITestListener{

	@Attachment
	public byte[] saveFailureScreenShot(AndroidDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + iTestResult.getName() + " failed");
		Object testClass = iTestResult.getInstance();
		AndroidDriver driver = new StartBase().getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof AndroidDriver) {
			System.out.println("Screenshot captured for test case:" + iTestResult.getName());
			saveFailureScreenShot(driver);
		}
		saveTextLog(iTestResult.getName() + " failed and screenshot taken!");	
	}		

    		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    	
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   	
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }
	
	
}
