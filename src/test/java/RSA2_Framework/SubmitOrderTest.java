package RSA2_Framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RSA2_Framework.TestCompoenent.BaseTest;
import RSA2_Framework.pageobjects.CheckoutPage;
import RSA2_Framework.pageobjects.LoginPage;
import RSA2_Framework.pageobjects.OrderHistoryPage;
import RSA2_Framework.pageobjects.PaymentPage;
import RSA2_Framework.pageobjects.ProductPage;

public class SubmitOrderTest extends BaseTest {
	
	String productName="ZARA COAT 3";
	

	@Test (dataProvider = "getData" , groups = {"Purchase"})
	public void SubmitOrder(HashMap <String, String> input) throws InterruptedException, IOException {
		
		
		
		LoginPage LP = new LoginPage(driver);
		ProductPage PP = LP.Login(input.get("email"), input.get("password"));
		
		
		List<WebElement> list = PP.getList();
		CheckoutPage CP = PP.AddtoCart(input.get("productName"));	
		Thread.sleep(5000);
		CP.CartButton();
		
		 
		boolean match=CP.SearchAddedProduct(input.get("productName"));
		Assert.assertTrue(match);
		
		PaymentPage PayP = CP.Checkout();
		
		PayP.AddCountryInfo();
		PayP.OtherPayInfo();
		String OrderNo = PayP.OrderIDInfo();
		System.out.println(OrderNo);
		
	}
	
	/*
	@Test (dependsOnMethods = {"SubmitOrder"})
	public void OrderHistory() {
		
		LoginPage LP = new LoginPage(driver);
		
		LP.Login("opawar449@gmail.com", "Omkar@1234");
		OrderHistoryPage OHP = new OrderHistoryPage(driver);
		OHP.OrderButton();
		OHP.VerifyOrderHistory(productName);
		
	} */
	
	
	//DataProvider using HashMap
	
	@DataProvider 
	public Object[][] getData() throws IOException{
		
		/*HashMap<String, String> map = new HashMap <String, String>();
		map.put("email" , "opawar449@gmail.com");
		map.put("pswd", "Omkar@1234");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "anshika@gmail.com");
		map2.put("pswd", "Iamking@000");
		map2.put("productName", "ADIDAS ORIGINAL");*/
		
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\RSA2_Framework\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)} };
		
		
	}
	
	
	/*@DataProvider      one way of using DataProvider
	public Object[][] getData() {
		return new Object [][]  {{"opawar449@gmail.com", "Omkar@1234" , "ZARA COAT 3"} , {"anshika@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
	}*/

}
