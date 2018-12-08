/**
 * 
 */
package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.CustomDateFormat;
import utility.Helper;

/**
 * @author admn
 *
 */
public class ExtentReport_Demo {

	ExtentReports reports;
	
	WebDriver driver;

	ExtentTest logger;

	@BeforeSuite
	public void reporting() {

		 /*String path = System.getProperty("user.dir") + "/Reports/OrganeHRM" +
		 System.currentTimeMillis() + ".html";*/
		String path = System.getProperty("user.dir") + "/Reports/OrganeHRM"+ "  " +CustomDateFormat.getCurrentDateFormat()
				+ ".html";
		System.out.println("The path for folder is:"+ path);
		try {
			reports = new ExtentReports(path);
			
			System.out.println("Reports folder loaded sucessfully");
			
		} catch (Exception e) {
			
			System.out.println("unable to load Before suite method");
			
		}

	}

	@AfterSuite
	public void closeReport() {

		reports.flush();
	}

	@BeforeMethod
	public void setUpReporting() {

		logger = reports.startTest("OrangeHRM");
	}

	@AfterMethod
	public void endReporting() {

		reports.endTest(logger);
	}

	
	@BeforeTest
	public void startBrowser(){
		
		 driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
		
	}
	
	@Test
	public void verifyHRM() throws InterruptedException {

		String url = driver.getCurrentUrl();

		if (url.contains("orangehrmlive.com")) {

			logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.getScreenshots(driver)));

			logger.log(LogStatus.PASS, "Succesfully user is able to connect OrganeHRM Application");

		} else {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.getScreenshots(driver)));
		}
		
		Thread.sleep(500);


		
	}

}
