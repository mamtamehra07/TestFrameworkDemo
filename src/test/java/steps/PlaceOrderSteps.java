package steps;

import DriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PlaceOrderPage;

//step definition file to place orders
public class PlaceOrderSteps {

	private PlaceOrderPage orderPage = new PlaceOrderPage(DriverFactory.driver());

	@When("user selects first product")
	public void user_selects_first_product() throws InterruptedException {
		orderPage.addOrder();

	}

	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
		orderPage.addProductToCart();
	}

	@When("user pays by bank wire")
	public void user_pays_by_bank_wire() {
		orderPage.addPaymentByBankWire();
	}

	@Then("order of selected product should be completed by bank wire")
	public void order_of_selected_product_should_be_completed_by_bank_wire() {
		orderPage.verifyOrderCompletionByBankWire();
	}

	@When("user selects casual dress product")
	public void user_selects_casual_dress_product() {
		orderPage.selectDressProduct();
	}

	@When("user pays by check")
	public void user_pays_by_check() {
		orderPage.addPaymentByCheck();
	}
	
	@Then("order of selected product should be completed by check")
	public void order_of_selected_product_should_be_completed_by_check() {
		orderPage.verifyOrderCompletionByCheck();
	}

}
