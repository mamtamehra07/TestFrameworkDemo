package steps;

import DriverFactory.DriverFactory;
import environment.testdata.ConstantUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.ConfigReader;

//step definition file for login page
public class LoginPageSteps {
	
	private static String actualTitle;
	private LoginPage loginPage = new LoginPage(DriverFactory.driver());
	

	@Given("user opens login page")
	public void user_opens_login_page() throws Exception {
		DriverFactory.driver().get(ConfigReader.getURL());
		loginPage.getLoginPage();
	}

	@When("user extracts the title of the page")
	public void user_extracts_the_title_of_the_page() {
		actualTitle = loginPage.getPageTitle();
		System.out.println("Login Page title is: " + actualTitle);
	}

	@Then("page title should be same as login page")
	public void page_title_should_be_same_as_login_page() {
		loginPage.verifyPageTitle(actualTitle,ConstantUtils.LOGINPAGETITLE );
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws Exception {
		String username = ConfigReader.getUserName();
		String password = ConfigReader.getPassword();
		loginPage.enterUserCredentials(username,password);
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}
	
	@Then("page title should be same as home page")
	public void page_title_should_be_same_as_home_page() {
		loginPage.verifyPageTitle(actualTitle,ConstantUtils.HOMEPAGETITLE );
	}

	@Then("user clicks on header logo")
	public void user_clicks_on_header_logo() {
		loginPage.clickHeaderLogo();
	}
	
	@Then("user clicks on contact us")
	public void user_clicks_on_contact_us() {
		loginPage.clickContactUs();
	}

}
