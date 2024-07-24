package handlesFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class frame_PractiseExample {

	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://www.hyrtutorials.com/p/frames-practice.html";

	public void launchHYRPage() {
		try {
			System.setProperty("webdriver.chrome.driver",chromedriverPath );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			System.out.println("launch H Y R Tutorial page");
			}catch(Exception e) {
			System.out.println("error :"+e.getMessage());	
			}
	}
    static String dropdownXpath = "(//select[@id='selectnav1' and @class='selectnav'])[1]";
	static String txtBoxXpathValue = "//input[@id='name']";
    public void handleFrame1() {
		try {
		driver.switchTo().frame("frm1");
		System.out.println("switched to frame 1");
	   WebElement frm1Drpdown = driver.findElement(By.xpath(dropdownXpath));
	   Select sc = new Select(frm1Drpdown);
	   List<WebElement> el =  sc.getOptions();
	   int count = el.size();
	   System.out.println("count ="+count);
	   sc.selectByVisibleText("-- Automation Testing");
	   System.out.println("select tutorials");
	   driver.switchTo().defaultContent();
	   System.out.println("switch to entire page");
	   driver.findElement(By.xpath(txtBoxXpathValue)).sendKeys("java");
	   System.out.println("entered text in text box field");
		}catch(Exception e) {
			System.out.println("handle frame1 method failed"+e.getMessage());
		}
	}
	
//	public static void main(String[] args) {
//		launchHYRPage();
//		handleFrame1();
//	}

}
