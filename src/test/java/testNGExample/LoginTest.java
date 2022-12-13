package testNGExample;

import org.testng.annotations.Test;

public class LoginTest extends TestNGAnotationExample{


	@Test
	public void verifyLogin() {
		
		System.out.println("login test case");
		
	}
	
	
	@Test
	public void verifyLogout() {
		
		System.out.println("logout test case");
		
	}
	
}
