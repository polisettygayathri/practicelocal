package frameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayTM_IFrame {

	WebDriver driver;
	@BeforeTest
	//@BeforeClass
	public void launchApp() throws Exception {

		System.out.println("launching app");

		//driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		
		//create an object of configRead
		
		
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	//@AfterClass
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}
	
	@Test
	public void verifyPayTMWebAccount() throws Exception {
		
		Thread.sleep(4000);
		//Click on SignIn Button
		driver.findElement(By.xpath("//span[contains(text(),'Sign')]")).click();
		
		Thread.sleep(4000);
		
		//Alert/iframe/window  ------- driver.switchTo()
		
		//Handle Frame
		//Index   ---- start from 0
		//ID/name
		//WevElement
		
		//iframe[contains(@src,'login')]
		//iframe[src*='login']
		
		//WebElement myFrame = driver.findElement(By.tagName("iframe"));
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'login')]"));
		
		//driver.switchTo().frame(0);
		
		//driver.switchTo().frame("id/name");
		
		driver.switchTo().frame(myFrame);
		
		Thread.sleep(4000);
		String payTMWebAccount = driver.findElement(By.cssSelector(".heading")).getText();
		System.out.println(payTMWebAccount);
		Assert.assertTrue(payTMWebAccount.contains("Paytm Web account"));
		
		
		
		//click on watch video
		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
		
	}
	
	
}
