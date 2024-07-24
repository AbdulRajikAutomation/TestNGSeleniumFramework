package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverWaitExmple {

	public static void waitfor() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
