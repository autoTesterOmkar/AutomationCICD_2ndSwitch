package RSA2_Framework.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA2_Framework.AbstractCompoenents.AbstractCompoenent;

public class CheckoutPage extends AbstractCompoenent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[text()='Checkout']")
	WebElement CheckoutBtn;
	
	@FindBy (xpath="//div[@class='cart']/ul")
	List<WebElement> Products;
	
	
	
	By Locator = By.xpath("//div/ul");
	
	public boolean SearchAddedProduct(String ProdName) {
		 waitForElementToShow(Locator);
		 boolean match=Products.stream().anyMatch(S-> S.findElement(By.xpath("li/div/div/h3")).getText().equalsIgnoreCase(ProdName));
		 return match;
	}
	
	public PaymentPage Checkout() {
		PaymentPage PayP = new PaymentPage(driver);
		CheckoutBtn.click();
		return PayP;
	}

}
