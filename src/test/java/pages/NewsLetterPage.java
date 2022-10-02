package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import environment.testdata.ConstantUtils;
import io.netty.util.internal.ThreadLocalRandom;

public class NewsLetterPage {
	

	private WebDriver driver;
	private static String subscriptionMessage;
	
	private By newsLetterText = By.id("newsletter-input");
	private By submitNewsLetter = By.name("submitNewsletter");
	private By newsLetterAlert = By.xpath("//*[@id=\"columns\"]/p");
	
	
	
	public NewsLetterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String emailID() {
		int random_num = ThreadLocalRandom.current().nextInt();
		String emailIDText = Integer.toString(random_num).concat("@gmail.com");
		return emailIDText;
	}
	
	public void addEmailToNewsLetterText() {
		driver.findElement(newsLetterText).sendKeys(emailID());
		driver.findElement(submitNewsLetter).click();
	}
	
	public void verifyNewsLetterSubscription() {
		subscriptionMessage = driver.findElement(newsLetterAlert).getText();
		Assert.assertEquals(subscriptionMessage, ConstantUtils.NEWSLETTERTEXT, "News Letter Text Not Matched");
	}

}
