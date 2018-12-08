/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import utility.Helper;

/**
 * @author admn
 *
 */
public class TestCase08 extends BaseClass {

	ExtentTest logger;

	@BeforeMethod
	public void setUpReport() {

		logger = reports.startTest("Verifying the Login Page");

	}

	@AfterMethod
	public void tearDown() {

		reports.endTest(logger);
	}

	@DataProvider(name= "Data")
	public Object[][] excelDataFromBase(){
		
//		String excelLocation = System.getProperty("user.dir")+"/TestData/Login.xlsx";
		
		System.out.println("==================DataProvider is about to start======================");
		
		String excelLocation = "E:\\Backup Data\\Appium-Nov16\\Madhu\\14-11-2018HybridFramework\\com.HybridFramework\\TestData";
		
		String sheetname = "Sheet1";
		
		
		
		return excelInformation(excelLocation, sheetname);
		
		
		
	}

	@Test(dataProvider = "Data")
	public void verifyLogin(String lv_uname, String lv_pass) {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		logger.log(LogStatus.INFO, "Automating Login page");

		try {
			login.loginDetails(lv_uname, lv_pass);

			logger.log(LogStatus.PASS, "User is able to login");

		} catch (Exception e) {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.getScreenshots(driver)));
		}

		System.out.println("The title of the page is:" + driver.getTitle());

	}

}
