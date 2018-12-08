/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import excelConfiguration.ExcelGenerator;
import factory.Browser;
import factory.Config;
import utility.CustomDateFormat;

/**
 * @author admn
 *
 */
public class BaseClass {

	WebDriver driver;
	
	ExtentReports reports;
	
	@BeforeSuite
	public void startReport(){
		
//		String path = System.getProperty("user.dir") + "\\Reports" +System.currentTimeMillis()+".html";
		
		String path = System.getProperty("user.dir")+ "/Reports/HRM" + CustomDateFormat.getCurrentDateFormat() + ".html";
		
//		reports = new ExtentReports("E:\\Backup Data\\Appium-Nov16\\Madhu\\14-11-2018HybridFramework\\com.HybridFramework\\Reports");
		
		try {
			
			reports = new ExtentReports(path);
			
			System.out.println("==============Report folder executed succesfully============");
			
		} catch (Exception e) {
		
			System.out.println("Unable to load Extent report path");
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	@AfterSuite
	public void closeReport(){
		
		reports.flush();
		
		System.out.println("==============Succesfully got the report================");
	}
	
	@BeforeTest
	public void startApp(){
		
		System.out.println("============Browser & Application are about to start=============");
		
		driver = Browser.getBrowserAndURL(Config.getConfig().getBrowser(), Config.getConfig().getURL());
		
		System.out.println("============Browser & Application are up and running==============");
		
	}
	
	
	@AfterTest
	public void closeApp(){
		
		driver.quit();
		
		System.out.println("===============Browser Closed==============");
	}
	
	
	public  Object[][] excelInformation(String excelLocation, String sheetname){
		
		ExcelGenerator excel = new ExcelGenerator();
		
		return excel.getExcelData(excelLocation, sheetname);
		
	}
	
}
