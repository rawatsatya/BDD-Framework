package stepDefinitions;



import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.SignUpLoginPage;

public class TestCase2 {
	SignUpLoginPage signup_login;
	HomePage hp;
	@Then("Login to your account should be visible")
	public void login_to_your_account_should_be_visible() {
		signup_login = new SignUpLoginPage(BaseClass.getDriver());
		Assert.assertTrue(signup_login.loginToYourAccount());
	}

	@When("User enters correct email address {string} and password {string} and User clicks the login button")
	public void user_enters_correct_email_address_and_password(String email, String password) {
		signup_login.loginAsExistingUser(email, password);
	}

	@Then("Logged in as username {string} should be visible")
	public void logged_in_as_username_username_should_be_visible(String logged_in_username) {
	    hp = new HomePage(BaseClass.getDriver());
	}
}
