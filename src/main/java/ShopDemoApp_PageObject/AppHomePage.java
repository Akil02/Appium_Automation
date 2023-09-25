package ShopDemoApp_PageObject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class AppHomePage {

	AndroidDriver driver;
	
	public AppHomePage(AndroidDriver driver) {
		this.driver = driver;
	}
	By openmenu = AppiumBy.xpath("//android.view.ViewGroup[@content-desc = 'open menu']");
	By log_but = AppiumBy.id("android:id/button1");
	By Suc_logout = AppiumBy.xpath("//android.widget.Button[@text = 'OK']");
	
	public void LeftBar() {
		driver.findElement(openmenu).click();
	}
	
	public void Logout() {
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"Log Out\").instance(0))")).click();
	}
	
	public void Logout_But() {
		driver.findElement(log_but).click();
		if(driver.findElement(Suc_logout) != null) {
			driver.findElement(Suc_logout).click();
		}
	}
}
