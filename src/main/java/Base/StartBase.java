package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

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
import io.appium.java_client.android.options.UiAutomator2Options;

public class StartBase {

	
	public AndroidDriver Start() throws MalformedURLException {
		String n = "C:\\Users\\A AKIL GANESH\\AppData\\Roaming\\npm\\node_modules\\appium\\bin\\ios-webkit-debug-proxy-launcher.js";
		String name = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\ApiDemos-debug.apk";
		AndroidDriver driver = null;
		try {
            UiAutomator2Options options = new UiAutomator2Options();
            // Set your desired capabilities here, example:
            options.setDeviceName("Akil3");
            options.setApp(name);
            options.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver-win64\\chromedriver.exe");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("Driver initialized successfully!");

        } catch (Exception e) {
            System.out.println("Error while initializing driver: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Root Cause: " + e.getCause().getMessage());
                e.getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }

            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
	    return driver;
		
	}
	
	public AndroidDriver ShoppAppStart() throws MalformedURLException {
		String name = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\General-Store.apk";
		
		AndroidDriver driver = null;
		try {
            UiAutomator2Options options = new UiAutomator2Options();
            // Set your desired capabilities here, example:
            options.setDeviceName("Akil3");
            options.setApp(name);
            options.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver-win64\\chromedriver.exe");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("Driver initialized successfully!");

        } catch (Exception e) {
            System.out.println("Error while initializing driver: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Root Cause: " + e.getCause().getMessage());
                e.getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }

            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
	    return driver;
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
}
