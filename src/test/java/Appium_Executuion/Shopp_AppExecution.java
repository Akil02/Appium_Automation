package Appium_Executuion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.StartBase;
import DemoApp.FirstPage;
import DemoApp.ViewPage;
import ShoppApp.Login;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Shopp_AppExecution {
	AndroidDriver driver = null;
	
/*	@BeforeClass
	public void Start1() throws MalformedURLException {
		
	}  */
	
	@Test(dataProvider = "provideLogInData") 
	@Description("Launching the App and purchase the order for the customer")
	@Epic("Shopp_APP_TestCase")
	@Feature("Starting the App and Purchase the item from App")
	@Story("Checking whether the customer is able to purchase his item")
	@Step("Open APP Demo app and order the item")
	public void Shop_Start(int value) throws Exception {
		driver = new StartBase().ShoppAppStart();
		new Login(driver).BasicLogin(value);
		new Login(driver).Adding_item(value);
		new Login(driver).google_Search();
	}
	
	@DataProvider (name = "provideLogInData")
	public Object []logInData () throws IOException
	{
		File file =    new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Appium_excel.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sh = wb.getSheetAt(0);
		int row = sh.getLastRowNum();	
	    Object []data = new Object[row];	
	    for(int i = 0;i<row;i++) {
	    	data[i] = i+1;
	    }
	    return data;
	}
		
	@AfterClass
	@Description("Closing the the App after execution")
	@Epic("Shopp_APP_TestCase")
	@Feature("Closing the App")
	@Story("Checking whether App is getting closed")
	@Step("Close APP Demo app")
	public void End() {
		driver.quit();
	}
}
