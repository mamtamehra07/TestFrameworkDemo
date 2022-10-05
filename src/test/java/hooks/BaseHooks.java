package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class BaseHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties properties;

	//launch browser
	@Before(order = 0)
	public void launchBrowser() throws Exception {
		String browserName = ConfigReader.getBrowser();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}

	//close browser
	@After(order = 0)
	public void closeBrowser() {
		driver.close();
	}

	//take screenshots
	@After(order = 1)
	public void takeScreenshot(Scenario sc) {
		if (sc.isFailed()) {
			String screenshotName = sc.getName().replaceAll(" ", "_");
			TakesScreenshot shot=(TakesScreenshot)driver;
            byte[] srcFile = shot.getScreenshotAs(OutputType.BYTES);
			sc.attach(srcFile, "image/png", " Screenshot" + "/" +  screenshotName);
		}
		
	}

}
