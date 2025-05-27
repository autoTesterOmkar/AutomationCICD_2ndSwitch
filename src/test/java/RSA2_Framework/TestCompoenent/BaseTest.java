package RSA2_Framework.TestCompoenent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RSA2_Framework.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	public WebDriver driver;
	LoginPage LP ;
	
	public WebDriver intalizedDriver() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RSA2_Framework\\resources\\Globaldata.properties");
		//below load method expect Inputstream as object so all our data in Globalfile we convert it into Inputstream so thats why we use
		prop.load(fis);
		
		String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
	      //prop.getProperty("browser");
	
		 if (BrowserName.contains("chrome")) {
		ChromeOptions opt= new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if (BrowserName.contains("headless")) {
			opt.addArguments("headless");
		}
		
		//System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver(opt);
	    
		 } else if (BrowserName.equalsIgnoreCase("firefox")) {
			 System.out.println("InsideFirefox else if block");
			 driver = new FirefoxDriver();
			 System.setProperty("webdriver.gecko.driver", "E:\\Automation\\FireFoxDriver\\geckodriver.exe");
			 
		 }
		 
		 driver.manage().window().maximize();
		 return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException {
		//read json to String
		 String jsonContent=FileUtils.readFileToString(new File(Filepath),StandardCharsets.UTF_8);
	
	//now convert String to HashMap
		 
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		 
		 return data;
	
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName +".png";
		
	}
	
	
	@BeforeMethod (alwaysRun = true)
	public void launchapplication() throws IOException {
		
		driver=intalizedDriver();
	    
	}
	
	@AfterMethod(alwaysRun = true)
	public void CloseTest() {
		driver.close();
	}

}
