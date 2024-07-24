package handleAlertsExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoAutomationAlerts {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://demo.automationtesting.in/Alerts.html";
	static String alertXpath = "//button[contains(text(),'click the button to display an  alert box')]";
	static String alWithTxtXpath = "//a[contains(text(),'Alert with Textbox')]";
	public static void launchChrome() {
		try {
			System.setProperty("webdriver.chrome.driver",chromedriverPath );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			}catch(Exception e) {
			System.out.println("error :"+e.getMessage());	
			}
	}

	public static void alertexmpe() {
		try {
			driver.findElement(By.xpath(alertXpath)).click();
			Thread.sleep(4000);
			System.out.println("click on alert button");
            Alert al = driver.switchTo().alert();
            String txt = al.getText();
            System.out.println("text = "+txt);
            Thread.sleep(4000);
            al.accept();
            System.out.println("accept alert");
            driver.findElement(By.xpath(alWithTxtXpath)).click();
            System.out.println("click on alert with text");
		}catch(Exception e) {
			System.out.println("eroor in alert ="+e.getMessage());
		}
	}
	public static void main(String[] args) {
		launchChrome();
		alertexmpe();

	}

}
