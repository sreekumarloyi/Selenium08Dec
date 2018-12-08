/**
 * 
 */
package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author admn
 *
 */
public class Helper {

	public static String getScreenshots(WebDriver driver){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir") + "/Screenshots/OrangeHRM" + CustomDateFormat.getCurrentDateFormat() +".html";
		
		File dest = new File(path);
		
	    try {
			FileUtils.copyFile(src, dest);
			
		} catch (IOException e) {
			
			System.out.println("==========Unable to capture screenshot============");
			
			System.out.println(e.getMessage());
		}
		
	    
	    return path;
	}
	
	
}
