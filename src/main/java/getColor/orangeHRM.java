package getColor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRM {
	
	public static WebDriver driver;

	 public static void launchGooglePage(String browsername) {
		try {
		System.out.println("browsername = "+browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--maximize","--incognito");
			driver = new ChromeDriver(opt);
			System.out.println("launched chrome browser");
		}else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launched Edge Browser");
		}
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("maximize the window");
		}catch(Exception e) {
			System.out.println("Failed in launchGooglePage"+e.getMessage());
		}
	}
	 
	 public static void getElementColor() {
		 try {
			 Thread.sleep(3000);
			 WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
			 
		 WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		 String colorType = loginBtn.getCssValue("color");
		 System.out.println("colorType = "+colorType);
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", username);
		 Thread.sleep(4000);
		 jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", loginBtn);
	 }catch(Exception e) {
		 System.out.println("error "+e.getMessage());
	 }
	 }

	
	public static void main(String args[]) {
		launchGooglePage("chrome");
		getElementColor();

	}

}
