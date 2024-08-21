package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage{
	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "test_cases_list")
	WebElement test_cases_btn;
	
	@FindBy(xpath = "//a[normalize-space()='Test Cases']")
	WebElement test;
	
	public void clickOnTestCases() {
		test_cases_btn.click();
	}
	
	public boolean verifyTestCasePageIsVisible() {
		return test.isDisplayed();
	}
}
