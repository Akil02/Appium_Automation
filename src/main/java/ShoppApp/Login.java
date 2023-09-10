package ShoppApp;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.StartBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Login {
	AndroidDriver driver = null;
	public Login(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void BasicLogin(int data) throws MalformedURLException, Exception {
		Thread.sleep(5000);
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		List<WebElement> a = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
	/*	    driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
	                + "new UiSelector().textContains(\"Indonesia\").instance(0))"));

		    driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
	                + "new UiSelector().textContains(\"India\").instance(0))")).click(); */
  
		driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"Afghanistan\").instance(0))")).click();
		XSSFSheet sh = new StartBase().excel().getSheetAt(0);
		Row r = sh.getRow(data);
		String name = r.getCell(0).getStringCellValue();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys(name);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();  
		Thread.sleep(3000);
	}
	
	
	public void Adding_item(int data) throws Exception {
		XSSFSheet sh1 = new StartBase().excel().getSheetAt(0);
		Row r1 = sh1.getRow(data);
		int itemcount = (int) r1.getCell(1).getNumericCellValue();
		HashMap<Integer,String> map = new HashMap<Integer,String>();
	//	map.put(1,"Air Jordan 4 Retro");// map.put(2,"Converse All Star"); map.put(3,"Nike SFB Jungle");
		for(int i = 1;i<=itemcount;i++) {
			int v1 = i+1;
			String val = r1.getCell(v1).getStringCellValue();
			map.put(i, val);
		}
		
		int num = 1;
		while(map.size() != 0) {
			String t = map.get(num);
			driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
	                + "new UiSelector().textContains(\""+t+"\").instance(0))"));
			driver.findElements(AppiumBy.xpath("//*[@text = '"+t+"']/following-sibling::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"))
			.get(1).click();
			map.remove(num);
			++num;
		}
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(ElementOption.element(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"))))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Wait for a second
        .moveTo(ElementOption.point(833,745)) // Use absolute coordinates
        .release()
        .perform();
        Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text = 'CLOSE']")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.CheckBox")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(9000);
	}
	
	public void google_Search() throws InterruptedException {
		Set<String> contextHandles = driver.getContextHandles();
		for (String contextHandle : contextHandles) {
		    if (contextHandle.startsWith("WEBVIEW")) {
		    	driver.context(contextHandle);
		        break;
		    }
		}
		driver.findElement(By.name("q")).sendKeys("Dhoni");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@role = 'listbox']//li[1]//span")).click();
		driver.context("NATIVE_APP");
		
	}
}
