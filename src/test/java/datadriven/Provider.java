package datadriven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider extends Paramprovide {
	
		@Override
		public void Login() throws IOException {
			// TODO Auto-generated method stub
			super.Login();
		}
	/*@Test
	public void Login1() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}*/
	@Test(dataProvider="getData")
	public void userID(String username, String password) {
		System.out.println("UserID & Password");
		System.out.println(username);
		System.out.println(password);
	}
	
	/*@Test()
	public void browserOpened() {
		System.out.println("Hello google");
	}
	*/
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0] = "abcd";
		data[0][1] = "xyza";
		data[1][0] = "varun";
		data[1][1] = "uppal";
		data[2][0] = "krsna";
		data[2][1] = "balram";
		return data;
	}
}
