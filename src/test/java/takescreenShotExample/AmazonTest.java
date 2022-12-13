package takescreenShotExample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
	
	WebDriver driver;
	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	@Test
	public void verifyWishList() throws Exception {
		
		
		//Create an Object of Actions class
		
		Actions act = new Actions(driver);
		
		
		WebElement SignIn = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		
		WebElement CreateWishList = driver.findElement(By.xpath("//span[contains(text(),'Create ')]"));
		
		
		//move to element SignIn
		//app1
//		act.moveToElement(SignIn).perform();
//		act.moveToElement(CreateWishList).click().perform();
		
		
		//app2
		act.moveToElement(SignIn).click(CreateWishList).perform();
		
		Thread.sleep(5000);
		//takescreenshot
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		ts.getScreenshotAs(OutputType.FILE);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File target = new File(".\\screenshot\\AmazonWishList.png");
		
		FileUtils.copyFile(screenshotFile, target);
		
		
	}

	
	public void clickOperation(WebElement ele) {
		
		ele.click();
		
	}
	
	
}
