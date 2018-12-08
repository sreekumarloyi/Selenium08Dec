package testCases;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class screenShot {
	
	private TakesScreenshot TakescreenShot;

	@Test
	
	public void screen(){

		
		WebDriver d=new FirefoxDriver();
		
		d.get("https://www.google.com/");
		
		TakesScreenshot ts=(TakescreenShot);
		
		
		
		
	}

}
