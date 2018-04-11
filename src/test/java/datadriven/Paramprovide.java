package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramprovide {
	/*@Test
	@Parameters("adminuserid")
	public void UserID(String userid) {
		System.out.println(userid);
	}*/
	WebDriver driver;
	@Test
	public void Login() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\eclipse-oxygen\\workspace\\TestNG\\src\\datadriven\\code.properties");
		prop.load(fis);
		System.out.println("Username = "+prop.getProperty("username"));
		System.out.println("Password = "+prop.getProperty("password"));
		
		if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E://selenium/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E://selenium/chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.ie.driver", "E://selenium/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
