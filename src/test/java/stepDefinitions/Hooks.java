package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;
	
	@Before
    public void setup() throws Exception {
		
		driver = BaseClass.initilizeBrowser();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com/");
    	p=BaseClass.getProperties();			
	}
	
	@After
    public void tearDown(Scenario scenario) {
       driver.quit();  
    }
}
