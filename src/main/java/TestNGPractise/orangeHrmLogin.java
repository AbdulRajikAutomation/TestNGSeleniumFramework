package TestNGPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHrmLogin {
	static String chromepath="C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static WebDriver driver;
	static String pageUrl="https://opensource-demo.orangehrmlive.com/";
	
	public void launchchrome() {
		WebDriverManager.chromedriver().setup();
		System.out.println("setting the chrome driver");
		driver = new ChromeDriver();
		
	}

	public void launchOrangeHrm() {
		try {
			driver.get(pageUrl);
			System.out.println("page url ="+pageUrl);
			driver.manage().window().maximize();
		}catch(Exception e) {
			System.out.println("failed in launchOrangeHrm"+e.getMessage());
		}
	}
	
	static String userXpath ="//input[@name='username']";
	static String pwdXpath = "//input[@name='password']";
	static String loginBtnXpath = "//button[@type='submit']";
	public void userlogin(String username , String password) {
		try {
			System.out.println("username ="+username);
			System.out.println("password = "+password);
			driver.findElement(By.xpath(userXpath)).sendKeys(username);
			driver.findElement(By.xpath(pwdXpath)).sendKeys(password);
			Thread.sleep(4000);
			driver.findElement(By.xpath(loginBtnXpath)).click();
			System.out.println("login to the user");
			
		}catch(Exception e) {
			System.out.println("userlogin failed"+e.getMessage());
		}
	}
	
	public void validatePageTitle() {
		try {
			String actual = driver.getTitle();
			System.out.println("title = "+actual);
			if(actual.equalsIgnoreCase("orangehrm")) {
				System.out.println("title is matched");
			}else {
				System.out.println("title has not matched");
			}
		}catch(Exception e) {
			System.out.println("validatePageTitle failed"+e.getMessage());
		}
	}
	
	public void closeBrowser() {
		driver.quit();
		System.out.println("closed the chrome");
	}
	
}
