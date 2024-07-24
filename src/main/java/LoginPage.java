import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	static String passwordXpath = "//input[@name='password']";
	static String loginBtnXpath = "//button[@type='submit']";
	static String passwordValue = "admin123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String path = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("launch chrome");
		// maximize the browser
		driver.manage().window().maximize();
		System.out.println("maximized the browser");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//text box
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(4000);
		// password text box
		driver.findElement(By.xpath(passwordXpath)).clear();
		driver.findElement(By.xpath(passwordXpath)).sendKeys(passwordValue);
		//click on login button
		
		driver.findElement(By.xpath(loginBtnXpath)).click();
		System.out.println("login is done");
		}catch(Exception e) {
			System.out.println("error");
		}
		
		
		
		
		
	}

}
