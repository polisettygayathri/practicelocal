package controlExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest{
	
	
	@Test
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
	
	
	@Test
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
		
		Assert.assertEquals(promptAlert.getText(), "Your Name Please");
		Assert.assertTrue(promptAlert.getText().contains("Name Please"));
		
		promptAlert.sendKeys("abhishek");
		
		promptAlert.accept();
		//confirmAlert.dismiss();
		
			
		
		
	}
	

}
