package controlExample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utlity.ReadConfig;

public class BaseTest {

	public WebDriver driver;
	public ReadConfig conf;

	// ctrl+shoift+O ------ auto import

	// pre-condition ---- @BeforeSuite---
	// Test
	// post-condition

	@BeforeTest
	//@BeforeClass
	public void launchApp() throws Exception {

		System.out.println("launching app");

		driver = WebDriverManager.chromedriver().create();
		
		
		//create an object of configRead
		
		conf = new ReadConfig();
		System.out.println(conf.getSampleAppURL());
		
		
		driver.get(conf.getSampleAppURL());
		driver.manage().window().maximize();

	}

	@AfterTest
	//@AfterClass
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}

}
