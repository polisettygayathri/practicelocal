package javascriptExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyntraApp {

	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}

	@Test
	public void verifyModelTest() throws Exception {

		Thread.sleep(5000);
		WebElement Return30Days = driver.findElement(By.xpath("//strong[contains(text(),'Return within 30days')]"));
		
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		JS.executeScript("arguments[0].scrollIntoView()", Return30Days);
		
		
		
		
	}

	
	
	

}
