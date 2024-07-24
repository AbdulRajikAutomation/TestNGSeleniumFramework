package webTableconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlistDemoWebTable1 {

	public static WebDriver driver;
	static String chromePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String techListUrl = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(techListUrl);
		System.out.println("launch tech list url");
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		
	}
	
	static String demoTable1Xpath = "//table[@id='customers']//tbody";
	public static void readTableData() {
		try {
			WebElement table1 = driver.findElement(By.xpath(demoTable1Xpath));
			List<WebElement> rows =  table1.findElements(By.tagName("tr"));
			System.out.println("no of rows "+rows.size());
			
			for(int i=2;i<=rows.size();i++) {
				String rowXpath = "//table[@id='customers']//tbody//tr["+i+"]";
				//System.out.println(rowXpath);
				WebElement columns = driver.findElement(By.xpath(rowXpath));
				List<WebElement> col = columns.findElements(By.tagName("td"));
				//System.out.println("columns count ="+col.size());
				
				for(WebElement columnNames : col) {
					String name =columnNames.findElement(By.tagName("span")).getText();
					
					System.out.print(name+" ,");
				}
				System.out.println();
				
			}
			
		}catch(Exception e) {
			System.out.println("error in readTabledata :"+e.getMessage());
		}
	}
	
	
	public static void closeBrowser() {
		try {
			driver.close();
			System.out.println("closing the browser instance");
		}catch(Exception e) {
			System.out.println("error in close browser"+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		launchChrome();
		readTableData();
		closeBrowser();
	}

}
