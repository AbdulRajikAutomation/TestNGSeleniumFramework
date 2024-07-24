package takeScreenshotExample;

import java.io.File;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class exampleForTakeScreenshot {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://www.google.com";
    public static void launchChrome() {
    	try {
    		System.setProperty("webdriver.chrome.driver",chromedriverPath );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
    	}catch(Exception e) {
    		System.out.println("Error"+e.getMessage());
    	}
    }
    public static void takeScrShot() {
    	try {
    		// month day time
    		LocalDate date =  LocalDate.now();
    		System.out.println("year:"+date.getYear());
    		int month = date.getMonthValue();
    		System.out.println("month : "+month);
    		int day = date.getDayOfMonth();
    		System.out.println("day :"+day);
    		System.out.println("hour:"+date);
    		
    		File src =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(src, new File("C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\Results\\scr.png"));
    	}catch(Exception e) {
    		System.out.println("error in src shot"+e.getMessage());
    	}
    }

	public static void main(String[] args) {
		launchChrome();
		takeScrShot();
	}

}
