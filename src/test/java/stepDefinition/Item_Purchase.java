package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.StartBase;
import ShopDemoApp_PageObject.AppHomePage;
import ShopDemoApp_PageObject.LoginPage;
import ShopDemoApp_PageObject.PaymentMethodPage;
import ShopDemoApp_PageObject.ShippingPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Item_Purchase {
	AndroidDriver driver;
	KeyEvent overviewKey = new KeyEvent();
	
	@Before
	public void stey() throws IOException {
		System.out.println("Start");
		driver = new StartBase().setup();
	}
	
	@After
	public void DFs() {
		System.out.println("End");
	//	driver.quit();
	}
	
	@Given("^The user is in home page log out and go to the login page$")
	public void the_user_is_in_home_page_log_out_and_go_to_the_login_page() throws Throwable {
	    new AppHomePage(driver).LeftBar();
	    new AppHomePage(driver).Logout();  
	    new AppHomePage(driver).Logout_But();  
	}

	@When("^User enters the log in page use the credentials and log in$")
	public void user_enters_the_log_in_page_use_the_credentials_and_log_in() throws Throwable {
	    
		new LoginPage(driver).Username();
		new LoginPage(driver).Password();
		new LoginPage(driver).Login();  
	}

	@When("^After entering log in page skip all the shipping and try to go to purchase page$")
	public void after_entering_log_in_page_skip_all_the_shipping_and_try_to_go_to_purchase_page() throws Throwable {
	  if(driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")) != null) {  
		 overviewKey.withKey(AndroidKey.BACK); 
	     driver.pressKey(overviewKey);
	     Thread.sleep(3000);
	 //    System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.ScrollView[@content-desc = 'cart screen']//android.view.ViewGroup[1]//android.view.ViewGroup[2]")).getText());
	     WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Go Shopping button']"));
	     element.click();  
	  }  
	}



	@When("^User needs to enter his shipping details and click on Payment button$")
	public void user_needs_to_enter_his_shipping_details_and_click_on_Payment_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ShippingPage pag = new ShippingPage(driver);
		Thread.sleep(2000);
		System.err.println("Conformation : "+new StartBase().Prop().getProperty("Fullname"));
		pag.FullName(new StartBase().Prop().getProperty("Fullname"));
		pag.FullAddress(new StartBase().Prop().getProperty("Addres"));
		pag.City(new StartBase().Prop().getProperty("City"));
		pag.State(new StartBase().Prop().getProperty("State"));
		pag.ZipCode(new StartBase().Prop().getProperty("Zip"));
		pag.County(new StartBase().Prop().getProperty("Country"));
		pag.Payment();
	}


    @When("^Users enters the Payment page enter the card details (.*) (.*) (.*) (.*) and when the user enters the next page$")
     public void users_enters_the_payment_page_enter_the_card_details_rebecca_winter_123and_when_the_user_enters_the_next_page(String int1, String int2, String int3,String int4) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("payment ");
    	PaymentMethodPage payment = new PaymentMethodPage(driver);
		Thread.sleep(2000);
		payment.Name(int1);
		payment.CardNum(int2);
		payment.ExpireDate(int3);
		payment.Security_Code(int4);
		payment.Review();
	}

	@Then("^take the screenshot of that page$")
	public void take_the_screenshot_of_that_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new StartBase().ScreenShot(driver, "FinalImage");
		
	}


	@When("^Users enters the Payment page enter the card details and when the user enters the next page$")
	public void users_enters_the_Payment_page_enter_the_card_details_and_when_the_user_enters_the_next_page() throws Throwable {
		System.out.println("Inside new ");
	    // Write code here that turns the phrase above into concrete actions
		XSSFWorkbook book = new StartBase().excel();
		XSSFSheet sheet = book.getSheetAt(2);
		String int1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String int02 = sheet.getRow(1).getCell(1).getStringCellValue(); 
		String int2 = int02.substring(0,int02.length()-1);
		System.out.println(int2);
		String int03 = sheet.getRow(1).getCell(2).getStringCellValue();
		String int3 = int03.substring(1,int03.length());
		int int04 = (int) sheet.getRow(1).getCell(3).getNumericCellValue();
		String int4 = ""+int04;
		PaymentMethodPage payment = new PaymentMethodPage(driver);
		Thread.sleep(2000);
		payment.Name(int1);
		payment.CardNum(int2);
		payment.ExpireDate(int3);
		payment.Security_Code(int4);
		payment.Review();
	}
	
	@When("^the user is on the purchase page select (.*) and (.*) and click on buy button$")
	public void the_user_is_on_the_purchase_page_select_sauce_labs_fleece_jacket_and_test_all_the_things_t_shirt_and_click_on_buy_button(String item1,String item2) throws InterruptedException {
		System.out.println(item1 + "  "+item2);
	    // Write code here that turns the phrase above into concrete actions
	     new StartBase().ScrollText(item1,driver);
	     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Add To Cart']")).click();
	     overviewKey.withKey(AndroidKey.BACK); 
	     driver.pressKey(overviewKey);
	     new StartBase().ScrollText(item2,driver);
	     driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc = 'counter plus button']//android.widget.ImageView[1]")).click();
	     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Add To Cart']")).click();
	     Thread.sleep(1000);
	     driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc = 'cart badge']//android.widget.ImageView[1]")).click();
	     Thread.sleep(2000);
	     driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click();
	}
	
	@When("the user is on the purchase page select the items and click on buy button")
	public void the_user_is_on_the_purchase_page_select_the_items_and_click_on_buy_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Excel");
		XSSFWorkbook book = new StartBase().excel();
		XSSFSheet sheet = book.getSheetAt(1);
		int l = sheet.getLastRowNum();
		System.out.println("Row count "+l);
		for(int i = 1;i<=l;i++) {
			String name = sheet.getRow(i).getCell(0).getStringCellValue();
			new StartBase().ScrollText(name,driver);
		     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Add To Cart']")).click();
		     overviewKey.withKey(AndroidKey.BACK); 
		     driver.pressKey(overviewKey);
		}
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc = 'cart badge']//android.widget.ImageView[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click();
	    System.out.println("Out");
	}

}
