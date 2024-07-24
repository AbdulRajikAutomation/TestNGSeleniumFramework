package windowHandleAndwindowHandlesExample;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleMultipleandSingleWindow {
	
	WebDriver driver;
	
	void launchOrangeHrm() {
		try {
		String path = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm"
				+ "\\src\\main\\resources\\driverDependency\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("launch chrome");
		// maximize the browser
		driver.manage().window().maximize();
		System.out.println("maximized the browser");
		Thread.sleep(4000);
		String orangeTab = driver.getWindowHandle();
		System.out.println("orangeTab = "+orangeTab);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.open()");
		System.out.println("open a new tab");
		Set<String> hs = driver.getWindowHandles();
		int count = hs.size();
		System.out.println("count ="+count);
		System.out.println(driver.getTitle());
		for(String v : hs) {
			driver.switchTo().window(v);
			System.out.println("title -"+driver.getTitle());
			
		}
		driver.get("https://www.amazon.in/");
		System.out.println("tile of amazon"+driver.getTitle());
		}catch(Exception e) {
			System.out.println("Exception e"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		handleMultipleandSingleWindow obj = new handleMultipleandSingleWindow();
		obj.launchOrangeHrm();

	}

}
