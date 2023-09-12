package DemoApp;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ViewPage {

	AndroidDriver driver = null;
	public ViewPage(AndroidDriver driver) {
		this.driver = driver;
	}

	
	
	public void WebView3() {
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"WebView3\").instance(0))")).click();
	}
	
	public void UIVisibility() {
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"System UI Visibility\").instance(0))")).click();
	}
	
	public void VidioPlayer() {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Video Player']")).click();
	}
	
	public void Vidio_play() {
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/play")).click();
	}
	
	public void vidio_skip(double time) {
		WebElement seekBar = driver.findElement(AppiumBy.id("io.appium.android.apis:id/seekbar"));
		int startX = seekBar.getLocation().getX();
        int startY = seekBar.getLocation().getY();
        int seekBarWidth = seekBar.getSize().getWidth();
        int endX = startX + (int) (seekBarWidth * time); // In this example, we're dragging it 80% to the right

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(seekBar))
                .withDuration(Duration.ofMillis(1000))) // Adjust the duration as needed
                .release()
                .perform();
	}
	
	public void vidio_playbutton() {
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'Play']")).click();
	}
	
	public void vidio_pausebutton() {
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'Pause']")).click();
	}
}
