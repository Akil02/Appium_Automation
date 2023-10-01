package ShopDemoApp_PageObject;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PaymentMethodPage {
    AndroidDriver driver;
	public PaymentMethodPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	By Fname = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]");
    By Cnum = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]");
    By ExpDate = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]");
    By Seccode = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]");
    By Revorder = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]/android.widget.TextView");
    
    public void Name(String n) {
    	driver.findElement(Fname).sendKeys(n);
    }
    
    public void CardNum(String n) {
    	driver.findElement(Cnum).sendKeys(n);
    }
    
    public void ExpireDate(String n) {
    	driver.findElement(ExpDate).sendKeys(n);
    }
    
    public void Security_Code(String n) {
    	driver.findElement(Seccode).sendKeys(n);
    }
    
    public void Review() {
    	driver.findElement(Revorder).click();
    }
}
