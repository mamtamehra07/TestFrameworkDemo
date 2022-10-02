package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {

	private WebDriver driver;

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By signInLink = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	private By headerLogo = By.xpath("//*[@id=\"header_logo\"]/a/img");
	private By contactUsLink = By.xpath("//*[@id=\"contact-link\"]/a");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void verifyPageTitle(String actual, String expected) {
		Assert.assertEquals(actual,expected);
	}
	
	public void clickHeaderLogo() {
		driver.findElement(headerLogo).click();
	}
	
	public void clickContactUs() {
		driver.findElement(contactUsLink).click();
	}
	
	public void getLoginPage() {
		driver.findElement(signInLink).click();
	}

	public void enterUserCredentials(String username, String pwd) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		driver.findElement(signInButton).click();
	}

}
