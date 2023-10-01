package ShopDemoApp_PageObject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
	}
	By user = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]");
	By pass = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]");
	By log = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]");
	
	public void Username() {
		String user1 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]//following-sibling::android.view.ViewGroup[1]//android.widget.TextView")).getText();
		driver.findElement(user).sendKeys(user1);
	}
	
	public void Password() {
		String pass1 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]//following-sibling::android.widget.TextView[3]")).getText();
		driver.findElement(pass).sendKeys(pass1);
	}
	
	public void Login() {
		driver.findElement(log).click();
	}
}
