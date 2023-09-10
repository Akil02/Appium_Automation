package DemoApp;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Base.StartBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Learning2 {
	AndroidDriver driver = null;
	
	public Learning2(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void DragDrop() throws MalformedURLException, Exception {
		driver.findElements(AppiumBy.xpath("//android.widget.TextView")).get(12).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Drag and Drop']")).click();
		WebElement sourceElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement targetElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
        Dimension size = driver.manage().window().getSize();
        int startX = sourceElement.getLocation().getX() + sourceElement.getSize().getWidth() / 2;
        int startY = sourceElement.getLocation().getY() + sourceElement.getSize().getHeight() / 2;
        int endX = targetElement.getLocation().getX() + targetElement.getSize().getWidth() / 2;
        int endY = targetElement.getLocation().getY() + targetElement.getSize().getHeight() / 2;

       // Create a TouchAction instance
        TouchAction touchAction = new TouchAction(driver);

        // Perform drag and drop action using press() and moveTo()
        touchAction.longPress(ElementOption.element(sourceElement))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Wait for a second
                   .moveTo(ElementOption.point(833,745)) // Use absolute coordinates
                   .release()
                   .perform(); 
        Thread.sleep(2000);    

	}  
	

	public void Mobile_turn() throws MalformedURLException, Exception {
		driver.rotate(new DeviceRotation(0, 0, 180));
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"Views\").instance(0))")).click();

	/*	driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"TextFields\").instance(0))")).click();
		
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("This is sample text");  */
		
		driver.navigate().back();  
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		KeyEvent overviewKey = new KeyEvent();
        overviewKey.withKey(AndroidKey.APP_SWITCH); 
        driver.pressKey(overviewKey);
        Thread.sleep(2000);
        driver.resetApp();
		
	}
}


