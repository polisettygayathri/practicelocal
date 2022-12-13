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

public class ModelExampleTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		//driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		//driver.close();

	}

	@Test
	public void verifyModelTest() throws Exception {

		Thread.sleep(7000);
		System.out.println("execution is in prpogress....");
		WebElement launchModelButton = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
		
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		JS.executeScript("arguments[0].click()", launchModelButton);
		
		
		//handle model
		//alert/frame/windows  ----- driver.switchTo()
		
		Thread.sleep(3000);
		String heading = driver.findElement(By.cssSelector(".modal-title")).getText();
		String body = driver.findElement(By.cssSelector(".modal-body")).getText();
		
		System.out.println(heading);
		System.out.println(body);
		
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
	}

	
	
	

}
