package DemoApp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FirstPage {

	AndroidDriver driver = null;
	public FirstPage(AndroidDriver driver) {
		this.driver = driver;		
	}

	
	public void  Views() {
		driver.findElements(AppiumBy.xpath("//android.widget.TextView")).get(12).click();
	}
	
	public void Preprence() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	}
}
