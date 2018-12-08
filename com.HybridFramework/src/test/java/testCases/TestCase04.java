/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;

/**
 * @author admn
 *
 */
public class TestCase04 extends BaseClass {

	@Test
	public void verifyLogin() {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginDetails("admin", "admin123");

		System.out.println("The title of the page is:" + driver.getTitle());

	}

}
