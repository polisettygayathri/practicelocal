package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utlity.ReadConfig;

public class HandleAlert2 {
	
	ReadConfig conf;
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {

		System.out.println("launching app");

		driver = WebDriverManager.chromedriver().create();
		
		
		//create an object of configRead
		
		conf = new ReadConfig();
		System.out.println(conf.getSampleAppURL());
		
		
		driver.get("file:///D:/Test.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}
	
	//@Test
	public void verifySimpleAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.cssSelector("input[value='Show Me Alert']")).click();
		
		
		//Alert/frame/window  ------ driver.switchTo()
		//handle alert
		
		//accept --- ok
		//dismiss ---- cancel //esc
		//getText
		//sendKeys
		
		Thread.sleep(3000);
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("Text on Alert: " + simpleAlert.getText());
		
		//validation step
		
		Assert.assertEquals(simpleAlert.getText(), "Hi.. This is alert message!");
		Assert.assertTrue(simpleAlert.getText().contains("alert message"));
		
		//simpleAlert.accept();
		simpleAlert.dismiss();
		
	}
	
	
	//@Test
	public void verifyConfirmAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.xpath("//button[contains(text(),'Confirmation')]")).click();
		
		
		//Alert/frame/window  ------ driver.switchTo()
		//handle alert
		
		//accept --- ok
		//dismiss ---- cancel //esc
		//getText
		//sendKeys
		
		Thread.sleep(3000);
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("Text on Alert: " + confirmAlert.getText());
		
		//validation step
		
		Assert.assertEquals(confirmAlert.getText(), "Press 'OK' or 'Cancel' button!");
		Assert.assertTrue(confirmAlert.getText().contains("'OK' or 'Cancel'"));
		
		//confirmAlert.sendKeys("abhishek");
		
		confirmAlert.accept();
		//confirmAlert.dismiss();
		
		//validation step
		
		String label_ok_cancel = driver.findElement(By.id("demo")).getText();
		
		Assert.assertEquals(label_ok_cancel, "You pressed OK!");
		Assert.assertTrue(label_ok_cancel.contains("OK"));
		
		
		
	}
	
	
	@Test
	public void verifyPromptAlert() throws Exception {
		
		Thread.sleep(3000);
		//generate an alert
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();

		
		Thread.sleep(3000);
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Text on Alert: " + promptAlert.getText());
		
		//validation step
		
		Assert.assertEquals(promptAlert.getText(), "Please enter your name:");
		Assert.assertTrue(promptAlert.getText().contains("enter your name"));
		
		String name = "Rupal";
		
		promptAlert.sendKeys(name);
		
		promptAlert.accept();
		//confirmAlert.dismiss();
		
			
		//validation step
		
		String label_ok_cancel = driver.findElement(By.id("demoPrompt")).getText();
		System.out.println(label_ok_cancel);
		Assert.assertTrue(label_ok_cancel.contains(name));
		
	}
	

}
