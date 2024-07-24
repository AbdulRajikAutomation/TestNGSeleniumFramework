package sauceDemoDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handleDropdowns {

	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url = "https://www.saucedemo.com/";
	static String usernameID = "user-name";
	static String passwordID= "password";
	static String loginID = "login-button";
	static String usernameValue = "standard_user";
	static String passwordValue = "secret_sauce";
	static void launchChrome() {
		try {
		System.setProperty("webdriver.chrome.driver",chromedriverPath );
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.id(usernameID)).sendKeys(usernameValue);
		Thread.sleep(3000);
		driver.findElement(By.id(passwordID)).sendKeys(passwordValue);
		Thread.sleep(3000);
		driver.findElement(By.id(loginID)).click();
		Thread.sleep(4000);
		System.out.println("login sucessful");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	static String dropdownXpath = "//select[@class='product_sort_container']";
	static void handleDropdown() {
		try {
		WebElement priceDropdown = driver.findElement(By.xpath(dropdownXpath));
		Select sc = new Select(priceDropdown);
		sc.selectByValue("lohi");
		System.out.println("select low to high");
		Thread.sleep(4000);
//		sc.selectByVisibleText("Name (Z to A)");
		System.out.println("select by name");
		WebElement priceDropdown2 = driver.findElement(By.xpath(dropdownXpath));
		Select sc2 = new Select(priceDropdown2);
		Thread.sleep(3000);
		List<WebElement> values = sc2.getOptions();
		int count = values.size();
		System.out.println("count ="+count);
		for(WebElement val : values) {
			System.out.println(val.getText());
		}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchChrome();
		handleDropdown();
	}

}
