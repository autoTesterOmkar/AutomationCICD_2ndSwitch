package RSA2_Framework.AbstractCompoenents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractCompoenent {

	WebDriver driver;
	
	@FindBy (css="button[routerlink*='cart']")
	WebElement CartBtn;
	
	@FindBy (xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrderHeader;
	
	public AbstractCompoenent (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToShow (By Locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public void WaitforElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForWebElementToShow(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void CartButton() {
		CartBtn.click();
	}
	
	public void OrderButton() {
		waitForWebElementToShow(OrderHeader);
		OrderHeader.click();
	}
	
}
