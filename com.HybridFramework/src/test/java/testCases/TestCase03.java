/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.Browser;
import factory.Config;
import pages.LoginPage;

/**
 * @author admn
 *
 */
public class TestCase03 {

	WebDriver driver;
	
	@Test
	public void verifyLogin(){
		
		driver = Browser.getBrowserAndURL(Config.getConfig().getBrowser(), Config.getConfig().getURL());
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginDetails("admin", "admin123");
		
		System.out.println("The title of the page is:"+driver.getTitle());
		
		driver.quit();
	}
	
	
}
