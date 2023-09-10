package Appium_Executuion;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.StartBase;
import DemoApp.FirstPage;
import DemoApp.ViewPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TC001_Execution {

	AndroidDriver driver = null;
	
	@BeforeClass
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new FirstPage(driver).Views();
		new ViewPage(driver).WebView3();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'Open Chrome']")).click();
		driver.findElement(AppiumBy.id("android:id/aerr_app_info")).click();
		Thread.sleep(2000);
		try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\SQL\\Learning\\src\\main\\java\\Base\\screenshot.png"));
            System.out.println("Screenshot taken and saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to take a screenshot: " + e.getMessage());
        }
	}
	
	@AfterClass
	public void End() {
		driver.quit();
	}
}
