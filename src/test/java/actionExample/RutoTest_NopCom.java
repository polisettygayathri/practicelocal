package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RutoTest_NopCom {
	
	WebDriver driver;
	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	@Test
	public void verifyWishList() {
		
		driver.findElement(By.id("Email")).sendKeys("enter value");
		
		driver.findElement(By.id("Email")).sendKeys("values to send");
		
		
		driver.findElement(By.xpath("//input[@name='RememberMe']")).click();
		
		
		driver.findElement(By.tagName("button")).click();
		
	}

}
