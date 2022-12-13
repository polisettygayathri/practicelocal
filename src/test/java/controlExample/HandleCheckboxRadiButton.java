package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleCheckboxRadiButton extends BaseTest{
	
	
	@Test
	public void verifyCheckbox() {
		
		driver.findElement(By.xpath("//input[@value='Boat']")).click();
		driver.findElement(By.xpath("//input[@value='Car']")).click();
	}
	
	@Test
	public void verifyRadioButton() {
		
		driver.findElement(By.xpath("//input[contains(@value,'fem')]")).click();
	}

}
