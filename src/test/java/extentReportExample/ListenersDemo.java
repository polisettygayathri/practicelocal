package extentReportExample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersDemo extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/myReport_"+dateName_number+"_.html");//specify location of the report
				
		htmlReporter.config().setDocumentTitle("Incedo Automation Report"); // Title of report
		htmlReporter.config().setReportName("Incedo Functional Automation Testing Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","Incedo Automation");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Rajesh Singh");
			
	}
	
	public void onTestSuccess(ITestResult result)
	{
		//test=extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		test=extent.createTest(result.getName()); // create new entry in the report
				
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		test.info("************passed ********************");
		
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	}
