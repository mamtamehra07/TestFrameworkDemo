package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import environment.testdata.ConstantUtils;

public class PlaceOrderPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private static String confirmationMessage;
	private By productID = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");	
	private By addCartBtn = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span");	
	private By proceedCheckOutLink = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	private By proceedCheckOutBtn = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
	private By proceedCheckOutBtn2 = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
	private By agreeCheckbox = By.xpath("//*[@id=\"uniform-cgv\"]");
	private By proceed = By.xpath("//*[@id=\"form\"]/p/button/span");
	private By payBankWireBtn = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
	private By payByCheckBtn = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
	private By confirmOrderBtn = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
	private By orderText = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
	private By selectProductBanner = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	private By dressLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a");
	private By dressProductID = By.xpath("//img[@title='Printed Dress']");
	private By addToCart = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");
	private By orderAlert = By.xpath("//*[@id=\"center_column\"]/p[1]");
	

	
	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addOrder() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(productID)).perform();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCartBtn)).click();		
	}
	
	//Explicit wait example
	public void addProductToCart() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckOutLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckOutBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckOutBtn2)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeCheckbox)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceed)).click();		
	}
	
	public void addPaymentByBankWire() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(payBankWireBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderBtn)).click();
	}
	
	public void addPaymentByCheck() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(payByCheckBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderBtn)).click();
	}
	
	
	public void verifyOrderCompletionByBankWire() {
		confirmationMessage = driver.findElement(orderText).getText();
		Assert.assertEquals(confirmationMessage, ConstantUtils.ORDERCONFIRMATIONMESSAGE, "Order Message is not same");
	}
	
	public void verifyOrderCompletionByCheck() {
		confirmationMessage = driver.findElement(orderAlert).getText();
		Assert.assertEquals(confirmationMessage, ConstantUtils.ORDERCONFIRMATIONMESSAGE, "Order Message is not same");
	}
	
	//Actions example for mouse events
	public void selectDressProduct() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(selectProductBanner)).perform();
		driver.findElement(dressLink).click();
		action.moveToElement(driver.findElement(dressProductID)).perform();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();	
	}

}
