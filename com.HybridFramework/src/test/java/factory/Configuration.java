/**
 * 
 */
package factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author admn
 *
 */
public class Configuration {

	Properties pro;

	public Configuration() {

		try {
			System.out.println("=============Configuration file is about to start==========");
			
			File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");

			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
			
			System.out.println("============Configuration file started===============");
			
		} catch (Exception e) {

			System.out.println("===========Unable to load config file=============");

			System.out.println(e.getMessage());

		}

	}

	public String getBrowser() {

		String browser = pro.getProperty("browser");

		return browser;
	}

	public String getURL() {

		String url = pro.getProperty("url");

		return url;
	}

}
