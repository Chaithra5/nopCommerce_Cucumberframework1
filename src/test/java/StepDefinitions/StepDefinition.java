package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseVariable  {

	@Before  ///adding the hook concept ,it will execute only once
	public void setup() throws FileNotFoundException, IOException
	{
		logger=  Logger.getLogger("nopCommerce"); // add logger
		 PropertyConfigurator.configure("log4j.properties");  //add logger
		 pro = new Properties();
		 pro.load(new FileInputStream("config.properties"));
		 if(pro.getProperty("browser").equalsIgnoreCase("chrome"))
		 {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		 }else {
			 WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		 }
		 logger.info("*******lanuch browser*******");
	}
	@Given("Launch browser")
	public void launch_browser() {
		driver.manage().window().maximize();
		l=new LoginPage(driver);
	}

	@When("open url {string}")
	public void open_url(String url) {
		logger.info("*******lanuch URL*******");
		driver.get(url);
	}

	@When("user enter Email as {string} and Password as {string}")
	public void user_enter_Email_as_and_Password_as(String user, String pwd) throws InterruptedException {
		l.enterUser(user);
		l.enterPassword(pwd);
		Thread.sleep(2000);
	}

	@When("click on login")
	public void click_on_login() {
		logger.info("*******click on login*******");
		l.clickOnLogin();
	}

	@Then("Page tittle should be {string}")
	public void page_tittle_should_be(String tittle) {
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("*******login unsuccessful*******");
			driver.close();
			Assert.assertTrue(false);
		}else
		{
			logger.info("*******login successful*******");
			Assert.assertEquals(tittle, driver.getTitle());
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		l.clickOnLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("*******close browser*******");
		driver.close();
	}
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		a= new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", a.getTittle());;
		
	}

	@When("User click on Customer Menu")
	public void user_click_on_Customer_Menu() throws InterruptedException {
		a.clickOncustomermenu();
		Thread.sleep(2000);
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		a.clickOncustomersubMenu();
		Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		a.clickOnaddCustomer();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", a.getTittle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		a.enterEmail(randomstring()+"@gmail.com");
		Thread.sleep(1000);
		a.enterPassword("abc123");
		Thread.sleep(1000);
		a.enterfirstName("sonu");
		Thread.sleep(1000);
		a.enterlastName("g");
		Thread.sleep(1000);
		a.entergender("Female");
		Thread.sleep(1000);
		a.enterDtae("7/05/1997");
		Thread.sleep(1000);
		a.entercompany("XYZ");
		Thread.sleep(1000);
		a.entertaxExempt();
		Thread.sleep(1000);
		a.enterNewletter_TestStore2();
		Thread.sleep(1000);
		a.clickOncustomer_roles("Vendor");
		Thread.sleep(1000);
		a.entermanagevendor();
		Thread.sleep(1000);
		a.addcomment("Hi Hello");
		Thread.sleep(2000);
		
	}

	@When("click on save button")
	public void click_on_save_button() {
		a.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expected) throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	Thread.sleep(3000);
	}

///Seraching customer email
	@When("Enter email address with {string}")
	public void enter_email_address_with(String email) throws InterruptedException {
		sCust= new SearchCustomPage(driver);
		logger.info("*******enter email*******");
		try {
			sCust.enterEmail(email);
		} catch (Exception e) {
		}
		Thread.sleep(2000);
	}

	@When("click on the search button")
	public void click_on_the_search_button() throws InterruptedException {
		sCust.clickOnSearch();
		logger.info("*******search email*******");
		Thread.sleep(2000);
	}

	@Then("User should found the email in the search bar")
	public void user_should_found_the_email_in_the_search_bar() {
		Boolean status=sCust.searchingCustomerEmail();
		Assert.assertEquals(true,status);
	}

//searching customer name
	@When("the firstName and LastName")
	public void the_firstName_and_LastName() throws InterruptedException {
		sCust= new SearchCustomPage(driver);
		logger.info("*******enter name*******");
		sCust.enterFirstName();
		Thread.sleep(1000);
		sCust.enterLastName();
		Thread.sleep(2000);
	}

	@Then("User should found the name in the search bar")
	public void user_should_found_the_name_in_the_search_bar() {
		logger.info("*******search by name*******");
		try {
		boolean status = sCust.searchCustName();
		Assert.assertEquals(true, status);
		}catch(Exception e)
		{
			
		}
		
	}
}