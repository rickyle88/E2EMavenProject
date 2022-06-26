package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	
		prop = new Properties();
//		FileInputStream fis = new FileInputStream("./Academy/E2EProject/data.properties");
		FileInputStream fis = new FileInputStream("./re/data.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) {
			//execute in Chrome driver
			System.setProperty("webdriver.chrome.driver", "./re/chromedriver.exe");
			System.out.println("Chrome driver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
}
