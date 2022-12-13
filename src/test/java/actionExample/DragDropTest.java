package actionExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDropTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}

	@Test
	public void verifyDragDropTest() throws Exception {

		
		WebElement myframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		driver.switchTo().frame(myframe);
		
		
		// Create an Object of Actions class

		Actions act = new Actions(driver);

		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		//method1
		act.dragAndDrop(img3, trash).perform();
		
		Thread.sleep(4000);
		
		//method2
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		
		act.clickAndHold(img4).moveToElement(trash).release().perform();
		
		
		
	}

	
	
	

}
