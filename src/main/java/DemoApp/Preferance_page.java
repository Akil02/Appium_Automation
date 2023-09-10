package DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class Preferance_page {

	AndroidDriver driver = null;
	
	public Preferance_page(AndroidDriver driver) {
		this.driver = driver;
	}
  
    public void Intent_Preference() {
    	driver.findElement(By.xpath("//android.widget.TextView[@text = 'Intent preference']")).click();
    }
    
    public void Pref_xml() {
    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = '1. Preferences from XML']")).click();
    }
    
    public void Use_WithoutAccount() {
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'Use without an account']")).click();
    }
    
    public void No_Thanks() {
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'No thanks']")).click();
    }
    
    public void Switch_Android() {
    	driver.findElement(By.xpath("//*[@id = 'switchhub-homepage-hero']//div//div//a")).click();
    }
    
    public void Facebook() {
    	String scrollableSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(3);";

        // Use MobileBy.AndroidUIAutomator to locate the scrollable view and perform the scroll
        MobileBy scrollableElement = (MobileBy) MobileBy.AndroidUIAutomator(scrollableSelector);
        driver.findElement(scrollableElement);
    	driver.findElement(By.xpath("//*[@class = 'social-network']//li[4]//a")).click();
    }
}
