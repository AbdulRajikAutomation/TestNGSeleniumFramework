package handlesFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class framesExample {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://www.hyrtutorials.com/p/frames-practice.html";
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
    public static void handleFrames() {
    	try {
    		WebElement frm1 = driver.findElement(By.id("frm1"));
    		driver.switchTo().frame(frm1);
    		System.out.println("Switch to frame");
    		WebElement drpdown = driver.findElement(By.xpath("//div[@id='menu']//select[@id='selectnav1' and @class='selectnav']"));
    		Select sc = new Select(drpdown);
    		sc.selectByVisibleText("- Java");
    		System.out.println("selected value from dropdown");
    		driver.switchTo().defaultContent();
    	}catch(Exception e) {
    		System.out.println("Exception in handle Frames"+e.getMessage());
    	}
    }
    
    public static void handleTextBox() {
    	try {
    		WebElement txtBox = driver.findElement(By.xpath("//input[@id='name']"));
    		txtBox.sendKeys("java language");
    		System.out.println("enter text");
    	}catch(Exception e) {
    		System.out.println("error in handleText box"+e.getMessage());
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchChrome();
		handleFrames();
		handleTextBox();
	}

}
