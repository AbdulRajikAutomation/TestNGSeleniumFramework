package handleAlertsExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertExampleWithAllTypes {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://demo.automationtesting.in/Alerts.html";

	public static void launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",chromedriverPath );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			System.out.println("launch automation testing page");
			}catch(Exception e) {
			System.out.println("error :"+e.getMessage());	
			}
	}
	
	static String alertBoxvalue = "//button[contains(text(),'click the button to display an  alert box')]";
	
	 public static void clickOnAlertBox() {
		 try {
		 driver.findElement(By.xpath(alertBoxvalue)).click();
		 System.out.println("click on alert box");
		 Thread.sleep(3000);
		 System.out.println("wait for 3 seconds");
		 Alert al = driver.switchTo().alert();
		String val =  al.getText();
		System.out.println("val = "+val);
		// validate alert text
		if(val.equals("")) {
			System.out.println("text matched");
		}else {
			System.out.println(val+" not matched");
		}
		Thread.sleep(3000);
		al.accept();
		System.out.println("accept the alert");
		 }catch(Exception e) {
			 System.out.println("failed in method clickOnAlertBox"+e.getMessage());
		 }
	 }
	 
	 static String alertWithTxtXpath = "//a[text()='Alert with Textbox ']";
	 static String promptXpath = "//button[contains(text(),'click the button to demonstrate the prompt box ')]";
	 public static void alertithText() {
		 try {
			 driver.findElement(By.xpath(alertWithTxtXpath)).click();
			 System.out.println("click on alert with text");
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(promptXpath)).click();
			 Thread.sleep(3000);
			 Alert al =  driver.switchTo().alert();
			 al.sendKeys(Keys.CONTROL+"a");
			 al.sendKeys(Keys.DELETE+"acc");
			 al.accept();
			 System.out.println("accept");
		 }catch(Exception e) {
			 System.out.println("fail"+e.getMessage());
		 }
	 }

	public static void main(String[] args) {
		launchBrowser();
//		clickOnAlertBox();
		alertithText();

	}

}
