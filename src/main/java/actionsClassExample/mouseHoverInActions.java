package actionsClassExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseHoverInActions {
	public static Actions act;
	public static WebDriver driver;
	static String flipkartUrl ="https://www.flipkart.com/";
	public static void launchFlipkart() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(flipkartUrl);
			driver.manage().window().maximize();
			
		}catch(Exception e) {
			
		}
	}
	
	static String fashionXpath = "//span[@class='_1XjE3T']//following::span[contains(text(),'Fashion')]";
	static String menTShirtXpath = "//div[@class='_31z7R_']//a[2]";
	static void clickOnFashion() {
		try {
			WebElement fashion = driver.findElement(By.xpath(fashionXpath));
			act = new Actions(driver);
			act.moveToElement(fashion).build().perform();
			System.out.println("move to the fashion element");
			WebElement tshirt = driver.findElement(By.xpath(menTShirtXpath));
			boolean b1 = tshirt.isDisplayed();
			System.out.println("b1 "+b1);
			if(b1 == true) {
				tshirt.click();
				System.out.println("click on T-Shirt");
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public static String elementAidValue = "column-a";
	public static String elementBidValue = "column-b";
	public static void dragAndDropElement() {
		try {
			driver.get("https://the-internet.herokuapp.com/drag_and_drop");
			Thread.sleep(3000);
			WebElement elementA = driver.findElement(By.id(elementAidValue));
			WebElement elementB = driver.findElement(By.id(elementBidValue));	
			act.dragAndDrop(elementA, elementB).build().perform();
			System.out.println("drag and drop on the element");
		}catch(Exception e) {
			System.out.println("failed in dragAndDropElement ");
		}
	}
	public static String brokenImagesXpath = "//div[@class='example']";
	public static void handleBrokenImages() {
		try {
			driver.get("https://the-internet.herokuapp.com/broken_images");
			Thread.sleep(4000);
			WebElement images = driver.findElement(By.xpath(brokenImagesXpath));
			
			List<WebElement> imagesCount = images.findElements(By.tagName("img"));
			System.out.println("no of images count ="+imagesCount.size());
            for(WebElement ele :imagesCount ) {
            	String val = ele.getAttribute("src");
            	System.out.println(val);
            	System.out.println("element href value"+ele.getAttribute("href"));
            }
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchFlipkart();
		clickOnFashion();
		dragAndDropElement();
		handleBrokenImages();
	}

}
