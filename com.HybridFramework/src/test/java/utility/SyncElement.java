/**
 * 
 */
package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author admn
 *
 */
public class SyncElement {

	public static WebElement waitForElement(WebDriver driver, WebElement ele){
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element =  wait.until(ExpectedConditions.visibilityOf(ele));
		
		return element;
	}
	
}
