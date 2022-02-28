package com.salesForce.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.salesForce.loginpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsPOM {
	WebDriver driver;
	LoginPage login;
	String chkEmailText;
	String uname_text;
	@Before(order=0)
	public void setUp1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Given("user open salesforce appliaction")
	public void user_open_salesforce_appliaction() {
	   driver.get("https://login.salesforce.com/");
	}

	@When("user on {string}")
	public void user_on(String page) {
	   if(page.equalsIgnoreCase("loginpage"))
		   login=new LoginPage(driver);
	}

	@When("user enters value into text box username as {string}")
	public void user_enters_value_into_text_box_username_as(String u_name) {
	   login.enterintoUsername(u_name);
	   System.out.println("username entered");
	}

	@When("user enters value into text box password as {string}")
	public void user_enters_value_into_text_box_password_as(String p_word) {
	    login.enterIntoPassword(p_word);
	    System.out.println("password entered");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	   login.clickLoginButton();
	}

	@Then("verify the home page title as {string}")
	public void verify_the_home_page_title_as(String title1) {
	    String title2=driver.getTitle();
	    Assert.assertEquals(title1, title2);
	}
	
	@Then("verify the error {string}")
	public void verify_the_error(String exp_error) {
	   String act_error=login.getUnameError();
	   Assert.assertEquals(exp_error, act_error);
	}
	
	
	
	//Testcase 4A
	@When("click forgot password")
	public void click_forgot_password() {
		 login=new LoginPage(driver);
		login.clickForgotPassword();
		
	}

	@When("Enter username and click continue button")
	public void enter_username_and_click_continue_button() {
		login.enterInUnameForgot("veninitish@gmail.com");
		login.clickContinue();
		chkEmailText=login.get_chk_email_header();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Verify Password reset message is displayed as {string}")
	public void verify_password_reset_message_is_displayed_as(String string) {
		Assert.assertEquals(chkEmailText, "Check Your Email");
	}
	
	
	//Testcase 3
	@When("user clicks check remember me checkbox")
	public void user_clicks_check_remember_me_checkbox() {
		login.clickRememberMe();
		
		
	//	System.out.println(uname_text);
		
	}

	@When("Click on Logout button")
	public void click_on_logout_button() {
		login.clickUserMenu();
		login.clickLogout();
	}

	@Then("Verify username is displayed as {string}")
	public void verify_username_is_displayed_as(String u_name) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname_text=login.getTextOfUsername();
		Assert.assertEquals(uname_text, u_name);
	}
	
	
	/*
	 * @After public void tearDown() { driver.quit(); }
	 */
}
