import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class getCurrentDateTime {
public static Logger log = Logger.getLogger(getCurrentDateTime.class);
public static String log4jFilePAth="C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\log4j.properties";	
static void dt() {
		try {
	        // Get current date and time
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        
	        // Extract year, month name, day, and time
	        int year = currentDateTime.getYear();
	        String monthName = currentDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	        int dayOfMonth = currentDateTime.getDayOfMonth();
	        int hour = currentDateTime.getHour();
	        int minute = currentDateTime.getMinute();
	        
	        // Format time to display hours and minutes
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        String formattedTime = currentDateTime.format(timeFormatter);
	        
	        // Print current year, month name, day, and time
	        System.out.println("Current Year: " + year);
	        System.out.println("Current Month: " + monthName);
	        System.out.println("Current Day: " + dayOfMonth);
	        System.out.println("Current Time (HH:mm): " + formattedTime);

		}catch(Exception e) {
			System.out.println(""+e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dt();
		PropertyConfigurator.configure(log4jFilePAth);
		log.info("this is log.info method");
		log.debug("this is log debug method");
		log.error("this is log error method");

	}

}
