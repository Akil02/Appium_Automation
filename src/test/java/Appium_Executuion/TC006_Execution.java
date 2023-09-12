package Appium_Executuion;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.StartBase;
import DemoApp.FirstPage;
import DemoApp.Learning1;
import DemoApp.Learning2;
import DemoApp.Preferance_page;
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

public class TC006_Execution {

AndroidDriver driver = null;
	
	@BeforeClass
	@Description("Launching the App")
	@Epic("TC005_TestCase")
	@Feature("Starting the App")
	@Story("Checking whether App is getting started")
	@Step("Open APP Demo app")
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new FirstPage(driver).Views();
		new ViewPage(driver).UIVisibility();
		new ViewPage(driver).VidioPlayer();
		new ViewPage(driver).Vidio_play();
		new ViewPage(driver).vidio_skip(0.8);
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@id = 'io.appium.android.apis:id/content']")).click();
		new ViewPage(driver).vidio_playbutton();
	}
	
	@AfterClass
	@Description("Closing the the App after execution")
	@Epic("TC005_TestCase")
	@Feature("Closing the App")
	@Story("Checking whether App is getting closed")
	@Step("Close APP Demo app")
	public void End() {
		driver.quit();
	}

}
