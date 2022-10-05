package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import environment.testdata.ConstantUtils;

public class ContactUsPage {
	
	private WebDriver driver;
	private static String contactUsMessage;
	
	private By subjectHeading = By.id("id_contact");
	private By orderReference = By.name("id_order");
	private By message = By.id("message");
	private By sendBtn = By.xpath("//*[@id=\"submitMessage\"]/span");
	private By contactMessage = By.xpath("//*[@id=\"center_column\"]/p");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//select class example - for dropdown
	public void selectHeading(String subject) {
		Select heading = new Select(driver.findElement(subjectHeading));
		heading.selectByVisibleText(subject);
	}
	
	public void selectOrderRef(String orderref) {
			Select order = new Select(driver.findElement(orderReference));
			order.selectByValue(orderref);		
	}
	
	public void addMessage(String msg) {
			driver.findElement(message).sendKeys(msg);	
	}
	
	public void clickSendBtn() {
		driver.findElement(sendBtn).click();	
	}
	
	//Assertion
	public void verifyContactMessage() {
		contactUsMessage = driver.findElement(contactMessage).getText().trim();
		Assert.assertEquals(contactUsMessage, ConstantUtils.CONTACTUSMESSAGE, "Not Matched");
	}
		
		
}

