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
import DemoApp.Learning2;
import DemoApp.ViewPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC004_Execution {

AndroidDriver driver = null;
	
	@BeforeClass
	@Description("Launching the App")
	@Epic("TC004_TestCase")
	@Feature("Starting the App")
	@Story("Checking whether App is getting started")
	@Step("Open APP Demo app")
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new Learning2(driver).DragDrop();
		KeyEvent overviewKey = new KeyEvent();
        overviewKey.withKey(AndroidKey.BACK); 
        driver.pressKey(overviewKey);
        driver.pressKey(overviewKey);
        new Learning2(driver).Mobile_turn();
		
	}
	
	@AfterClass
	@Description("Closing the the App after execution")
	@Epic("TC004_TestCase")
	@Feature("Closing the App")
	@Story("Checking whether App is getting closed")
	@Step("Close APP Demo app")
	public void End() {
		driver.quit();
	}
}
