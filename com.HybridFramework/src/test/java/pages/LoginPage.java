/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SyncElement;

/**
 * @author admn This script is to store all the locators of the login page
 *         Created By: Srikumar Created On: 18-11-2018
 */
public class LoginPage {

	@FindBy(how = How.ID, using = "txtUsername")
	WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	WebElement submitButton;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
	WebElement admin;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "logout")
	WebElement logout;

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public boolean loginDetails(String uname, String pass) {

//		username.sendKeys(uname);
		
		SyncElement.waitForElement(driver, username).sendKeys(uname);

//		password.sendKeys(pass);
		
		SyncElement.waitForElement(driver, password).sendKeys(pass);

//		submitButton.click();
		
		SyncElement.waitForElement(driver, submitButton).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		boolean status = false;
		
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Welcome")));
		
        try {
			status = ele.isDisplayed();
			
			if(status == true){
				
				admin.click();
				
				Thread.sleep(500);
				
				logout.click();
			}
			
		} catch (Exception e) {
			
			System.out.println("=====================Element not found================");
			
			System.out.println(e.getMessage());
			
		}
		
        return status;
	}

}
