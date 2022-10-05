package steps;

import DriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;

//step definition file for contact us
public class ContactUsSteps {
	
	private ContactUsPage contactPage = new ContactUsPage(DriverFactory.driver());

	@When("user enters {string},{string},{string} and send message")
	public void user_enters_and_send_message(String heading, String order, String msg) {
		contactPage.selectHeading(heading);
		contactPage.selectOrderRef(order);
		contactPage.addMessage(msg);
		contactPage.clickSendBtn();		
	}


	@Then("message should be sent to customer care")
	public void message_should_be_sent_to_customer_care() {
		contactPage.verifyContactMessage();

	}

}
