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

public class TC002_Execution {

AndroidDriver driver = null;
	
	@BeforeClass
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new Learning1(driver).FirstStart();
		System.out.println("Started after that");
		KeyEvent overviewKey = new KeyEvent();
        overviewKey.withKey(AndroidKey.BACK); 
        System.out.println("Success till now");
        driver.pressKey(overviewKey);
        driver.pressKey(overviewKey);
        new Learning1(driver).LongPress();
	}
	
	@AfterClass
	public void End() {
		driver.quit();
	}
}
