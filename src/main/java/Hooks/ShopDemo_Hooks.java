package Hooks;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import Base.StartBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ShopDemo_Hooks {

	AndroidDriver driver;
/*	@Before
	public AndroidDriver setup() throws MalformedURLException {
		System.out.println("Before");
		String appLoc = System.getProperty("user.dir")+"src\\main\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk";
		DesiredCapabilities cap1 = new DesiredCapabilities();
		cap1.setCapability(MobileCapabilityType.DEVICE_NAME,"Akil3");
		cap1.setCapability(MobileCapabilityType.APP,appLoc);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap1);
		new StartBase().tdriver.set(driver);
		return new StartBase().getDriver();
	}
	
	@After
	public void teardown() {
		System.out.println("After");
		driver.quit();
	}     */
}
