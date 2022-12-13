package handleWindowExampe;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IRCTCApp {

	WebDriver driver;
	@BeforeTest
	//@BeforeClass
	public void launchApp() throws Exception {

		System.out.println("launching app");

		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();

	}

	@AfterTest
	//@AfterClass
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		//driver.close();
		driver.quit();
		System.out.println("closing app");

	}
	
	@Test
	public void verifyPayTMWebAccount() throws Exception {
		
		Thread.sleep(4000);
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow: "+ parentWindow);
		//window counts
		
		//driver.getWindowHandle();			//single window
		//driver.getWindowHandles(); 			//multiple window
		
		
		//Click on Hotel Button
		driver.findElement(By.xpath("//a[contains(text(),'HOT')]")).click();
		
		Set<String> allwindow = driver.getWindowHandles(); 			//multiple window
		
		System.out.println("Window count: " + allwindow.size());
		
		String mainWindow =(String)allwindow.toArray()[0];
		String HotelWindow =(String)allwindow.toArray()[1];
		
		System.out.println(mainWindow);
		System.out.println(HotelWindow);
		
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(HotelWindow);
		driver.findElement(By.linkText("Login")).click();
		
		
		
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//a[contains(text(),'CON')]")).click();
		
		
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(HotelWindow);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
	}
	
	
}
