package RSA2_Framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA2_Framework.AbstractCompoenents.AbstractCompoenent;

public class LoginPage extends AbstractCompoenent{
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement Username;
	
	@FindBy (id="userPassword")
	WebElement Password;
	
	@FindBy (id="login")
	WebElement LoginBtn;
	
	//ng-tns-c4-93 toast-message ng-star-inserted
	
	@FindBy (css="div[class*='toast']")
	WebElement ErrorMsg;
	
    
	
	
	public ProductPage Login(String Uname, String password) {
		ProductPage PP = new ProductPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		Username.sendKeys(Uname);
		Password.sendKeys(password);
		LoginBtn.click(); 
		return PP;
    }
	
	public String ErrorMessage() {
		waitForWebElementToShow(ErrorMsg);
		return ErrorMsg.getText();
	}
	
	
}