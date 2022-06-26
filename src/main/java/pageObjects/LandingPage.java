package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_i']");
	By title = By.cssSelector("#content h2");
	By NavBar = By.cssSelector("ul.nav.navbar-nav.navbar-right li a");
	
	

	public LandingPage(WebDriver driver) {
//		super();
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		scrollTo(driver.findElement(title));
		return driver.findElement(title);
	}
	
	public List<WebElement> getNavigationBar() {
//		return driver.findElements(NavBar);
		return driver.findElements(NavBar);
	}
	
	public void scrollTo(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("arguments[0].scrollIntoView();", e);
	}
}
