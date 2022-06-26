package Academy.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


// inheritance
public class HomePage extends base{
	
	@BeforeMethod
	public void initialize() throws IOException {
		// Call initializeDriver method
		driver = initializeDriver();
		// Inherit prop property from base class to access data.properties
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void baseNavigation(String userName, String password, String text) throws IOException {
				
		// Create object for a LandingPage class and invoke method
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		// Create object for a LoginPage class and invoke method
		LoginPage lgp = new LoginPage(driver);
		lgp.getEmail().sendKeys(userName);
		lgp.getPassword().sendKeys(password);
		lgp.getLogin().click();
	
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3]; // 1 row, 2 column => size=2, size = 2
		//0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted user";
		//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "NonRestricted user";
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
