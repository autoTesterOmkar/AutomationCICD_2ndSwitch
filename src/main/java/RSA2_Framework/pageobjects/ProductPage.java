package RSA2_Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA2_Framework.AbstractCompoenents.AbstractCompoenent;

public class ProductPage extends AbstractCompoenent {
	
	WebDriver driver;
	
	public ProductPage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//div[@class='card']")
	List<WebElement> Products;
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	
	@FindBy (xpath ="//div[@class=\"ngx-spinner-overlay ng-tns-c31-16 ng-trigger ng-trigger-fadeIn ng-star-inserted\"] ")
	WebElement Spinner;

	
	@FindBy (xpath="//div[text()=' Product Added To Cart ']")
	WebElement SuccessMsg;
	
	
	
	public List<WebElement> getList() {
		waitForElementToShow(productsBy);
		return Products;
	}
	
	public WebElement GetProductName(String Product) {
		WebElement prod = getList().stream().filter(S-> S.findElement(By.xpath("div/h5/b")).getText().equalsIgnoreCase(Product)).findFirst().orElse(null);
		return prod;
	}
	
	public CheckoutPage AddtoCart(String PRODUCT) {
		CheckoutPage CP = new CheckoutPage(driver);
		WebElement PROD = GetProductName(PRODUCT);
		PROD.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		WaitforElementToDisappear(Spinner);
		System.out.println("Spinner done");
		WaitforElementToDisappear(SuccessMsg);
		System.out.println("SuccessMsg done");
		return CP;
		
	}
	
	

}
