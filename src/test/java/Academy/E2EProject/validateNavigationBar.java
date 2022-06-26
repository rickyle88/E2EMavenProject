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
public class validateNavigationBar extends base {

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

		String[] nvaOptions_expected = { "HOME", "COURSES", "VIDEOS", "INTERVIEW GUIDE", "PRACTICE", "BLOG", "ABOUT",
				"CONTACT" };

		System.out.print(lp.getNavigationBar().size());
		for (int i = 0; i < lp.getNavigationBar().size(); i++) {
			String navItem = lp.getNavigationBar().get(i).getText().trim();
			if (nvaOptions_expected[i].equals(navItem)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		// Compare the text from browser with actual text
//		String title = lp.getTitle().getText();
//		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
//		List<WebElement> navOptions = lp.rightNavBar();
//
//		String[] navOptions_Expected = { "HOME", "COURSES", "VIDEOS", "INTERVIEW GUIDE", "PRACTICE", "BLOG", "ABOUT",
//
//		"CONTACT" };
//
//		List values = Arrays.asList(navOptions_Expected);
//
//		for (int i = 0; i < navOptions.size(); i++) {
//
//		String elementName = navOptions.get(i).getText().trim();
//
//		if (values.contains(elementName)) {
//
//		Assert.assertTrue(true);
//
//		} else {
//
//		Assert.assertTrue(false, elementName + " is should not be displayed in the right Nav");

//		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
