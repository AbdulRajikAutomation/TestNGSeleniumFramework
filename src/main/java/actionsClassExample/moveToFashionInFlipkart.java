package actionsClassExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class moveToFashionInFlipkart {
	public static WebDriver driver;
	static String chromePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String flipkartUrl = "https://www.flipkart.com";
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(flipkartUrl);
		System.out.println("launch flipkart");
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		
	}
static String fashionXpath = "//span[@class='_1XjE3T']//span[contains(text(),'Fashion')]";
	public static void moveToFashion() {
		try {
			WebElement fashionEle =  driver.findElement(By.xpath(fashionXpath));
			Actions act = new Actions(driver);
			act.moveToElement(fashionEle).build().perform();
			System.out.println("moved to fashion Element");
			
		}catch(Exception e) {
			System.out.println("Failed to move "+e.getMessage());
		}
	}
	static String mensTshirtXpath = "//div[@class='_31z7R_']//a[2]";
	public static void clickOnTshirt() {
		try {
			driver.findElement(By.xpath(mensTshirtXpath)).click();
			System.out.println("click on men t shirt");
		}catch(Exception e) {
			System.out.println("error in click on t shirt");
		}
	}
	
	static String elementAXpath = "//div[@id='column-a']";
	static String elementBXpath = "//div[@id='column-b']";
	public static void drpandDrag() {
		try {
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		Actions ac = new Actions(driver);
		Thread.sleep(4000);
		WebElement sourceEle = driver.findElement(By.xpath(elementAXpath));
		WebElement destEle = driver.findElement(By.xpath(elementBXpath));
		
		ac.dragAndDrop(sourceEle, destEle).build().perform();
		System.out.println("drag and drop");
		}catch(Exception e) {
			System.out.println("failed"+e.getMessage());
		}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchChrome();
		moveToFashion();
		clickOnTshirt();
		drpandDrag();
	}

}
