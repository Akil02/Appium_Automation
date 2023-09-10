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

public class Shopp_AppExecution {
	AndroidDriver driver = null;
	
/*	@BeforeClass
	public void Start1() throws MalformedURLException {
		
	}  */
	
	@Test(dataProvider = "provideLogInData") 
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
	public void End() {
		driver.quit();
	}
}
