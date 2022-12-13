package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {

		// this.driver = driver;
		driver = rdriver;

	}

	// Identification

	By txtEmail = By.id("Email");
	By txtPass = By.id("Password");
	By chkRem = By.xpath("//input[@name='RememberMe']");
	By btnLogin = By.tagName("button");

	
	
	
	
	
	
	// Methods

	public void enterEmail(String email) {

		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}

	public boolean verifyElementPresent(By eleLocator) {

		return driver.findElement(eleLocator).isDisplayed();
	}

	public boolean verifyEmailTxtboxDispalyed() {

		return verifyElementPresent(txtEmail);
	}

	public void enterPass(String pwd) {

		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);
	}

	public void clickRememberCheckbox() {

		driver.findElement(chkRem).click();
	}

	public void clickLoginButton() {

		driver.findElement(btnLogin).click();
	}

	public void verificationAppTitle(String expectedValue) {

		Assert.assertEquals(driver.getTitle(), expectedValue);
	}

}
