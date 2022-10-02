package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();
	
	//method to initiate web drivers
	public WebDriver init_driver(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			localDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			localDriver.set(new FirefoxDriver());
		}
		
		else if(browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			localDriver.set(new SafariDriver());
		}
		
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			localDriver.set(new InternetExplorerDriver());
		}
		
		 else {
				System.out.println("Please pass the correct browser name for configuration: " + browser);
			}		
		driver().manage().deleteAllCookies();
		driver().manage().window().maximize();
		return driver();
	}
	
	public static WebDriver driver() {
		
		return localDriver.get();
		
	}
	
}
