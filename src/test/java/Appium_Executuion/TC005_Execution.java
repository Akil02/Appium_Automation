package Appium_Executuion;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.StartBase;
import DemoApp.FirstPage;
import DemoApp.Learning1;
import DemoApp.Learning2;
import DemoApp.Preferance_page;
import DemoApp.ViewPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC005_Execution {

AndroidDriver driver = null;
	
	@BeforeClass
	public void Start1() throws MalformedURLException {
		driver = new StartBase().Start();
	}
	
	@Test
	public void Execution() throws Exception {
		new FirstPage(driver).Preprence();
		new Preferance_page(driver).Pref_xml();
		new Preferance_page(driver).Intent_Preference();
		Thread.sleep(13000);
		Set<String> contextHandles1 = driver.getContextHandles();
		System.out.println(contextHandles1.size());
		if(contextHandles1.size() == 1) {			
				new Preferance_page(driver).Use_WithoutAccount();
				Thread.sleep(8000);   
		}
		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles.size());
	try {
		for (String contextHandle : contextHandles) {
			if (contextHandle.startsWith("WEBVIEW")) {
		    	driver.context(contextHandle);
		        break;
		    }  
		}
		new Preferance_page(driver).Switch_Android();
		new Preferance_page(driver).Facebook();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	@AfterClass
	public void End() {
		driver.quit();
	}

}
