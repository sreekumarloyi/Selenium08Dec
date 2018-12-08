/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

/**
 * @author admn
 *
 */
public class TestCase05 extends BaseClass {

	ExtentTest logger;
	
	@BeforeMethod
	public void setUpReport() {

		 logger  = reports.startTest("Verifying the Login Page");

	}

	@AfterMethod
	public void tearDown() {

//		ITestResult result
//		if(result.getStatus()==ITestResult.FAILURE){
//			
//			logger.log(LogStatus.FAIL, "User is not able to login");
//		}
		
		reports.endTest(logger);
	}

	@Test
	public void verifyLogin() {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		logger.log(LogStatus.INFO, "Automating Login page");

		try {
			login.loginDetails("admin123", "admin123");
			
			logger.log(LogStatus.PASS, "User is able to login");
			
		} catch (Exception e) {
			
			logger.log(LogStatus.FAIL, "User is not able to login");
		}

		System.out.println("The title of the page is:" + driver.getTitle());

	}

}
