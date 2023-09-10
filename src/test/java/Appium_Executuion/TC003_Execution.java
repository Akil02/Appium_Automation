package Appium_Executuion;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.StartBase;
import DemoApp.FirstPage;
import DemoApp.Learning1;
import DemoApp.ViewPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC003_Execution {

AndroidDriver driver = null;
	
	@BeforeClass
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new Learning1(driver).ScrollDown();
		KeyEvent overviewKey = new KeyEvent();
        overviewKey.withKey(AndroidKey.BACK); 
        driver.pressKey(overviewKey);
        new Learning1(driver).Swipe();
	}
	
	@AfterClass
	public void End() {
		driver.quit();
	}
}
