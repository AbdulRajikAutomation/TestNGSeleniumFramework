package usingNavigate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageOrangeHRM {
	static String passwordXpath = "//input[@name='password']";
	static String loginBtnXpath = "//button[@type='submit']";
	static String passwordValue = "admin123";
	WebDriver driver;
	void performLogin() {
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
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// text box
			driver.findElement(By.xpath("//input[@name='username']")).clear();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(4000);
			// password text box
			driver.findElement(By.xpath(passwordXpath)).clear();
			driver.findElement(By.xpath(passwordXpath)).sendKeys(passwordValue);
			// click on login button

			driver.findElement(By.xpath(loginBtnXpath)).click();
			System.out.println("login is done");
			String orangePageTitle = driver.getTitle();
			if (orangePageTitle.equals("OrangeHRM")) {
				System.out.println("title matched");
			} else {
				System.out.println("title not matched");
			}
			System.out.println("orangePageTitle = " + orangePageTitle);
			driver.navigate().to("https://www.google.com");
			System.out.println("navigated to google page");
			System.out.println("Google page title =" + driver.getTitle());
			Thread.sleep(4000);
			driver.navigate().back();
			System.out.println("navigated to orange hrm");
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.navigate().forward();
			
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	void getPageCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("google page url ="+url);
		
	}
	
	void getGooglePageSource() {
		String page = driver.getPageSource();
		System.out.println("page source value :"+page);
		((JavascriptExecutor)driver).executeScript("window.open()");
	}

	public static void main(String args[]) {
		loginPageOrangeHRM lp = new loginPageOrangeHRM();
		lp.performLogin();
		lp.getPageCurrentUrl();
		lp.getGooglePageSource();
	}
}
