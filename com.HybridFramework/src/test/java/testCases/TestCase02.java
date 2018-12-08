/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.Browser;
import factory.Configuration;
import pages.LoginPage;

/**
 * @author admn
 *
 */
public class TestCase02 {

	WebDriver driver;
	@Test
	public void verifyLogin(){
		
		Configuration config = new Configuration();
		
		driver = Browser.getBrowserAndURL(config.getBrowser(), config.getURL());
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginDetails("admin", "admin123");
		
		System.out.println("The title of the page is:"+driver.getTitle());
		
		driver.quit();
	}
	
	
}
