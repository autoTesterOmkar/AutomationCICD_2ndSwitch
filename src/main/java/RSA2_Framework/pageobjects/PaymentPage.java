package RSA2_Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import RSA2_Framework.AbstractCompoenents.AbstractCompoenent;

public class PaymentPage extends AbstractCompoenent {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement SelectCountry;
	
	@FindBy (css="button[class*='item']")
	List<WebElement> Countries;
	
	@FindBy (xpath="//div[text()='CVV Code ']/following-sibling::input")
	WebElement CVV;
	
	@FindBy (xpath="//div[text()='Name on Card ']/following-sibling::input")
	WebElement CardName;
	
	@FindBy (css="a[class*='action']")
	WebElement PlaceOrder;
	
	@FindBy (xpath="//label[@class='ng-star-inserted']")
	WebElement OrderID;
	
	By LoadCountry = By.cssSelector("section[class*='results']");
	
	By LoadOrderID = By.xpath("//label[@class='ng-star-inserted']");
	
	
	public void AddCountryInfo() {
		Actions a = new Actions(driver);
		a.moveToElement(SelectCountry).click().sendKeys("India").build().perform();
		waitForElementToShow(LoadCountry);
		WebElement match =Countries.stream().filter(S-> S.findElement(By.cssSelector("span")).getText().endsWith("India")).findFirst().orElse(null);
		match.click();
	}
	
	public void OtherPayInfo() {
		CVV.sendKeys("321");
		CardName.sendKeys("Omie Pawar");
		PlaceOrder.click();
	}
	
	public String OrderIDInfo() {
		waitForElementToShow(LoadOrderID);
		String OrderNumber = OrderID.getText();
		return OrderNumber;
	}

}
