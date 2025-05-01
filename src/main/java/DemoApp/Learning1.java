package DemoApp;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Base.StartBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Learning1 {
	AndroidDriver driver = null;
    
	public Learning1(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void FirstStart() throws MalformedURLException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'WiFi settings']")).click();
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Akil Ganesh");
		driver.findElement(AppiumBy.xpath("(//android.widget.Button)[2]")).click();
		System.out.println("First Start ended");
	}
	
	
	public void LongPress() throws MalformedURLException {
		driver.findElements(AppiumBy.xpath("//android.widget.TextView")).get(12).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc = 'Expandable Lists']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc = '1. Custom Adapter']")).click();
		TouchAction touchAction = new TouchAction(driver);
		touchAction
		    .longPress(ElementOption.element(driver.findElement(By.xpath("//android.widget.TextView[@text = 'People Names']"))))  // Long press on the element
		    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))  // Wait for a specific duration (adjust as needed)
		    .release()  // Release the press
		    .perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Sample action']")).click();
		driver.quit();
	}
	

	public void ScrollDown() throws MalformedURLException, Exception {
		driver.findElements(AppiumBy.xpath("//android.widget.TextView")).get(12).click();
		Dimension screenSize = driver.manage().window().getSize();
		int startX = screenSize.getWidth() / 2;
		int startY = (int) (screenSize.getHeight() * 0.9);  // 80% from the top
		int endY = (int) (screenSize.getHeight() * 0.1);    // 20% from the top
		
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"TextFields\").instance(0))")).click();
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("Just basic test");
	}
	
	public void Swipe() throws MalformedURLException {
	//	driver.findElements(AppiumBy.xpath("//android.widget.TextView")).get(12).click();
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"Gallery\").instance(0))")).click();	
		driver.findElement(By.xpath("//android.widget.TextView[@text = '1. Photos']")).click();
	
	}
}
