/**
 * 
 */
package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admn
 *
 */
public class CustomDateFormat {

	public static String getCurrentDateFormat() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy  hh:MM:ss");

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy
		// hh:MM:ss");

		Date date = new Date();

		String  data = dateFormat.format(date);
		
		System.out.println("The date format is: "+data);
		
		return data;
		
		

	}

}
