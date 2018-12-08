/**
 * 
 */
package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author admn
 *
 */
public class Browser {
	
	static WebDriver driver;

	public static WebDriver getBrowserAndURL(String browser, String url){
		
		if(browser.equalsIgnoreCase("Chrome")){
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			System.out.println("The following script is running on:"+browser);
		
		}else if (browser.equalsIgnoreCase("firefox")) {
			
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		System.out.println("The following script is running on:"+browser);
			
		}
		
		driver.get(url);
		
		return driver;
	}
	
	
}
