package RSA2_Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import RSA2_Framework.AbstractCompoenents.AbstractCompoenent;

public class OrderHistoryPage extends AbstractCompoenent{
	
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	@FindBy (xpath="//tbody/tr")
	List<WebElement> OrderHistoryList;
	
	public boolean VerifyOrderHistory(String ProductName) {
		boolean match =OrderHistoryList.stream().anyMatch(S-> S.findElement(By.xpath("td[2]")).getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	
	

}
