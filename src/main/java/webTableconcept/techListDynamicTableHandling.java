package webTableconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techListDynamicTableHandling {

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
	
	static String cmpnyHeaderXpath = "//table[@id='customers']//tbody//tr//th//span[contains(text(),'Company')]";
	static String contctHeaderXpath = "//table[@id='customers']//tbody//tr//th//span[contains(text(),'Contact')]";
	
	public void getCompanyHeader() {
		try {
			String cheaderText = driver.findElement(By.xpath(cmpnyHeaderXpath)).getText();
			System.out.println("cheaderText = "+cheaderText);
			Thread.sleep(3000);
			String contactHeaderText = driver.findElement(By.xpath(contctHeaderXpath)).getText();
			System.out.println("contactHeaderText = "+contactHeaderText);
		}catch(Exception e) {
			System.out.println("failed at getCompanyHeader "+e.getMessage());
		}
	}
	
	static String tableXpath = "//table[@id='customers']//tbody";
	public void getRowsCount() {
		try {
			WebElement rows = driver.findElement(By.xpath(tableXpath));
			List<WebElement> noOFrOWS =     rows.findElements(By.tagName("tr"));
			System.out.println("no of rows count = "+noOFrOWS.size());
			int rowCount = noOFrOWS.size();
			// to iterate the rows we will take for loo
			
		}catch(Exception e) {
			System.out.println("failed at get rows count"+e.getMessage());
		}
	}
	
	// static element identification using xpath
	static String company1 = "//table[@id='customers']//tbody//tr[7]//td[1]//span";
	static String contact1 = "//table[@id='customers']//tbody//tr[7]//td[2]//span";
	static String country1 = "//table[@id='customers']//tbody//tr[7]//td[3]//span";
	
	public void getcolumnNames() {
		try {
			String companyName = driver.findElement(By.xpath(company1)).getText();
			System.out.println("companyName = "+companyName);
			String contactName = driver.findElement(By.xpath(contact1)).getText();
			System.out.println("contact name = "+contactName);
			String countryName = driver.findElement(By.xpath(country1)).getText();
			System.out.println("country Name = "+countryName);
		}catch(Exception e) {
			System.out.println("error in get column names "+e.getMessage());
		}
		
	}
	
	static String row2XpathVal = "//table[@id='customers']//tbody//tr[2]";
	public void getRowsAndColumns() {
		WebElement rows = driver.findElement(By.xpath(tableXpath));
		List<WebElement> noOFrOWS =     rows.findElements(By.tagName("tr"));
		System.out.println("no of rows count = "+noOFrOWS.size());
		
		int rowCount = noOFrOWS.size();
		System.out.println("rowCount = "+rowCount);
		// for one particular row get columns count
		WebElement columns = driver.findElement(By.xpath(row2XpathVal)); 
		List<WebElement>noOfColumns =  columns.findElements(By.tagName("td"));
		int count = noOfColumns.size();
		System.out.println("no of columns "+count);
		// for a table based on row count get each columns count from each row
		for(int i=2;i<=rowCount;i++) {
			String xpath1 = "//table[@id='customers']//tbody//tr["+i+"]";
			WebElement r = driver.findElement(By.xpath(xpath1));
			 List<WebElement> c =  r.findElements(By.tagName("td"));
			 System.out.println("i ="+i+" columns - "+c.size());
			 for(WebElement name : c) {
				 WebElement txt = name.findElement(By.tagName("span"));
				 System.out.println("text = "+txt.getText());
			 }
			
		}
		
	}
	
	
	public static void main(String[] args) {
		launchChrome();
		techListDynamicTableHandling obj = new techListDynamicTableHandling();
//		obj.getCompanyHeader();
//		obj.getRowsCount();
//		obj.getcolumnNames();
		obj.getRowsAndColumns();
//		driver.close();

	}

}
