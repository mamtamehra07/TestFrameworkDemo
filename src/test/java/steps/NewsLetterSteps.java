package steps;

import DriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewsLetterPage;

////step definition file for news letter
public class NewsLetterSteps {
	
	private NewsLetterPage newsLetter = new NewsLetterPage(DriverFactory.driver());
	
	@When("user enters email id on news letter and submit")
	public void user_enters_email_id_on_news_letter_and_submit() {
		newsLetter.addEmailToNewsLetterText();
	}
	@Then("user should get successful message of subscription")
	public void user_should_get_successful_message_of_subscription() {
		newsLetter.verifyNewsLetterSubscription();
	}

}
