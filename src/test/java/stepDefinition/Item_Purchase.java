package stepDefinition;

import java.io.IOException;

import org.junit.runner.RunWith;

import Base.StartBase;
import ShopDemoApp_PageObject.AppHomePage;
import ShopDemoApp_PageObject.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Item_Purchase {
	AndroidDriver driver;
	
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
		System.out.println("Startted 1");
	    new AppHomePage(driver).LeftBar();
	    new AppHomePage(driver).Logout();  
	    new AppHomePage(driver).Logout_But();
	}

	@When("^User enters the log in page use the credentials and log in$")
	public void user_enters_the_log_in_page_use_the_credentials_and_log_in() throws Throwable {
	    
		new LoginPage(driver).Username();
		new LoginPage(driver).Password();
	}

	@When("^After entering log in page skip all the shipping and try to go to purchase page$")
	public void after_entering_log_in_page_skip_all_the_shipping_and_try_to_go_to_purchase_page() throws Throwable {
	    
		System.out.println("3");
	}

	@When("^the user is on the purchase page select Sauce Labs Fleece Jacket and Test\\.allTheThings\\(\\) T-Shirt and click on buy button$")
	public void the_user_is_on_the_purchase_page_select_Sauce_Labs_Fleece_Jacket_and_Test_allTheThings_T_Shirt_and_click_on_buy_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("4");
	}

	@When("^User needs to enter his shipping details and click on Payment button$")
	public void user_needs_to_enter_his_shipping_details_and_click_on_Payment_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("5");
	}

	@When("^Users enters the Payment page enter the card details Rebecca Winter (\\d+) (\\d+) (\\d+) (\\d+) (\\d+)/(\\d+) (\\d+)and when the user enters the next page$")
	public void users_enters_the_Payment_page_enter_the_card_details_Rebecca_Winter_and_when_the_user_enters_the_next_page(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("6");
	}

	@Then("^take the screenshot of that page$")
	public void take_the_screenshot_of_that_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("7");
	}

	@When("^the user is on the purchase page select the items and click on buy button$")
	public void the_user_is_on_the_purchase_page_select_the_items_and_click_on_buy_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("8");
	}

	@When("^Users enters the Payment page enter the card details and when the user enters the next page$")
	public void users_enters_the_Payment_page_enter_the_card_details_and_when_the_user_enters_the_next_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("9");
	}
}
