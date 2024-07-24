package actionsClassExample;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googlePageRightClickUsingActions {

	public static WebDriver driver;

	 public void launchGooglePage(String browsername) {
		try {
		System.out.println("browsername = "+browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched chrome browser");
		}else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launched Edge Browser");
		}
		driver.manage().window().maximize();
		System.out.println("maximize the window");
		}catch(Exception e) {
			System.out.println("Failed in launchGooglePage"+e.getMessage());
		}
	}
	
	public void hitPageUrl(String url) {
		try {
			System.out.println("url ="+url);
			driver.get(url);
			System.out.println("hit the url ");
			Thread.sleep(4000);
			System.out.println("waiting for 4 seconds");
		}catch(Exception e) {
			System.out.println("failed ata hitpage url"+e.getMessage());
		}
	}
	
	static String gmailXpath = "//a[text()='Gmail']";
	public void rightClickOnGmail() {
		try {
			Thread.sleep(4000);
			WebElement gmail = driver.findElement(By.xpath(gmailXpath));
			Actions act = new Actions(driver);
			act.contextClick(gmail).build().perform();
			System.out.println("performed right click on element");
			
		}catch(Exception e) {
			System.out.println("Error in right click on gmail "+e.getMessage());
		}
	}
	
	public void keyBoardOperation() {
		try {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("performed enter key operation");
	}catch(Exception e) {
		System.out.println("erro in key board operation"+e.getMessage());
	}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
