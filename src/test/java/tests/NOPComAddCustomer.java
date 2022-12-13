package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NOPComAddCustomer {

	
	@Test
	public void verifyLogin() {
		
		System.out.println("verifyLogin");
	}
	
	@Test
	public void verifyLogout() {
		
		System.out.println("verifyLogout");
	}
	
	
	@Test
	public void verifyAddCust() {
		
		System.out.println("verifyAddCust");
	}
	
	@Test
	public void verifySearchCust() {
		
		System.out.println("verifySearchCust");
		Assert.assertTrue(false);
	}
	
}
