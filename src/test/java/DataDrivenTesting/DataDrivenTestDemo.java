package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelUtility;

public class DataDrivenTestDemo {

	WebDriver driver;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:/Chromedriver for 105/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd, String exp) {

		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement username = driver.findElement(By.id("Email"));
		username.clear();
		username.sendKeys(user);
		
		WebElement password = driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type = 'submit']"));
		loginBtn.click();
		
		String expTitle = "Dashboard / nopCommerce administration";
		String actualTitle = driver.getTitle();
		
		if(exp.equals("Valid")) {
			if(expTitle.equals(actualTitle)) {
			 Assert.assertTrue(true);	
			}
			else
				Assert.assertTrue(false);
			
		}
		else if (exp.equals("Invalid")) {
			if(expTitle.equals(actualTitle)) {
				 Assert.assertTrue(false);	
				}
				else
					Assert.assertTrue(true);
		}
		
		
//		System.out.println(user +pwd +exp);
	}

	@DataProvider (name = "LoginData")
	public String[][] getTestData() throws IOException {

		/*
		 * String[][] loginData = { {"admin@yourstore.com","admin","Valid"},
		 * {"admin@yourstore.com","admn","Invalid"},
		 * {"adn@yourstore.com","adm","Invalid"}
		 * 
		 * };
		 */
		
		String path = ".\\src\\test\\resources\\testData\\LoginTestData.xlsx";
		ExcelUtility xutil = new ExcelUtility(path);
		
		int rows = xutil.getRowCount("Sheet1");
		int cols = xutil.getCellCount("Sheet1", 1);
		
		String loginData [][]= new String[rows][cols];
		
		for (int i=1;i<=rows;i++){
			
			for(int j=0;j<cols ; j++) {
				
				
				loginData[i-1][j] = xutil.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
