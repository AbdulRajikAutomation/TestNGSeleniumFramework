package webTableconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techListTableExample {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
	static String compnyXpath = "//span[contains(text(),'Company')]";
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
	
	public static void handleTable() {
		try {
			WebElement comElement = driver.findElement(By.xpath(compnyXpath));
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true)", comElement);
			Thread.sleep(4000);
			System.out.println("scroll into view");
			WebElement table = driver.findElement(By.xpath("//table[@id='customers']//tbody"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("rows count ="+rows.size());
			for(WebElement row : rows) {
				List<WebElement>columns =row.findElements(By.tagName("td"));
				for(WebElement cell : columns) {
					String value = cell.getText();
					System.out.print("value ="+value+" ,");
				}
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
	}
	
	public static void handleDynamicTable() {
		try {
			
		}catch(Exception e) {
			System.out.println("handle dynamic table "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		launchChrome();
		handleTable();
	}

}
