package FindElementsTopics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workingOnFindElements {
	static String passwordXpath = "//input[@name='password']";
	static String loginBtnXpath = "//button[@type='submit']";
	
	WebDriver driver;
	void findNoOfLinksCount() {
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
		// no of links with find elements
		// links tagname - a
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		Thread.sleep(4000);
		driver.findElement(By.xpath(passwordXpath)).clear();
		driver.findElement(By.xpath(passwordXpath)).sendKeys("admin123");

		System.out.println("login is done");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int v =links.size();
		System.out.println("no of links ="+v);
		List<WebElement> inputTags = driver.findElements(By.tagName("input"));
		System.out.println("no of input tags ="+inputTags.size());
		
		// click on login button

		driver.findElement(By.xpath(loginBtnXpath)).click();


		}catch(Exception e) {
			System.out.println("Error  ="+e.getMessage());
		}
	
	}
	
	void getHrefValueForLinks() {
		try {
			Thread.sleep(4000);
		List<WebElement> lnks=	driver.findElements(By.tagName("a"));
			System.out.println("links count in dashboard page ="+lnks.size());
			
			// enhanced for loop
			for(WebElement name : lnks) {
				String val =name.getAttribute("href");
				System.out.println(val);
			}
			
		}catch(Exception e) {
			System.out.println("error in get href value method "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		workingOnFindElements obj = new workingOnFindElements();
		obj.findNoOfLinksCount();
		obj.getHrefValueForLinks();
	}

}
