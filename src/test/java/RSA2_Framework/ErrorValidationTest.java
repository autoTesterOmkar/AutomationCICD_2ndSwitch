package RSA2_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import RSA2_Framework.TestCompoenent.BaseTest;
import RSA2_Framework.pageobjects.LoginPage;

public class ErrorValidationTest extends BaseTest {
	
	@Test (groups= {"ErrorFirst"})
	//if you use groups then you have to give alwaysrun=true for Beforemethod
	public void ErrorValidation() {
		
		String ProductName = "ZARA COAT 3";
		
		LoginPage LP = new LoginPage(driver);
		
		LP.Login("opawar449@gmail.com", "bacchaDon");
		
		Assert.assertEquals("Incorrect email or password.", LP.ErrorMessage());
	}
	
	
	@Test
     public void ErrorVerify() {
	
		LoginPage LP = new LoginPage(driver);
		
		LP.Login("BP@gmail.com", "bacchaDon");
		
		Assert.assertEquals("Incorrect emai or password.", LP.ErrorMessage());
	}

}
