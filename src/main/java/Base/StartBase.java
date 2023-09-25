package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartBase {

	AndroidDriver driver;
	public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
	
	public AndroidDriver Start() throws MalformedURLException {
		String n = "C:\\Users\\A AKIL GANESH\\AppData\\Roaming\\npm\\node_modules\\appium\\bin\\ios-webkit-debug-proxy-launcher.js";
		String name = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\ApiDemos-debug.apk";
		System.out.println(name);
	/*	AppiumDriverLocalService apserver = new AppiumServiceBuilder().withAppiumJS(new File(n))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
		apserver.start();  */
		DesiredCapabilities cap = new DesiredCapabilities();
	//	cap.setCapability("orientation", "LANDSCAPE");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Akil3");
		cap.setCapability(MobileCapabilityType.APP,name);
		cap.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	//	apserver.stop();
		tdriver.set(driver);
		return getDriver();
		
	}
	
	public AndroidDriver ShoppAppStart() throws MalformedURLException {
		String name = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\General-Store.apk";
		DesiredCapabilities cap = new DesiredCapabilities();
	//	cap.setCapability("orientation", "LANDSCAPE");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Akil3");
		cap.setCapability(MobileCapabilityType.APP,name);
		cap.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		tdriver.set(driver);
		return getDriver();
	}
	
	public AndroidDriver setup() throws MalformedURLException {
		System.out.println("Before");
		String appLoc = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk";
		DesiredCapabilities cap1 = new DesiredCapabilities();
		cap1.setCapability(MobileCapabilityType.DEVICE_NAME,"Akil3");
		cap1.setCapability(MobileCapabilityType.APP,appLoc);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap1);
		new StartBase().tdriver.set(driver);
		return new StartBase().getDriver();
	}
	
	public void teardown() {
		System.out.println("After");
		driver.quit();
	}
	public static synchronized AndroidDriver getDriver() {
		return tdriver.get();
	}
	
	public void takeScreenshot(String screenShotName,AndroidDriver driver1) {

	    File file  = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(file, new File(screenShotName + ".jpg"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public XSSFWorkbook excel(){
		XSSFWorkbook workbook = null;
		try {
		  FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Appium_excel.xlsx");
		  workbook = new XSSFWorkbook(fs);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return workbook;
}
	
	public Properties Prop() throws IOException {
		Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");									
	    obj.load(objfile);
	    return obj;
	}
	
}
