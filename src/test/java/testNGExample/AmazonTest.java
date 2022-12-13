package testNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
	
	//Priority
	//by default priority : 0
	//If priority is same, execution of method as per naming con alphabetic order
	//highest negative number having highest priority 
	
	
	
	@BeforeTest
	public void launchApp() {
		
		System.out.println("launching application");
		
	}
	
	@AfterTest
	public void closeApp() {
		
		System.out.println("closing application");
		
	}
	
	@Test(priority = -1)
	public void login() {
		
		System.out.println("login test case");
		
	}
	
	@Test(priority = 2)
	public void logout() {
		
		System.out.println("logout test case");
		
	}
	
	@Test
	public void addItems() {
		
		System.out.println("addItems test case");
		
	}
	
	@Test
	public void payment() {
		
		System.out.println("payment test case");
		
	}

}
