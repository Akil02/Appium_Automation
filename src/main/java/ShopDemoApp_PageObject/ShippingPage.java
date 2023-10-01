package ShopDemoApp_PageObject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ShippingPage {

	AndroidDriver driver;
	public ShippingPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	By name = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]");
	By add1 = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]");
	By cit = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]");
	By sta = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]");
	By code = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]");
	By too = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]");
	By pay = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]");
	
	public void FullName(String name1) {
		driver.findElement(name).sendKeys(name1);
	}
	
	public void FullAddress(String name1) {
		driver.findElement(add1).sendKeys(name1);
	}
	
	public void City(String name1) {
		driver.findElement(cit).sendKeys(name1);
	}
	
	public void State(String name1) {
		driver.findElement(sta).sendKeys(name1);
	}
	
	public void ZipCode(String name1) {
		driver.findElement(code).sendKeys(name1);
	}
	
	public void County(String name1) {
		driver.findElement(too).sendKeys(name1);
	}
	
	public void Payment() {
		driver.findElement(pay).click();
	}
}
