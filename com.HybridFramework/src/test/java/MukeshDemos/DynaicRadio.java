/**
 * 
 */
package MukeshDemos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author admn
 *
 */
public class DynaicRadio   {

	@Test
	public void radio(){
		
		System.out.println("=======starting====");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
			
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		List<WebElement> radio=driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		
		for(WebElement ele:radio){
			
			System.out.println("First element"+ele.getAttribute("value"));
			
			if(ele.getAttribute("value").equalsIgnoreCase("JAVA")){
				
				
				System.out.println("Inner HTML text::::"+ele.getAttribute("innerHTML"));
				System.out.println("Inner HTML text::::"+ele.getAttribute("outerHTML"));
				
				
			ele.click();
			}
			
		}
		
		
		
	}
	
	
	
}
