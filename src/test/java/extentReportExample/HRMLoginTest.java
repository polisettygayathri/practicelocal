package extentReportExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {

	public WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test(priority = 1)
	public void login() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
				
		
	}

	@Test(priority = 2)
	public void logout() throws Exception {

		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a#welcome1111")).click();
		driver.navigate().refresh();
		Assert.assertTrue(false);

	}

}
