package nopCommLog4J;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utlity.ReadConfig;

public class BaseTest {

	WebDriver driver;
	ReadConfig conf;
	Logger log;
	// ctrl+shoift+O ------ auto import

	// pre-condition ---- @BeforeSuite---
	// Test
	// post-condition

	
	
	@Parameters("ibm_browser")
	@BeforeTest
	public void launchApp(String browser) throws Exception {

		
		
		log = Logger.getLogger("NOP Comm Application Module");
		PropertyConfigurator.configure(".\\testData\\log4j.properties");
		
		
		
		log.info("launching applicaiton on browser : " + browser);
		
//		System.out.println("launching app");
//
//		System.out.println("Execution on browser: " + browser);
		//String browser = "chrome";
		
		
		//driver = WebDriverManager.chromedriver().create();
		//driver = WebDriverManager.edgedriver().create();
		
		
		if(browser.equalsIgnoreCase("CHROME")) {
			
			log.info("browser launched");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else {
			
			System.out.println("execution on defaul browser: " + browser);
			//default execution on chrome browser
			driver = new ChromeDriver();
		}
		
		
		
		//create an object of configRead
		
		conf = new ReadConfig();
		//System.out.println(conf.appURL());
		log.info("Application URL " + conf.appURL());
		
		driver.get(conf.appURL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		
		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");
		log.info("closing app");

	}

}
