package Academy.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


// inheritance
public class validateTitle extends base{

	@BeforeTest
	public void initialize() throws IOException {
		// Call initializeDriver method
		driver = initializeDriver();
		// Inherit prop property from base class to access data.properties
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void baseNavigation() throws IOException {
				
		// Create object for a LandingPage class and invoke method
		LandingPage lp = new LandingPage(driver);
		
		// Compare the text from browser with actual text
		String title = lp.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES");
		
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
