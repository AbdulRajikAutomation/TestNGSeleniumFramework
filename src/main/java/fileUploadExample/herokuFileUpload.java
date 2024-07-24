package fileUploadExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class herokuFileUpload {
	static WebDriver driver;
	static String chromedriverPath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String url="https://the-internet.herokuapp.com/upload";

	public static void launchHeroKu() {
		try {
			System.setProperty("webdriver.chrome.driver",chromedriverPath );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			System.out.println("launch Herokuapp ");
			}catch(Exception e) {
			System.out.println("error :"+e.getMessage());	
			}
	}
	public static String filePath="C:\\Users\\admin\\Downloads\\Suresh_Napa_9157135_Offer_Letter_1718382880.pdf";
	public static void fileUploader() {
		try {
			WebElement fuploader = driver.findElement(By.xpath("//input[@id='file-upload']"));
			System.out.println("file upload");
			fuploader.sendKeys(filePath);
			System.out.println("file upload done");
		}catch(Exception e) {
			System.out.println("failed at method file uploader"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchHeroKu();
		fileUploader();
	}

}
