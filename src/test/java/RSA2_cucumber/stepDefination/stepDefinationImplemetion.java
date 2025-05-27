package RSA2_cucumber.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RSA2_Framework.TestCompoenent.BaseTest;
import RSA2_Framework.pageobjects.CheckoutPage;
import RSA2_Framework.pageobjects.LoginPage;
import RSA2_Framework.pageobjects.PaymentPage;
import RSA2_Framework.pageobjects.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImplemetion extends BaseTest {
	
	public LoginPage LP;
	public ProductPage PP;
	public CheckoutPage CP;
	public PaymentPage PayP;
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		launchapplication();
	}
	
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_password(String username , String password) {
		PP=LP.Login(username, password);
	}
	
	@When ("^When I added product (.+) to cart $")
	public void When_Add_Product_toCart(String productName){
		List<WebElement> list = PP.getList();
		CheckoutPage CP = PP.AddtoCart(productName);
		CP.CartButton();
	}
	
	@And ("^Checkout (.+) and submit the order$")
	public void Checkout_product_and_submitorder(String productName) {
		boolean match=CP.SearchAddedProduct(productName);
		Assert.assertEquals(productName, match);
		PayP = CP.Checkout();
		
	}
	
	@Then  ("message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage() {
		PayP.AddCountryInfo();
		PayP.OtherPayInfo();
		String OrderNo = PayP.OrderIDInfo();
		System.out.println(OrderNo);
	}

}
