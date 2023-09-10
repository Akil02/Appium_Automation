package DemoApp;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

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
	
}
