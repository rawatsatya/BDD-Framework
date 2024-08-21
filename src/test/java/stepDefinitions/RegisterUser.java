package stepDefinitions;


import java.util.HashMap;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountCreatedPages;
import pageobjects.HomePage;
import pageobjects.NewUserSignUp;
import pageobjects.SignUpLoginPage;
import utilities.DataReader;

public class RegisterUser {
	WebDriver driver;
	HomePage hp;
	SignUpLoginPage signup_login;
	NewUserSignUp new_user_signup;
	HashMap<String, String> new_user_data;
	AccountCreatedPages acc_creted_pages;
	Properties p;
	
	@Given("I launch the browser")
	public void i_launch_the_browser(){
		System.out.println("Browser has already launched ");
	}

	@When("I navigate to {string}")
	public void i_navigate_to(String string) {
    	System.out.println("Browser has been maximized");
	}

	@Then("I should see the home page")
	public void i_should_see_the_home_page() {
	    hp = new HomePage(BaseClass.getDriver());
	    Assert.assertTrue(hp.automationTestingLogoVisisible());
	}

	@When("I click on the Signup & Login button")
	public void i_click_on_the_button() {
		hp.clickSignupLoginBtn();   
	}

	@Then("I should see New User Signup!")
	public void i_should_see() {
		signup_login = new SignUpLoginPage(BaseClass.getDriver());
		signup_login.verifyNewUserSignup();
	}
	
	@When("I enter name and email address and I click the Signup button")
	public void i_enter_name_and_email_address() throws Exception  {
//		signup_login.signUp("rawatsatya301998@gmail.com", "Satyam@30");
		new_user_data = DataReader.mydata("C:\\Users\\Rawat\\eclipse-workspace\\Online-Shopping-Cucumber\\test-data\\signup-data.xlsx", "Sheet1");
		signup_login.signUp(new_user_data.get("name"), new_user_data.get("email"));
	}

	

	@Then("I should see ENTER ACCOUNT INFORMATION")
	public void i_should_see_enter_account_information() {
		new_user_signup = new NewUserSignUp(BaseClass.getDriver());
//		Assert.assertEquals(new_user_signup.validateEnterAccountInformation(), "ENTER ACCOUNT INFORMATION");
	}

	@When("I fill in the following details:")
	public void i_fill_in_the_following_details() {
		new_user_signup.password(new_user_data.get("password"));
		new_user_signup.fillDertails(new_user_data.get("first_name"), new_user_data.get("last_name"), new_user_data.get("company"), new_user_data.get("address_1"), new_user_data.get("address_2"), new_user_data.get("country"), new_user_data.get("state"), new_user_data.get("city"), new_user_data.get("zipcode"), new_user_data.get("mobile_number"));
	}

	@When("I select the checkbox Sign up for our newsletter!")
	public void i_select_the_checkbox_sign_up_for_our_newsletter() {
	    new_user_signup.selectBothCheckBox();
	}

	@When("I select the checkbox Receive special offers from our partners!")
	public void i_select_the_checkbox_receive_special_offers_from_our_partners() {
	    System.out.println("Checkbox Selected");
	}

	@When("I click the Create Account button")
	public void i_click_the_create_account_button() {
	    System.out.println("button has been clicked in above method");
	}

	@Then("I should see ACCOUNT CREATED!")
	public void i_should_see_account_created() {
		new_user_signup.verifyAccountCreatedTextVisisible();
	}

	@When("I click the Continue button")
	public void i_click_the_continue_button() {
		acc_creted_pages = new AccountCreatedPages(BaseClass.getDriver());
		acc_creted_pages.clickContinue();
	}

	@Then("I should see Logged in as username")
	public void i_should_see_logged_in_as_username() {
	    Assert.assertEquals(hp.loggedInUsername(), "Aman");
	}

	@When("I click the Delete Account button")
	public void i_click_the_button() {
	    System.out.println("call on next method");
	}

	@Then("I should see ACCOUNT DELETED!")
	public void i_should_see_account_deleted() {
	    Assert.assertEquals(hp.cilckOnDelete(),"ACCOUNT DELETED!");
	}

	

}
